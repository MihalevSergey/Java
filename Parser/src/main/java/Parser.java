
import com.sun.org.apache.xalan.internal.xsltc.dom.UnionIterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.smartcardio.ATR;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Parser {
    private static final String FILE = "D:/Art/Books/From AI to Zombies.txt";
    private static final String OUT_FILE = "D:/Art/Books/Sorted From AI to Zombies.txt";


    public static void main(String[] args) throws IOException {


        ArrayList<String> listOfSeparators = new ArrayList<String>();
        listOfSeparators.add(" ");
        listOfSeparators.add("  ");
        listOfSeparators.add("   ");
        listOfSeparators.add("_");
        listOfSeparators.add("~");
        listOfSeparators.add("\\");
        listOfSeparators.add("/");
        listOfSeparators.add(",");
        listOfSeparators.add(".");
        listOfSeparators.add("!");
        listOfSeparators.add("?");
        listOfSeparators.add("(");
        listOfSeparators.add(")");
        listOfSeparators.add("[");
        listOfSeparators.add("]");
        listOfSeparators.add("-");
        listOfSeparators.add(";");
        listOfSeparators.add(":");
        listOfSeparators.add("\n");
        listOfSeparators.add("\r");
        listOfSeparators.add("\t");
        listOfSeparators.add("“");
        listOfSeparators.add("”");
        listOfSeparators.add("—");





        String separatorsString = String.join("|\\", listOfSeparators);
        Map<String, Word> countMap = new HashMap<>();
        String startString = "";
        int startInt = 0;
        Word wordsWord = new Word();
        wordsWord.word = startString;
        wordsWord.count = startInt;
        countMap.put("", wordsWord);

        BufferedReader r = new BufferedReader(new FileReader(FILE));
        String text = "";
        String line;
        int count = 0;
        while ((line = r.readLine()) != null) {
            text += line;
            count++;
            System.out.println(count);

        }


        BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8))));
        while ((text = reader.readLine()) != null) {
            String[] words = text.split(separatorsString);
            for (String word : words) {
                if ("".equalsIgnoreCase(word)) {
                    continue;
                }
                //System.out.println(word);

                if (!countMap.containsKey(word)) {
                    wordsWord = new Word();
                    wordsWord.word = word;
                    wordsWord.count = 1;
                    countMap.put(word, wordsWord);
                } else {
                    countMap.get(word).count++;
                }
            }
        }
        SortedMap<String, Word> sortedMap = new TreeMap<>();
        reader.close();

        BufferedWriter outputWriter = new BufferedWriter(new FileWriter((OUT_FILE)));

        for (Word word : countMap.values()) {
            System.out.println(word.count + "\t" + word.word);
            outputWriter.write(word.count + "\t" + word.word);
            outputWriter.newLine();

        }
        outputWriter.close();


//        for (Map.Entry<String, Word> entry : countMap.entrySet()){
//            System.out.println(entry.getValue().count + "\t" + entry.getValue().word);
//            outputWriter.write(entry.getValue().count + "\t" + entry.getValue().word);
//        }
    }


//        TreeMap<String, Word> sortedWords = new TreeMap<String, Word>();
//
//        sortedWords.putAll(countMap);
//
//
//        for (Word word : sortedWords.values()) {
//            System.out.println(word.count + "\t" + word.word);
//        }


}



