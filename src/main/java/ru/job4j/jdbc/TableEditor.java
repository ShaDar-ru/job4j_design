package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        try {
            initConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = properties.getProperty("url");
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");
        connection = DriverManager.getConnection(url, login, password);
    }

    public static Properties setProperties(String path) {
        Properties properties = new Properties();
        ClassLoader classLoader = TableEditor.class.getClassLoader();
        try (InputStream in = classLoader.getResourceAsStream(path)) {
            properties.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    private void sendMessage(String sql) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName) {
        sendMessage(String.format(
                "create table if not exists %s(%s);",
                tableName,
                "id serial primary key"
        ));
    }

    public void dropTable(String tableName) {
        sendMessage(String.format(
                "drop table %s;",
                tableName
        ));
    }

    public void addColumn(String tableName, String columnName, String type) {
        sendMessage(String.format(
                "ALTER TABLE %s ADD COLUMN %s %s;",
                tableName, columnName, type
        ));
    }

    public void dropColumn(String tableName, String columnName) {
        sendMessage(String.format(
                "ALTER TABLE %s DROP COLUMN %s;",
                tableName, columnName
        ));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        sendMessage(String.format(
                "ALTER TABLE %s RENAME %s TO %s",
                tableName, columnName, newColumnName
        ));
    }


    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        try (TableEditor editor = new TableEditor(TableEditor.setProperties("app.properties"))) {
            editor.createTable("test_table");
            System.out.println(TableEditor.getTableScheme(editor.connection, "test_table"));
            editor.addColumn("test_table", "test_column", "varchar(255)");
            System.out.println(TableEditor.getTableScheme(editor.connection, "test_table"));
            editor.renameColumn("test_table", "test_column", "new_name_column");
            System.out.println(TableEditor.getTableScheme(editor.connection, "test_table"));
            editor.dropColumn("test_table", "new_name_column");
            System.out.println(TableEditor.getTableScheme(editor.connection, "test_table"));
            editor.dropTable("test_table");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

