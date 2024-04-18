import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class main {
    public static final String Intro = "You find yourself in a dark forest. To the north, you see a path leading deeper into the woods. To the south, you see the edge of the forest.";
    public static final String Win_Message = "Congratulations, you have made it through the forest and found the treasure!";
    public static final String Lose_Message = "Oh no, you have been defeated, better luck next time!";

    public static int health = 100; // anita max wynn
    public static String currentLocation = "forest";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Intro);

        while (true) {
            System.out.print("What do you want to do? ");
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("north")) {
                moveNorth();
            } else if (input.equals("south")) {
                moveSouth();
            } else if (input.equals("take treasure")) {
                takeTreasure();
            } else if (input.equals("fight creature")) {
                fightCreature();
            } else {
                System.out.println("I don't understand that command.");
            }

            if (currentLocation.equals("treasure")) {
                System.out.println(Win_Message);
                break;
            } else if (health <= 0) {
                System.out.println(Lose_Message);
                break;
            }

        }
    }

    private static void takeTreasure() {
        System.out.println("You have won the game!");
    }

    public static void moveNorth() {
        if (currentLocation.equals("forest")) {
            System.out.println("You move deeper into the forest. You see a glowing treasure chest ahead.");
            currentLocation = "treasure";
        } else {
            System.out.println("You can't go that way.");
        }
    }

    private static void moveSouth() {
        if (currentLocation.equals("forest")) {
            System.out.println("You head back towards the edge of the forest.");
            currentLocation = "edge";
        } else {
            System.out.println("You can't go that way.");
        }
    }

    private static void fightCreature() {
        int creatureStrength = 50;
        int playerAttack = (int) (Math.random() * 20) + 1;
        int creatureAttack = (int) (Math.random() * 20) + 1;
        if (currentLocation.equals("forest")) {


            System.out.println("You encounter a dangerous creature!");

            if (playerAttack > creatureAttack) {
                System.out.println("You manage to defeat the creature!");
                creatureStrength -= playerAttack;
            } else {
                System.out.println("The creature overpowers you!");
                health -= creatureAttack;
            }
        } else {
            System.out.println("There is nothing to fight here.");
        }

    }
}

