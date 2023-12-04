package src;

import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {
    class FakeNode {
        FakeNode(FakeNode next, FakeNode prev) {
            this.next = next;
            this.prev = prev;
        }

        public FakeNode next;
        public FakeNode prev;
    }

    class Node extends FakeNode {
        Node(FakeNode next, FakeNode prev, Transaction value) {
            super(next, prev);
            this.value = value;
        }

        public Transaction value;
    }

    private FakeNode fakeNode;
    private FakeNode currentNode;
    private int size;

    public TransactionsLinkedList() {
        fakeNode = new Node(null, null, null);

        currentNode = fakeNode;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void addTransaction(Transaction newTransaction) {
        Node temp = new Node(null, null, newTransaction);
        currentNode.next = temp;
        temp.prev = currentNode;
        temp.next = fakeNode;
        fakeNode.prev = temp;
        currentNode = temp;
        size++;
    }

    @Override
    public void removeTransactionByID(UUID id) {
        Node currentPos = (Node) fakeNode.next;
        while (currentPos.value != null) {
            if (currentPos.value.getId().equals(id)) {
                currentPos.prev.next = currentPos.next;
                currentPos.next.prev = currentPos.prev;
                size--;
                return;
            }
            currentPos = (Node) currentPos.next;
        }
        throw new TransactionNotFoundException("Oops! Transaction is not found!");
    }

    @Override
    public Transaction[] toArray() {
        Transaction[] array = new Transaction[size];
        Node currentPos = (Node) fakeNode.next;
        for (int i = 0; i != size; i++) {
            array[i] = currentPos.value;
            currentPos = (Node) currentPos.next;
        }
        return array;
    }

    Transaction getTransactionByUUID(UUID uuid) {
        Node currentPos = (Node) fakeNode.next;
        while (currentPos.value != null) {
            if (currentPos.value.getId().equals(uuid)) {
                return currentPos.value;
            }
            currentPos = (Node) currentPos.next;
        }
        throw new TransactionNotFoundException("Oops! Transaction is not found!");
    }
}
