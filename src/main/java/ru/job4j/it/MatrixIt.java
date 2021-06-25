package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        for (int i = row; i < data.length; i++) {
            if (data[i].length == 0) {
                column = 0;
            }
            for (int j = column; j < data[i].length; j++) {
                column = j;
                return true;
            }
            row = i;
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        for (int i = row; i < data.length; i++) {
            for (int j = column; j < data[i].length; j++) {
                column = j + 1;
                return data[i][j];
            }
            column = 0;
            row = i + 1;
        }
        return null;
    }
}
