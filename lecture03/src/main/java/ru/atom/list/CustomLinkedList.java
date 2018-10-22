package ru.atom.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class CustomLinkedList<E> implements List<E> {

    private ListNode<E> firstNode;
    private ListNode<E> lastNode;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return firstNode == null;
    }

    @Override
    public boolean contains(Object o) {
        if (firstNode == null)
            return false;
        if (firstNode.getValue().equals(o))
            return true;
        if (lastNode.getValue().equals(o))
            return true;
        ListNode<E> currentNode = firstNode;
        do {
            currentNode = currentNode.getNextNode();
            if (currentNode == null)
                return false;
            if (currentNode.getValue().equals(o))
                return true;
        } while (currentNode != null);

        return false;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {
            private ListNode<E> currentNode = firstNode;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public E next() {
                E value = currentNode.getValue();
                currentNode = currentNode.getNextNode();
                return value;
            }
        };

        return it;
    }

    @Override
    public boolean add(E e) {
        if (firstNode == null)
            firstNode = lastNode = new ListNode<>(null, e, null);
        else {
            lastNode = new ListNode<>(lastNode, e, null);
            lastNode.getPrevNode().setNextNode(lastNode);
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (firstNode == null)
            return false;
        if (firstNode.getValue().equals(o)) {
            firstNode = firstNode.getNextNode();
            firstNode.setPrevNode(null);
            size--;
            return true;
        }
        if (lastNode.getValue().equals(o)) {
            lastNode = lastNode.getPrevNode();
            lastNode.setNextNode(null);
            size--;
            return true;
        }
        ListNode<E> currentNode = firstNode;
        do {
            currentNode = currentNode.getNextNode();
            if (currentNode == null)
                return false;
            if (currentNode.getValue().equals(o)) {
                currentNode.getPrevNode().setNextNode(currentNode.getNextNode());
                currentNode.getNextNode().setPrevNode(currentNode.getPrevNode());
                return true;
            }
        } while (currentNode != null);

        return false;
    }

    @Override
    public void clear() {
        firstNode = lastNode = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        if (index > size - 1)
            throw new IndexOutOfBoundsException();
        if (index == 0)
            return firstNode.getValue();
        if (index == size - 1)
            return lastNode.getValue();
        ListNode<E> currentNode = firstNode;
        int indexer = 0;
        do {
            currentNode = currentNode.getNextNode();
            if (currentNode == null)
                return null;
            indexer++;
        } while (indexer != index);

        return currentNode != null ? currentNode.getValue() : null;
    }

    @Override
    public int indexOf(Object o) {
        if (firstNode == null)
            return -1;
        if (firstNode.getValue().equals(o))
            return 0;
        if (lastNode.getValue().equals(o))
            return size - 1;
        int indexer = 1;
        ListNode<E> currentNode = firstNode;
        do {
            currentNode = currentNode.getNextNode();
            if (currentNode == null)
                return -1;
            if (currentNode.getValue().equals(o))
                return indexer;
            indexer++;
        } while (currentNode != null);

        return -1;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E value : c)
            add(value);
        return true;
    }


    /*
      !!! Implement methods below Only if you know what you are doing !!!
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return true;
            }
        }
        return true;
    }

    /**
     * Do not implement
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    /**
     * Do not implement
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    /**
     * Do not implement
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    /**
     * Do not implement
     */
    @Override
    public void add(int index, E element) {
    }

    /**
     * Do not implement
     */
    @Override
    public E remove(int index) {
        return null;
    }

    /**
     * Do not implement
     */
    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    /**
     * Do not implement
     */
    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    /**
     * Do not implement
     */
    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    /**
     * Do not implement
     */
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    /**
     * Do not implement
     */
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    /**
     * Do not implement
     */
    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    /**
     * Do not implement
     */
    @Override
    public E set(int index, E element) {
        return null;
    }
}
