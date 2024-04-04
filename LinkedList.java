import java.util.ArrayList;
public class LinkedList {
    TeamNode head;
    TeamNode tail;
    LinkedList() {
        head = null;
        tail = null;
    }
    // creates a linked list with a head and tail
    //inserts node into list
    public void insertNode(BaseballTeam team){
        TeamNode node = new TeamNode(team);
        if (head == null){
            head = node;
        }
        else {
            tail.setNext(node);
        }
        tail = node;
    }
    // searches if string name matches any of team node names in linked list, returns node that does
    public TeamNode findNode(String teamName){
        TeamNode current = head;
        while (current != null) {
            if (current.getTeam().getName().equals(teamName)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }
    // returns name of every team in league
    public String printLeague(){
        String teams = "";
        TeamNode current = head;
        while (current != null){
            String name = current.getTeam().getName();
            teams += name;
            teams += ", ";
            current = current.getNext();
        }
        return teams;
    }
    //removes the team after the name given
    public void removeAfter(TeamNode node){
        if (node == null) {
            return;
        }
        if (node.getNext() == null){
            return;
        }
        TeamNode nodeToRemove = node.getNext();
        node.setNext(nodeToRemove.getNext());
        nodeToRemove.setNext(null);
    }
    //copies the list into another
    public LinkedList copy() {
        LinkedList newList = new LinkedList();
        TeamNode current = head;
        while (current != null) {
            newList.insertNode(new BaseballTeam(current.getTeam().getName(),
                    current.getTeam().getCity(),
                    current.getTeam().getPlayers(),
                    current.getTeam().getSalaryCap()));
            current = current.getNext();
        }
        return newList;
    }
    //returns the length of the linked list
    public int length() {
        int count = 0;
        TeamNode current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }
    //takes a string team name as a parameter and removes every team with that name
    public void removeDuplicate(String name) {
        TeamNode current = head;
        TeamNode previous = null;
        while (current != null) {
            if (current.getTeam().getName().equals(name)) {
                if (previous == null) {
                    head = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                if (current == tail) {
                    tail = previous;
                }
                current = current.getNext();
            } else {
                previous = current;
                current = current.getNext();
            }
        }
    }
    //returns the team with the highest salary
    public int max(TeamNode node){
        int maxSalary = 0;
        TeamNode current = node;
        if (current == null){
            return maxSalary;
        }
        while (current != null) {
            if (current.getTeam().getSalaryCap() > maxSalary) {
                maxSalary = current.getTeam().getSalaryCap();
            }
            current = current.getNext();
        }
        return maxSalary;
    }
}
