package searchbyname;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileClass {

    private final File names;
    private final File query;
    private int[] queryArray;
    private final List[] phonebook;
    private final HashString hs;
    private final Person[] personArray;
    private int count;

    public FileClass(String path) {
        names = new File(path + "names.txt");
        query = new File(path + "query.txt");
        if (!query.exists()) {
            try {
                query.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        queryArray = new int[1002];
        createArray();
        phonebook = new List[300007];
        initPhonebook();
        hs = new HashString();
        createQuery();
        personArray = new Person[1000];
        count = 0;
        readQuery();
    }

    public Person[] getQuery() {
        return personArray;
    }

    public List[] getPhonebook() {
        return phonebook;
    }

    private void createArray() {
        for (int i = 1; i < 1001; i++) {
            Random rand = new Random();
            int line = rand.nextInt(1000000);
            for (int j = 1; j < i; j++) {
                if (line == queryArray[j]) {
                    line = rand.nextInt(1000000);
                    j = 1;
                }
            }
            queryArray[i] = line;
        }
        QuickSort qs = new QuickSort(1, queryArray.length - 2, queryArray);
        queryArray = qs.getArray();
    }

    private void initPhonebook() {
        for (int i = 0; i < phonebook.length; i++) {
            List l = new List();
            phonebook[i] = l;
        }
    }

    private void createQuery() {
        BufferedReader br;
        FileWriter fw;
        BufferedWriter bw;
        try {
            br = new BufferedReader(new FileReader(names.getAbsoluteFile()));
            fw = new FileWriter(query.getAbsoluteFile());
            bw = new BufferedWriter(fw);
            int i = queryArray[1];
            int k = 1;
            for (int j = 0; j < 1000000; j++) {
                String current = br.readLine();
                String temp = current;
                current = current.replaceAll(" ", "");
                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcher = pattern.matcher(current);
                if (matcher.find()) {
                }
                int index = matcher.start();
                String[] s = new String[2];
                s[0] = current.substring(0, index - 1);
                s[1] = current.substring(index);
                int hash = hs.getHash(s[0]);
                Person p = new Person(s[0], Integer.parseInt(s[1]));
                phonebook[hash].insert(p);
                if (j == i) {
                    bw.write(temp + "\n");
                    k++;
                    i = queryArray[k];
                }
            }
            bw.close();
        } catch (IOException e) {
            Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void readQuery() {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(query.getAbsoluteFile()));
            String current;
            while ((current = br.readLine()) != null) {
                current = current.replaceAll(" ", "");
                Pattern pattern = Pattern.compile("\\d+");
                Matcher matcher = pattern.matcher(current);
                if (matcher.find()) {
                }
                int index = matcher.start();
                String[] s = new String[2];
                s[0] = current.substring(0, index - 1);
                s[1] = current.substring(index);
                Person p = new Person(s[0], Integer.parseInt(s[1]));
                personArray[count++] = p;
            }
        } catch (IOException e) {
            Logger.getLogger(FileClass.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
