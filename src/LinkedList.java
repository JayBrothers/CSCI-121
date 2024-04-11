public class LinkedList {
    TNode head;
    TNode tail;

    LinkedList() {
        head = null;
        tail = null;
    }

    // creates a linked list with a head and tail
    //inserts node into list
    public void insertNode(transaction trans) {
        TNode node = new TNode(trans);
        if (head == null) {
            head = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
    }
    public TNode findNode(Date date){
        TNode current = head;
        while (current != null) {
            if (current.getTrans().getDate().equals(date)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }
    public String printLeague(){
        LinkedList transactions = ;
        TNode current = head;
        while (current != null){
            LinkedList log = current.getTransactionLog();
            transactions += log;
            teams += ", ";
            current = current.getNext();
        }
        return teams;
    }
}