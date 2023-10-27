import java.util.Scanner;

public class TextBasedGame {
        private static int userHealth = 100;
        private static String playerName;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome to the Jumanji!");
            System.out.print("Enter your hero name: ");
            playerName = scanner.nextLine();

            System.out.println("\n--- Story ---");
            System.out.println("You spawn in a forest. Your heart is pounding, and you have no idea how you got here.");
            System.out.println("You see a shiny object on the ground nearby.");
            System.out.println("What will you do? Type in the number of the option.");
            System.out.println("1. Pick up the object");
            System.out.println("2. Ignore it and look around");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("When you pick it up, you discover that it's a magical sword!");
                System.out.println("You equip the sword and feel a surge of power.");
            } else {
                System.out.println("You decide to ignore the object and explore the forest.");
                System.out.println("After walking for a while, you encounter a group of mysterious creatures.");
                battleCreatures();
            }

            System.out.println("\n--- Endgame ---");
            System.out.println("You come across a variety of challenges as you venture deeper into the forest and find priceless treasures along the way.");
            System.out.println("Finally, you reach the end of the forest and find the ultimate chest.");
            System.out.println("Congratulations, " + playerName + "! You have completed the adventure and become a legendary hero!");

            scanner.close();
        }

        private static void battleCreatures() {
            Scanner scanner = new Scanner(System.in);

            System.out.println("\n--- Battle ---");
            System.out.println("You are attacked by three mysterious creatures!");

            int creatureHealth = 50;
            int creatureCount = 3;

            while (creatureCount > 0 && userHealth > 0) {
                System.out.println("\nYour health: " + userHealth);
                System.out.println("Creature health: " + creatureHealth);

                System.out.println("\nWhat will you do? Type in the number of the option.");
                System.out.println("1. Attack");
                System.out.println("2. Run away");

                int choice = scanner.nextInt();

                if (choice == 1) {
                    int userDamage = 20;
                    int creatureDamage = 10;

                    creatureHealth -= userDamage;
                    userHealth -= creatureDamage;

                    System.out.println("You attack the creature, dealing " + userDamage + " damage.");
                    System.out.println("The creature retaliates, dealing " + creatureDamage + " damage to you.");

                    if (creatureHealth <= 0) {
                        creatureCount--;
                        creatureHealth = 50;
                        System.out.println("\nYou defeated a creature!");
                        System.out.println("Creatures remaining: " + creatureCount);
                    }

                    if (userHealth <= 0) {
                        System.out.println("\nGame Over! The creatures have defeated you.");
                        break;
                    }
                } else if (choice == 2) {
                    System.out.println("You escaped from the creatures, but they manage to hit you as you flee.");
                    userHealth -= 10;
                    System.out.println("Your health: " + userHealth);
                }
            }

            scanner.close();
        }
    }