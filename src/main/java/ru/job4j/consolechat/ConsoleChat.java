package ru.job4j.consolechat;

import java.io.*;
import java.util.*;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 01.09.2021
 */
public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    private final List<String> botAnswer;
    private final List<String> log = new LinkedList<>();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
        botAnswer = readPhrases();
    }

    public void run() {
        boolean run = true;
        boolean answer = true;
        while (run) {
            String userStr = readLine();
            log.add("User: " + userStr + System.lineSeparator());
            if (userStr.equals(OUT)) {
                close();
                answer = false;
                run = false;
            }
            if (userStr.equals(STOP)) {
                answer = false;
            }
            if (userStr.equals(CONTINUE)) {
                answer = true;
            }
            if (answer) {
                String botStr = readPhrase(botAnswer);
                System.out.println("J.A.R.V.I.S.: " + botStr);
                log.add("J.A.R.V.I.S.: " + botStr + System.lineSeparator());
            }
        }
    }

    private String readLine() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }


    private List<String> readPhrases() {
        List<String> text = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(botAnswers))) {
            String s = in.readLine();
            while (s != null) {
                text.add(s);
                s = in.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    private String readPhrase(List<String> phrases) {
        Random rnd = new Random();
        int random = rnd.nextInt(phrases.size());
        return phrases.get(random);
    }

    private void close() {
        saveLog(log);
    }

    private void saveLog(List<String> log) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter((path)))) {
            for (String s : log) {
                out.write(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("data/ChatLog", "data/pair_with_comment.properties");
        cc.run();
    }
}
