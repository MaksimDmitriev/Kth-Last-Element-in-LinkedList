package com.app;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test(expected = IllegalArgumentException.class)
    public void negativeIndex() {
        Solution solution = new Solution();
        Solution.LinkedList linkedList = new Solution.LinkedList();
        linkedList.append(1);
        solution.kthLastElement(linkedList, -1);
    }

    @Test(expected = IllegalStateException.class)
    public void emptyList() {
        Solution solution = new Solution();
        Solution.LinkedList linkedList = new Solution.LinkedList();
        solution.kthLastElement(linkedList, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void kGreaterThanListSize() {
        Solution solution = new Solution();
        Solution.LinkedList linkedList = new Solution.LinkedList();
        linkedList.append(1);
        solution.kthLastElement(linkedList, 3);
    }

    @Test
    public void secondFromTail() {
        Solution solution = new Solution();
        Solution.LinkedList linkedList = new Solution.LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);

        assertEquals(4, solution.kthLastElement(linkedList, 2));
    }

    @Test
    public void lastFromTail() {
        Solution solution = new Solution();
        Solution.LinkedList linkedList = new Solution.LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);

        assertEquals(1, solution.kthLastElement(linkedList, 5));
    }

    @Test
    public void firstFromTail() {
        Solution solution = new Solution();
        Solution.LinkedList linkedList = new Solution.LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);

        assertEquals(6, solution.kthLastElement(linkedList, 0));
    }
}