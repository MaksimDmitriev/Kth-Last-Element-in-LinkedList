package com.app;

public class Solution {

    public int kthLastElement(LinkedList linkedList, int k) {
        if (k < 0) {
            throw new IllegalArgumentException("negative index given");
        }
        if (linkedList.size == 0) {
            throw new IllegalStateException("empty list");
        }
        if (k >= linkedList.size) {
            throw new IndexOutOfBoundsException();
        }
        Node result = new Node(0);
        kthLastElementInternal(linkedList.size, linkedList.head.next, 0, k, result);
        return result.val;
    }

    private void kthLastElementInternal(int listSize, Node current, int currentIndex, int k, Node result) {
        if (listSize - k - 1 == currentIndex) {
            result.val = current.val;
        } else {
            kthLastElementInternal(listSize, current.next, currentIndex + 1, k, result);
        }
    }

    public static class LinkedList {

        private int size = 0;
        private Node head = new Node(0); // dummy node
        private Node tail = head; // not a dummy node

        void append(int val) {
            Node node = new Node(val);
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
            size++;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof LinkedList)) {
                return false;
            }
            LinkedList other = (LinkedList) o;
            Node node = head.next;
            Node otherNode = other.head.next;
            while (node != null && otherNode != null) {
                if (node.val == otherNode.val) {
                    node = node.next;
                    otherNode = otherNode.next;
                } else {
                    return false;
                }
            }
            return node == null && otherNode == null;
        }

        @Override
        public int hashCode() {
            int res = 17;
            Node node = head.next;
            while (node != null) {
                res = 31 * res + node.val;
                node = node.next;
            }
            return res;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            Node node = head.next;
            while (node != null) {
                builder.append(node.val);
                if (node.next != null) {
                    builder.append(" > ");
                }
                node = node.next;
            }
            builder.append("]");
            return builder.toString();
        }
    }

    public static class Node {

        Node prev;
        Node next;
        int val;

        Node(int val) {
            this.val = val;
        }

    }
}