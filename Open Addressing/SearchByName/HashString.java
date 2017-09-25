package searchbyname;

public class HashString {

    private int Hash1(String input) {
        int hash = 0;
        for (int i = 0; i < input.length(); i++) {
            hash = (hash * 31 + input.charAt(i)) % 1000200;
        }
        return hash;
    }

    private int Hash2(String input) {
        int hash = 0;
        for (int i = 0; i < input.length(); i++) {
            hash = (hash * 31 + input.charAt(i)) % 1000200;
        }
        return hash;
    }

    public int getHash1(String input) {
        return Hash1(input);
    }

    public int getHash2(String input) {
        return Hash2(input);
    }
}
