package pl.edu.pja.tpo02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class FlashcardsApp {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(FlashcardsApp.class, args);
        FlashcardsController controller = context.getBean(FlashcardsController.class);

        controller.initialize();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("Flashcards Menu:");
            System.out.println("1. Add Flashcard");
            System.out.println("2. Display all words");
            System.out.println("3. Run a test");
            System.out.println("4. Save and exit");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("Enter polish word: ");
                    String polish = scanner.nextLine();

                    System.out.print("Enter english word: ");
                    String english = scanner.nextLine();

                    System.out.print("Enter german word: ");
                    String german = scanner.nextLine();

                    controller.addWord(polish,english,german);
                    break;

                case "2":
                    controller.display();
                    break;

                case "3":
                    controller.runTest();
                    break;

                case "4":
                    controller.saveData();
                    System.out.println("All words saved, Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }

        scanner.close();
    }

}
