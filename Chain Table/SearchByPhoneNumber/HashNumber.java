package searchbyphonenumber;

public class HashNumber {
    
//    private int Hash(int phone) {
//        String input = String.valueOf(phone);
//        int hash = 0;
//        for (int i = 0; i < input.length(); i++) {
//            hash = ((hash * 31 + input.charAt(i)) % 500009);
//        }
//        return hash;
//    }
    
//    private int Hash(int x){
//        x = ((x >>> 16) ^ x) * 0x45d9f3b;
//        x = ((x >> 16) ^ x) * 0x45d9f3b;
//        x = ((x >> 16) ^ x);
//        return x% 500009;
//    }
    
    private int Hash(int phone){
        double A = (Math.sqrt(5)-1)/2;
        int hash = (int) Math.floor((phone * A % 1) * 524288);
        return hash;
    }
        
    public int getHash(int phone) {
        return Hash(phone);
    }
}
