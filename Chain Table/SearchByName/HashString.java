package searchbyname;

public class HashString {

    private int Hash(String input) {
        int hash = 0;
        for (int i = 0; i < input.length(); i++) {
            hash = (hash * 31 + input.charAt(i)) % 300007;
        }
        return hash;
    }

    public int getHash(String input) {
        return Hash(input);
    }
}
