package ru.atom.list;

import java.util.Objects;

/**
 * Contains ref to next node, prev node and value
 */
public class ListNode<E> {

    public ListNode<E> getNextNode() {
        return nextNode;
    }

    public ListNode<E> getPrevNode() {
        return prevNode;
    }

    public E getValue() {
        return value;
    }

    public void setNextNode(ListNode<E> nextNode) {
        this.nextNode = nextNode;
    }

    public void setPrevNode(ListNode<E> prevNode) {
        this.prevNode = prevNode;
    }

    public void setValue(E value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode<?> listNode = (ListNode<?>) o;
        return Objects.equals(value, listNode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public ListNode(ListNode<E> prevNode, E value, ListNode<E> nextNode) {
        this.prevNode = prevNode;
        this.value = value;
        this.nextNode = nextNode;
    }

    private ListNode<E> nextNode;
    private ListNode<E> prevNode;
    private E value;

}
