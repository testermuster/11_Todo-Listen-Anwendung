import java.util.ArrayList;
import java.util.Scanner;

public class TodoListenAnwendung {
    private static ArrayList<String> todos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nTodo-Listen-Anwendung");
            System.out.println("1. Todo hinzufügen");
            System.out.println("2. Todos anzeigen");
            System.out.println("3. Todo löschen");
            System.out.println("4. Beenden");
            System.out.print("Wählen Sie eine Option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Konsumiere den Zeilenumbruch

            switch (option) {
                case 1:
                    todoHinzufuegen();
                    break;
                case 2:
                    todosAnzeigen();
                    break;
                case 3:
                    todoLoeschen();
                    break;
                case 4:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Ungültige Option. Bitte wählen Sie eine der angegebenen Optionen.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Anwendung beendet.");
    }

    private static void todoHinzufuegen() {
        System.out.print("Geben Sie ein neues Todo ein: ");
        String todo = scanner.nextLine();
        todos.add(todo);
        System.out.println("'" + todo + "' zur Todo-Liste hinzugefügt.");
    }

    private static void todosAnzeigen() {
        if (todos.isEmpty()) {
            System.out.println("Die Todo-Liste ist leer.");
        } else {
            System.out.println("Todos:");
            for (int i = 0; i < todos.size(); i++) {
                System.out.println((i + 1) + ". " + todos.get(i));
            }
        }
    }

    private static void todoLoeschen() {
        todosAnzeigen();
        if (!todos.isEmpty()) {
            System.out.print("Geben Sie die Nummer des zu löschenden Todos ein: ");
            int index = scanner.nextInt() - 1;
            if (index >= 0 && index < todos.size()) {
                System.out.println("'" + todos.remove(index) + "' wurde gelöscht.");
            } else {
                System.out.println("Ungültige Todo-Nummer.");
            }
        }
    }
}
