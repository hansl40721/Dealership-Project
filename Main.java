import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        
        Car[] cars = new Car[] {
            new Car("Nissan", 5000, 2020, "red", new String[] {"tires", "keys"}),
            new Car("Dodge", 8500, 2019, "blue", new String[] {"tires", "keys"}),
            new Car("Nissan", 5000, 2017, "yellow", new String[] {"tires", "filter"}),
            new Car("Honda", 7000, 2019, "orange", new String[] {"tires", "filter"}),
            new Car("Mercedes", 12000, 2015, "jet black", new String[] {"tires", "filter", "transmission"})
        };
        
        Dealership dealership = new Dealership(cars);
        
        System.out.println("\n ****** JAVA DEALERSHIP! ****** \n");
        System.out.println("Welcome! Enter the type of car you're looking for: ");
        String searchMake = scan.nextLine();
        System.out.println("Enter your budget: ");
        int searchPrice = Integer.parseInt(scan.nextLine());

        while(true) {
            int index = dealership.search(searchMake, searchPrice);
            if(index == -1) {
                wait(1000);
                System.out.println("\nFeel free to browse through our collection of cars.\n");
                wait(1000);
                System.out.println(dealership.toString());
                System.out.println("\nDo any of these cars fit what you're looking for?\n 'Yes' or 'No'");
                String choice = scan.nextLine();
                if(choice.equalsIgnoreCase("yes")) {
                    System.out.println("\nWhich car are you interested in?");
                    searchMake = scan.nextLine();
                    System.out.println("\nDid you want to update your budget?/n'Yes' or 'No'");
                    choice = scan.nextLine();
                    if(choice.equalsIgnoreCase("yes")) {
                        System.out.println("\nWhat is your new budget?");
                        searchPrice = Integer.parseInt(scan.nextLine());
                    } else if(choice.equalsIgnoreCase("no")) {
                        System.out.println("\nOkay, your current budget is " + searchPrice);
                    } else {
                        System.out.println("\nINVALID INPUT");
                    }
                    continue;
                } else if (choice.equalsIgnoreCase("no")) {
                    System.out.println("\nOkay, see you next time");
                    break;
                } else {
                    System.out.println("\nINVALID INPUT");
                    continue;
                }
            } else {
                String decision = scan.nextLine();
                if(decision.equalsIgnoreCase("yes")) {
                    System.out.println("\nExcellent! Hold on one moment.\n");
                    wait(1000);
                    dealership.sell(index);
                    break;
                } else {
                    System.out.println("\nOkay, see you next time.");
                    break;
                }
            }
        }
        scan.close();
        
    }

    public static void wait(int milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
             System.out.println(e.getMessage());
        }
    }
}

