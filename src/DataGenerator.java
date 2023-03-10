public class DataGenerator {


    // pre: none
    // post: returns a random  word from 3-8 characters long, where each word starts with a consonant and alternates
    // between random consonants and random vowels.
    public static String randomWord() {
        StringBuilder word = new StringBuilder();
        int length = (int) (Math.random() * 6) + 3;
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                word.append(randomConsonant());
            } else {
                word.append(randomVowel());
            }
        }
        return word.toString();
    }

    // pre: none
    // post: returns a random consonant
    public static char randomConsonant() {
        String consonants = "bcdfghjklmnpqrstvwxyz";
        return consonants.charAt((int) (Math.random() * consonants.length()));
    }

    // pre: none
    // post: returns a random vowel
    public static char randomVowel() {
        String vowels = "aeiou";
        return vowels.charAt((int) (Math.random() * vowels.length()));
    }

    // return list of 1000 data items
    public static DataItem[] generateDataItems() {
        DataItem[] dataItems = new DataItem[10000];
        for (int i = 0; i < dataItems.length; i++) {
            dataItems[i] = generateDataItem(i);
        }
        return dataItems;
    }


    public static DataItem generateDataItem(int number) {
        return new DataItem(number, DataGenerator.randomWord());
    }
}
