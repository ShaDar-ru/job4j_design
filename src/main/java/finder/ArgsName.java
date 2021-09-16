package finder;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException("Arguments not found.");
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        for (String s : args) {
            s = s.substring(1);
            s = s.replace(" ", "");
            String[] str = s.split("=");
            if (str.length <= 1 || str[1].equals("")) {
                throw new IllegalArgumentException("Arguments not found.");
            }
            values.put(str[0], str[1]);
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }
}
