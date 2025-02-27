import java.util.*;

public class CardCollection {
    private static HashMap<String, List<String>> cardMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void addCard() {
        System.out.print("Enter Card Symbol (e.g., Hearts, Spades): ");
        String symbol = scanner.nextLine();
        System.out.print("Enter Card Name (e.g., Ace, King, 7): ");
        String name = scanner.nextLine();

        cardMap.putIfAbsent(symbol, new ArrayList<>());
        cardMap.get(symbol).add(name);
        System.out.println("Card added successfully.");
    }

    public static void findCardsBySymbol() {
        System.out.print("Enter Symbol to search: ");
        String symbol = scanner.nextLine();

        List<String> cards = cardMap.get(symbol);
        if (cards != null && !cards.isEmpty()) {
            System.out.println("Cards in " + symbol + ": " + cards);
        } else {
            System.out.println("No cards found for symbol: " + symbol);
        }
    }

    public static void displayAllCards() {
        if (cardMap.isEmpty()) {
            System.out.println("No cards in collection.");
        } else {
            for (Map.Entry<String, List<String>> entry : cardMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n1. Add Card 2. Search by Symbol 3. Display All 0. Exit");
            System.out.print("Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1: addCard(); break;
                case 2: findCardsBySymbol(); break;
                case 3: displayAllCards(); break;
                case 0: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}
