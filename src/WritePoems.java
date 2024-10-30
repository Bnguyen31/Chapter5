import java.io.*;

public class WritePoems {

    public static void main(String[] args) {
        Poem poem1 = new Poem();
        poem1.setName("The Road Not Taken");
        poem1.setPoet("Robert Frost");

        Poem poem2 = new Poem();
        poem2.setName("Hope is the Thing with Feathers");
        poem2.setPoet("Emily Dickinson");

        Poem poem3 = new Poem();
        poem3.setName("I Know Why the Caged Bird Sings");
        poem3.setPoet("Maya Angelou");

        try (PrintWriter writer = new PrintWriter("poems.txt")) {
            writePoem(writer, poem1);
            writer.println();
            writePoem(writer, poem2);
            writer.println();
            writePoem(writer, poem3);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void writePoem(PrintWriter writer, Poem poem) {
        writer.println(poem.getName());
        writer.println(poem.getPoet());
    }
}
