package searchbynumber;

public class Search {

    private final Person[] phonebook;
    private final Person[] query;
    private int count;
    HashNumber hs;
    
    public Search(Person[] phonebook, Person[] query) {
        this.phonebook = phonebook;
        this.query = query;
        count = 0;
        hs = new HashNumber();
        doSearch();
    }
    
    private void doSearch(){
        for (Person person : query) {
            int phone = person.getPhoneNumber();
            count = searching(phone) + count;
        }
    }
    
    private int searching(int phone) {
        int j;
        int i = 0; 
        do{
            j = Hash(phone, i);
            if(phonebook[j].getPhoneNumber() == phone){
                return i;
            }
        }while(i!= phonebook.length && phonebook[j]!=null);
        return i;
    }
    
    private int Hash(int input, int i){
        return hs.getHash1(input) + i * hs.getHash2(input) % 500009;
    }
    
    public double getCount() {
        return count / 1000.0;
    }
}
