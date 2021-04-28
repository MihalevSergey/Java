public class Word implements Comparable {

     String word;
     int count;

    @Override
    public int hashCode() {
        return word.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return word.equals(((Word) obj).word);
    }


    public int compareTo(Word b) {
        return b.count - count;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}


