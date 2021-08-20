package ru.job4j.collection.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Predicate;

public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        if (this.findBy(parent).isPresent() && this.findBy(child).isEmpty()) {
            if (parent.equals(root)) {
                root.children.add(new Node<>(child));
            } else {
                this.findBy(parent).get().children.add(new Node<>(child));
            }

            return true;
        }
        return false;
    }

    @Override
    public Optional<Tree.Node<E>> findBy(E value) {
        Optional<Tree.Node<E>> rsl = Optional.empty();
        Queue<Tree.Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Tree.Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}
