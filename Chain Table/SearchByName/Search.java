package searchbyname;

public class Search {

    private final List[] phonebook;
    private final Person[] query;
    private int count;
    HashString hs;

    public Search(List[] phonebook, Person[] query) {
        this.phonebook = phonebook;
        this.query = query;
        count = 0;
        hs = new HashString();
        searching();
    }

    private void searching() {
        for (Person person : query) {
            String name = person.getName();
            int hash = hs.getHash(name);
            count = phonebook[hash].search(person) + count;
        }
    }

    public double getCount() {
        return count / 1000.0;
    }
}
