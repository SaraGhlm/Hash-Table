//Sara Gholami (92222087)
package searchbyname;

public class SearchByName {

    public static void main(String[] args) {
        String path = System.getProperty("java.class.path") + "\\searchbyname\\";
        FileClass fc = new FileClass(path);
        Search s = new Search(fc.getPhonebook(), fc.getQuery());
        System.out.println("Average searching time is " + s.getCount());
    }

}
