package com.vld.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AstArrayListTest {
    private static AstArrayList<Integer> list;

    @BeforeEach
    public void init() {
        list = new AstArrayList<>();
    }

    @org.junit.jupiter.api.Test
    void add() {
        list.add(1);
        assertEquals(1, list.size());
    }

    @org.junit.jupiter.api.Test
    void testAddByIndex() {
        Integer num = 2;
        list.add(0, num);
    }

    @org.junit.jupiter.api.Test
    void tesAddByIndexException() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(1, 5);
        });
    }

    @org.junit.jupiter.api.Test
    void addAll() {
        List<Integer> added = List.of(1, 2, 3, 4, 5, 6);
        list.addAll(added);
        assertEquals(added.size(), list.size());
    }

    @org.junit.jupiter.api.Test
    void clear() {
        List<Integer> added = List.of(1, 2, 3, 4, 5, 6);
        list.addAll(added);
        list.clear();
        assertTrue(list.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void get() {
        Integer integer = 5;
        list.add(integer);
        assertEquals(integer, list.get(0));
    }

    @org.junit.jupiter.api.Test
    void getException() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(5);
        });
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertTrue(list.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void removeByObject() {
        Integer n = 2;
        list.addAll(List.of(1, 2, 3, 4, 5));
        list.remove(n);
        assertFalse(list.contains(n));
    }

    @org.junit.jupiter.api.Test
    void removeByIndex() {
        Integer n = 5;
        list.addAll(List.of(1, 2, 5, 4, 6));
        list.remove(2);
        assertFalse(list.contains(n));
    }

    @org.junit.jupiter.api.Test
    void removeByIndexException() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(5);
        });
    }

    @org.junit.jupiter.api.Test
    void sort() {
        list.addAll(List.of(5, 1, 2, 6, 7));
        list.sort((o1, o2) -> o1.compareTo(o2));
        int[] array = new int[]{1, 2, 5, 6, 7};
        boolean res = true;
        for (int i = 0; i < list.size(); i++) {
            if (array[i] != list.get(i)) {
                res = false;
            }
        }
        assertTrue(res);
    }

    @org.junit.jupiter.api.Test
    void size() {
        list.add(1);
        list.add(2);
        assertEquals(2, list.size());
    }
}