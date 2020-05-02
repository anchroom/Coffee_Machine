package machine;

import java.util.Scanner;


enum Coffee {
    ESPRESSO("espresso", 1, 250, 0, 16, 4),
    LATTE("latte", 2, 350, 75, 20, 7),
    CAPPUCCINO("cappuccino", 3, 200, 100, 12, 6);

    String name;
    int typNum;
    int useWater;
    int useMilk;
    int useBeans;
    int price;

    Coffee(String name, int typNum, int useWater, int useMilk, int useBeans, int price) {
        this.name = name;
        this.typNum = typNum;
        this.useWater = useWater;
        this.useMilk = useMilk;
        this.useBeans = useBeans;
        this.price = price;
    }

    public static Coffee findByTypeNum(int numOftype) {
        Coffee[] coffee = Coffee.values();
        Coffee coffeeSelected = coffee[numOftype - 1];
        return coffeeSelected;
    }
}

public class CoffeeMachine {
    private static int water;
    private static int milk;
    private static int beans;
    private static int cups;
    private static int money;

    public CoffeeMachine() {
        // Initial resources
        water = 400;
        milk = 540;
        beans = 120;
        cups = 9;
        money = 550;
    }

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        machine.mainMenu();
    }

    private static void mainMenu() {
        Scanner sc = new Scanner(System.in);
        String action = "";
        do {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            switch (action = sc.next()) {
                case "buy":
                    System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte , 3 - cappuccino, back - to main menu");
                    String typeOfCoffee = sc.next();
                    if (typeOfCoffee.equals("back")) {
                        continue;
                    } else {
                        buy(Integer.parseInt(typeOfCoffee));
                        break;
                    }

                case "fill":
                    fill();
                    break;

                case "take":
                    take();
                    break;

                case "remaining":
                    remaining();
                    break;

                case "exit":
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + action);
            }

        } while (!action.equals("exit"));
    }

    private static void buy(int typOfCoffee) {
        Coffee coffee = Coffee.findByTypeNum(typOfCoffee);
        boolean statusOfWater = water >= coffee.useWater;
        boolean statusOfMilk = milk >= coffee.useMilk;
        boolean statusOfBeans = beans >= coffee.useBeans;
        boolean statusOfEmptyCups = cups >0;
        if (statusOfWater && statusOfMilk && statusOfBeans && statusOfEmptyCups) {
            System.out.println("\nI have enough resources, making you a coffee!\n");
            water -= coffee.useWater;
            milk -= coffee.useMilk;
            beans -= coffee.useBeans;
            cups--;
            money += coffee.price;
        } else if (!statusOfWater) {
            System.out.println("Sorry, not enough water!\n");
        } else if (!statusOfMilk) {
            System.out.println("Sorry, not enough milk!\n");
        } else if (!statusOfBeans) {
            System.out.println("Sorry, not enough coffee beans!\n");
        } else if (!statusOfEmptyCups) {
            System.out.println("Sorry, not enough disposable cups!\n");
        }
    }

    private static void fill() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        water += sc.nextInt();

        System.out.println("Write how many ml of milk do you want to add:");
        milk += sc.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans += sc.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups += sc.nextInt();
    }

    private static void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    private static void remaining() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }

    private static void checking(int useWater, int useMilk, int useBeans) {

    }

}
