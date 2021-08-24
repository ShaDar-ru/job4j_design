package ru.job4j.question;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class Analize {
    private static int analize(Map<Integer, String> map, Predicate<Integer> predicate) {
        int rsl = 0;
        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (!predicate.test(i)) {
                rsl++;
                it.remove();
            }
        }
        return rsl;
    }

    private static Map<Integer, String> convertToMap(Set<User> users) {
        Map<Integer, String> rsl = new HashMap<>();
        for (User u : users) {
            rsl.put(u.getId(), u.getName());
        }
        return rsl;
    }

    public static Info diff(Set<User> previous, Set<User> current) {
        Map<Integer, String> prev = convertToMap(previous);
        Map<Integer, String> curr = convertToMap(current);
        int added = analize(curr, prev::containsKey);
        int deleted = analize(prev, curr::containsKey);
        int changed = analize(curr, (x) -> prev.get(x).equals(curr.get(x)));
        return new Info(added, changed, deleted);
    }
}
