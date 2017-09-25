package searchbyphonenumber;

public class List {

    private Person head;

    public List() {
        head = null;
    }

    public void insert(Person p) {
        if (head == null) {
            head = p;
        } else {
            p.setNext(head);
            head = p;
        }
    }

    public int search(Person p) {
        Person current = head;
        int count = 1;
        while (current != null) {
            if (current.getName().equals(p.getName())) {
                break;
            }
            count++;
            current = current.getNext();
        }
        return count;
    }
}
