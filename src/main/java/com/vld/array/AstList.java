package com.vld.array;

import java.util.Collection;
import java.util.Comparator;

public interface AstList<E> {
    /**
     * Функция добавления элемента в список
     *
     * @return {@code true} если список изменился в результате вызова
     */
    boolean add(E element);

    /**
     * Функция добавления объекта в список
     *
     * @param index - индекс преполагаемой позиции элемента
     * @throws IndexOutOfBoundsException
     */
    void add(int index, E element);

    /**
     * Функция добавления коллекции в список
     *
     * @return возвращает {@code true}
     * если лист изменился в результате вызова;
     */
    boolean addAll(Collection<? extends E> c);

    boolean clear();

    /**
     * Функция возвращения объекта из списка
     *
     * @param index - индекс объекта
     * @return возвращает объект из списка
     * @throws IndexOutOfBoundsException
     */
    E get(int index);

    /**
     * Функция проверяет пуст список или нет
     *
     * @return {@code true} если список пуст
     */
    boolean isEmpty();

    /**
     * Функция удаления объекта из списка
     *
     * @param index - индекс объекта
     * @return возвращает объект из списка
     * @throws IndexOutOfBoundsException
     */
    E remove(int index);

    /**
     * Функция удаления объекта из списка
     *
     * @return {@code true} если список был изменен
     */
    boolean remove(Object o);

    /**
     * Функция сортировки списка, сортирует список по заданному компаратору
     */
    void sort(Comparator<? super E> c);

    /**
     * Функция проверки объекта на нахождение в списке
     *
     * @return {@code true} если список содержит объект
     */
    boolean contains(Object o);
}

