package searchbynumber;

public class HashNumber {

    private int Hash1(int x) {
        x = ((x >> 16) ^ x) * 0x45d9f3b;
        x = ((x >> 16) ^ x) * 0x45d9f3b;
        x = ((x >> 16) ^ x);
        if(x<0){
            x = x * -1;
        }
        return x % 1000200;
    }

    private int Hash2(int key) {
        key = ~key + (key << 15); // key = (key << 15) - key - 1;
        key = key ^ (key >>> 12);
        key = key + (key << 2);
        key = key ^ (key >>> 4);
        key = key * 2057; // key = (key + (key << 3)) + (key << 11);
        key = key ^ (key >>> 16);
        if(key < 0){
            key = key * -1;
        }
        return key % 1000200;
    }

    public int getHash1(int input) {
        return Hash1(input);
    }

    public int getHash2(int input) {
        return Hash2(input);
    }
}
