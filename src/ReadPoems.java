import java.io.*;
import java.util.*;

public class ReadPoems {

    public static void main(String[] args) {
        List<Poem> poems = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("poem2.txt"))) {
            String name;
            while ((name = reader.readLine()) != null) {
                String poet = reader.readLine();
                Poem poem = new Poem();
                poem.setName(name);
                poem.setPoet(poet);
                poems.add(poem);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        // Printing poems to the console
        for (Poem poem : poems) {
            System.out.println("Poem: " + poem.getName());
            System.out.println("Poet: " + poem.getPoet());
            System.out.println();
        }
    }
}
