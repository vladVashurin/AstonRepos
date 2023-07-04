package com.vld.array;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class AstArrayList<E> implements AstList<E> {
    private int capacity = 10;
    private Object[] array = new Object[capacity];
    private int size = 0;


    @Override
    public boolean add(E element) {
        growCapacity();
        array[size] = element;
        size++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        checkIndexWithoutEqual(index);
        growCapacity();
        rightShift(index, element);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] o = c.toArray();
        for (int i = 0; i < c.size(); i++) {
            add(size, (E) o[i]);
        }
        return true;
    }

    @Override
    public boolean clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
        return true;
    }

    @Override
    public E get(int index) {
        checkIndexWithEqual((index));
        return (E) array[index];
    }

    @Override
    public boolean isEmpty() {
        boolean isEmpty = true;
        for (int i = 0; i < size; i++) {
            if (array[i] != null) {
                isEmpty = false;
            }
        }
        return isEmpty;
    }

    @Override
    public E remove(int index) {
        E element = get(index);
        checkIndexWithoutEqual(index);
        leftShift(index);
        return element;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o) && array[i] != null) {
                leftShift(i);
                break;
            }
        }
        return true;
    }

    @Override
    public void sort(Comparator<? super E> c) {
        quickSort(array, c, 0, size() - 1);
    }

    public int size() {
        return size;
    }

    private void growCapacity() {
        if (checkCapacity()) {
            int newCapacity = array.length * 3 / 2 + 1;
            array = Arrays.copyOf(array, newCapacity);
            capacity = newCapacity;
        }
    }

    private boolean checkCapacity() {
        return capacity <= size * 100 / 75;
    }

    private void checkIndexWithEqual(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }

    private void checkIndexWithoutEqual(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }

    private void leftShift(int index) {
        System.arraycopy(array, index + 1, array, index, size - 1 - index);
        size--;
        array[size] = null;
    }

    private void rightShift(int index, E element) {
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    private <E> void quickSort(Object[] S, Comparator<E> comp, int a,
                               int b) {
        if (a >= b)
            return;
        int left = a;
        int right = b - 1;
        E pivot = (E) S[b];
        E temp;
        while (left <= right) {
            while (left <= right && comp.compare((E) S[left], pivot) < 0)
                left++;
            while (left <= right && comp.compare((E) S[right], pivot) > 0)
                right--;
            if (left <= right) {
                temp = (E) S[left];
                S[left] = S[right];
                S[right] = temp;
                left++;
                right--;
            }
        }
        temp = (E) S[left];
        S[left] = S[b];
        S[b] = temp;
        quickSort(S, comp, a, left - 1);
        quickSort(S, comp, left + 1, b);
    }

    public boolean contains(Object o) {
        boolean contains = false;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                contains = true;
                break;
            }
        }
        return contains;
    }
}

