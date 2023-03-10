import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class HashTableDriver {


    public static void main(String[] args) throws IOException {
        createFile();
        // create a hash table
        HashTable hashTable = new HashTable();
        // read the data from the file
        ArrayList<DataItem> dataItems = readFile("hashData.txt");
        // add the data items to the hash table
        for (DataItem dataItem : dataItems) {
            hashTable.add(dataItem);
        }
        // print the number of collisions
        System.out.println(HashTable.collisions + " collisions occurred when adding the data items to the hash table from hashData.txt.\n");
        while (true) {
            // prompt the user for a word
            System.out.print("Enter a word to search for (or q to quit): ");
            Scanner input = new Scanner(System.in);
            String word = input.nextLine();
            // if the user enters q, quit the program
            if (word.equals("q")) {
                System.exit(0);
            }
            // time how long it takes to search for the word
            long startTime = System.nanoTime();
            // get the data item from the hash table
            DataItem dataItem = hashTable.get(word);
            long endTime = System.nanoTime();
            // if the data item is not null, print the data item
            if (dataItem != null) {
                System.out.println("String " + "\"" + dataItem.getWord() + "\"" + " found at index " + dataItem.getNumber() + " in " + (endTime - startTime) + " nanoseconds.");
            } else {
                // if the data item is null, print "not found"
                System.out.println("No occurrences found.");
            }
        }
    }


    // pre: none
    // post: inserts into hashData.txt 10000 data items (to string) each data item on a new line
    public static void createFile() throws IOException {
        File file = new File("hashData.txt");
        if (!file.exists()) {
            System.out.println("hashData.txt did not exist, please rerun this program to continue.");
        } else return;
        DataItem[] dataItems = DataGenerator.generateDataItems();
        System.setOut(new PrintStream(new FileOutputStream("hashData.txt")));
        for (DataItem dataItem : dataItems) {
            // don't add a new line after the last data item
            System.out.print(dataItem.getNumber() == dataItems.length - 1 ? dataItem : dataItem + "\n");
        }
        System.exit(0);
    }

    public static ArrayList<DataItem> readFile(String fileName) throws FileNotFoundException {
        ArrayList<DataItem> items = new ArrayList<>();
        Scanner input = new Scanner(new File(fileName));
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] parts = line.split(" ");
            int number = Integer.parseInt(parts[0]);
            String word = parts[1];
            DataItem dataItem = new DataItem(number, word);
            items.add(dataItem);
        }
        return items;
    }
}