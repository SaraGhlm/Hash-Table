package searchbyname;

public class Search {
    
    private final Person[] phonebook;
    private final Person[] query;
    private int count;
    HashString hs;
    
    public Search(Person[] phonebook, Person[] query) {
        this.phonebook = phonebook;
        this.query = query;
        count = 0;
        hs = new HashString();
        doSearch();
    }
    
    private void doSearch(){
        for (Person person : query) {
            String name = person.getName();
            count = searching(name) + count;
        }
    }
    
    private int searching(String name) {
        int j;
        int i = 0; 
        do{
            j = Hash(name, i);
            if(phonebook[j].getName().equals(name)){
                return i;
            }
        }while(i!= phonebook.length && phonebook[j]!=null);
        return i;
    }
    
    private int Hash(String input, int i){
        return hs.getHash1(input) + i * hs.getHash2(input) % 500009;
    }
    
    public double getCount() {
        return count / 1000.0;
    }
}
