//Sara Gholami (92222087)
package searchbyphonenumber;

public class SearchByPhoneNumber {

    public static void main(String[] args) {
        String path = System.getProperty("java.class.path") + "\\searchbyphonenumber\\";
        FileClass fc = new FileClass(path);
        Search s = new Search(fc.getPhonebook(), fc.getQuery());
        System.out.println("Average searching time is " + s.getCount());
    }

}
