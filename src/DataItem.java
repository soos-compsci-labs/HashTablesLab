public class DataItem implements Comparable<DataItem> {
    private int number;
    private String word;

    public DataItem(int number, String word) {
        this.number = number;
        this.word = word;
    }

    public static int hashCode(String w) {
        int sum = 0;
        for (int i = 0; i < w.length(); i++) {
            char letter = w.charAt(i);
            sum += (int) letter * (i + 1);
        }
        return sum;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String toString() {
        return number + " " + word;
    }

    // pre: none
    // post: returns a unique hash code for each data item
    public int hashCode() {
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            sum += (int) letter * (i + 1);
        }
        return sum;
    }

    public int compareTo(DataItem o) {
        // return 0 if data items are equal
        // return -1 if this data item's word is alphabetically before the other data item's word
        // return 1 if this data item's word is alphabetically after the other data item's word

        // compare the words
        return word.compareTo(o.getWord());
    }
}
