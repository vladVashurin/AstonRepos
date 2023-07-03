package com.vld.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class AstArrayListTest {
private static AstArrayList<Integer>list;
@BeforeEach
public void init(){
    list = new AstArrayList<>();
}
    @org.junit.jupiter.api.Test
    void addWhithoutIndex() {
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
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, ()->{
            list.add(1, 5);
        });
    }

    @org.junit.jupiter.api.Test
    void addAll() {

    }

    @org.junit.jupiter.api.Test
    void clear() {
    }

    @org.junit.jupiter.api.Test
    void get() {
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
    }

    @org.junit.jupiter.api.Test
    void remove() {
    }

    @org.junit.jupiter.api.Test
    void testRemove() {
    }

    @org.junit.jupiter.api.Test
    void sort() {
    }

    @org.junit.jupiter.api.Test
    void size() {
    }
}