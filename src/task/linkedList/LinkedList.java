package task.linkedList;

import structure.LinkedListNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LinkedList<T> {
    public LinkedListNode<Integer> add(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
        LinkedListNode<Integer> node = new LinkedListNode<>();
        int sum = 0;
        int carry = 0;

        while (first != null || second != null) {
            sum = 0;
            sum += carry;
            if (first != null) sum += first.value;
            if (second != null) sum += second.value;

            if (sum >= 10) {
                sum = sum % 10;
                carry = 1;
            }

            node.value = sum;
            node.next = new LinkedListNode<>();
            node = node.next;

            if (first != null)
                first = first.next;
            if (second != null)
                second = second.next;

        }

        return node;
    }

    public LinkedListNode<T> removeDuplicates(LinkedListNode<T> head) {
        LinkedListNode<T> pointer = head;
        Set<T> duplicates = new HashSet<>();

        while (pointer != null) {
            if (duplicates.contains(pointer.value)) {
                pointer.next = pointer.next.next;
            } else {
                duplicates.add(pointer.value);
            }

            pointer = pointer.next;
        }

        return head;
    }

    public LinkedListNode<T> removeDuplicatesNoBuffer(LinkedListNode<T> head) {
        LinkedListNode<T> pointer = head;

        while (pointer != null) {
            LinkedListNode<T> searchPointer = pointer;
            while (searchPointer.next != null) {
                if (searchPointer.next.value == pointer.value) {
                    searchPointer.next = searchPointer.next.next;
                } else {
                    searchPointer = searchPointer.next;
                }
            }

            pointer = pointer.next;
        }

        return head;
    }

    public LinkedListNode<T> kthElemetFromEnd(LinkedListNode<T> head, int k) {
        LinkedListNode<T> firstPointer = head;
        LinkedListNode<T> secondPointer = head;

        for (int i = 0; i < k; i++) {
            if (secondPointer == null) return null;
            secondPointer = secondPointer.next;
        }

        while (secondPointer != null) {
            secondPointer = secondPointer.next;
            firstPointer = firstPointer.next;
        }

        return firstPointer;
    }

    public int kthElementFromEndRecursive(LinkedListNode<T> node, int k) {
        if (node == null) return 0;

        int index = kthElementFromEndRecursive(node.next, k) + 1;

        if (index == k) {
            System.out.println("Kth element is " + node.value);
        }

        return index;
    }

    public boolean isLinkedListPalindromInPlace(LinkedListNode<T> node) {
        LinkedListNode<T> slowRunner = node;
        LinkedListNode<T> fastRunner = node;

        Stack<T> slowData = new Stack<>();

        while (fastRunner != null && fastRunner.next != null) {
            slowData.push(slowRunner.value);
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
        }

        if (fastRunner != null)
            slowRunner = slowRunner.next;

        while (slowRunner != null) {
            if (slowRunner.value != slowData.pop())
                return false;
            slowRunner = slowRunner.next;
        }

        return true;
    }

    public boolean isLinkedListPalindrom(LinkedListNode<T> node) {
        LinkedListNode<T> reverseNode = node;
        reverseNode = reverse(reverseNode);

        while (node != null && reverseNode != null) {
            if (node.value != reverseNode.value) return false;
            node = node.next;
            reverseNode = reverseNode.next;
        }

        return true;
    }

    public LinkedListNode<T> reverse(LinkedListNode<T> node) {
        LinkedListNode<T> head = null;

        while (node != null) {
            LinkedListNode<T> n = new LinkedListNode<>(node.value);
            n.next = head;
            head = n;
            node = node.next;
        }

        return head;
    }

    public int getSize(LinkedListNode<T> head) {
        int size = 0;
        while (head != null) {
            size ++;
            head = head.next;
        }

        return size;
    }

    public void printLinkedList(LinkedListNode<T> node) {
        while (node != null) {
            System.out.print(node.value + " -> ");
            node = node.next;
        }
    }
}
