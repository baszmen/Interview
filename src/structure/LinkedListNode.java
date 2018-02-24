package structure;

public class LinkedListNode<T> {
    public LinkedListNode<T> next;
    public T value;

    public LinkedListNode() { }

    public LinkedListNode(T value) {
        this.value = value;
    }

    public LinkedListNode(LinkedListNode<T> next, T value) {
        this(value);
        this.next = next;
    }
}
