import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Escalator escalator = null;
        try {
            File input = new File(args[0]);
            Scanner reader = new Scanner(input);
            try {
                escalator = new Escalator(args[2], Integer.parseInt(args[1])); // args[2] = policy (LJF or SJF), args[1] = number of cores
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Policy!");
                e.printStackTrace();
            }

            while(reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] info = line.split(" "); // splits string based on spaces
                
                escalator.addProcess(new Process(info[0], Integer.parseInt(info[1]))); // first part of each line is the ID, second part is the execution time
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }

        escalator.execute(); // runs escalator
        System.out.println(escalator.toString());

    }
}
