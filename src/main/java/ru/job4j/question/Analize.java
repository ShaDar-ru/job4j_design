package ru.job4j.question;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Info info = new Info(0, 0, 0);
        Map<Integer, String> prev = new HashMap<>();
        previous.forEach(x -> prev.put(x.getId(), x.getName()));
        for (User u : current) {
            var curr = prev.remove(u.getId());
            if (curr == null) {
                info.setAdded(info.getAdded() + 1);
            } else {
                if (!curr.equals(u.getName())) {
                    info.setChanged(info.getChanged() + 1);
                }
            }
        }
        info.setDeleted(prev.size());
        return info;
    }
}
