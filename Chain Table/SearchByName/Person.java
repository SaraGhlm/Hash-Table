package searchbyname;

public class Person {

    private final String name;
    private final int phoneNumber;
    private Person next;

    public Person() {
        this.name = null;
        this.phoneNumber = 0;
    }

    public Person(String name, int phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setNext(Person next) {
        this.next = next;
    }

    public Person getNext() {
        return next;
    }
}
