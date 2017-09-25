package searchbyphonenumber;

public class Search {
    
    private final List[] phonebook;
    private final Person[] query;
    private int count;
    HashNumber hs;

    public Search(List[] phonebook, Person[] query) {
        this.phonebook = phonebook;
        this.query = query;
        count = 0;
        hs = new HashNumber();
        searching();
    }

    private void searching() {
        for (Person person : query) {
            int hash = hs.getHash(person.getPhoneNumber());
            count = phonebook[hash].search(person) + count;
        }
    }

    public double getCount() {
        return count / 1000.0;
    }
}
