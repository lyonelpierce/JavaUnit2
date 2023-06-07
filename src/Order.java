import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Order{
    public Order(ArrayList<Cupcake> cupcakeMenu, ArrayList<Drink> drinkMenu){
        System.out.println("Hello customer. Would you like to place an order? (Y or N)");
        Scanner input = new Scanner(System.in);
        String placeOrder = input.nextLine();

        ArrayList<Object> order = new ArrayList<Object>();

        if(placeOrder.equalsIgnoreCase("Y")){
            order.add(LocalDate.now());
            order.add(LocalTime.now());
            System.out.println("Here is the menu:");
            System.out.println("Cupcakes:");
            int itemNumber = 0;
            for (Cupcake menu : cupcakeMenu) {
                itemNumber++;
                System.out.println(itemNumber + ".");
                menu.type();
                System.out.println("Price: $" + menu.getPrice());
                System.out.println();
            }
            System.out.println("Drinks:");
            for (Drink menu : drinkMenu) {
                itemNumber++;
                System.out.println(itemNumber + ".");
                menu.type();
                System.out.println("Price: $" + menu.getPrice());
                System.out.println();
            }
        }else{
            System.out.println("Have a nice day then!");
        }

        boolean ordering = true;

        while (ordering){
            System.out.println("What would you like to order? Please use the number associated with the item.");
            int orderChoice = input.nextInt();
            input.nextLine();
            if(orderChoice == 1){
                order.add(cupcakeMenu.get(0));
                System.out.println("Item added to order");
            }else if(orderChoice == 2) {
                order.add(cupcakeMenu.get(1));
                System.out.println("Item added to order");
            }else if(orderChoice == 3) {
                order.add(cupcakeMenu.get(2));
                System.out.println("Item added to order");
            }else if(orderChoice == 4) {
                order.add(drinkMenu.get(0));
                System.out.println("Item added to order");
            } else if(orderChoice == 5) {
                order.add(drinkMenu.get(1));
                System.out.println("Item added to order");
            } else if(orderChoice == 6) {
                order.add(drinkMenu.get(2));
                System.out.println("Item added to order");
            } else {
                System.out.println("Sorry, we don't seem to have that item on the menu.");
            }
            System.out.println("Would you like to continue ordering? (Y/N)");
            String continueOrder = input.nextLine();
            if(!continueOrder.equalsIgnoreCase("Y")){
                ordering = false;
            }
        }
        System.out.println(order.get(0));
        System.out.println(order.get(1));
        Double subTotal = 0.0;
        for (int i = 2; i < order.size(); i++) {
            Object item = order.get(i);
            if (item instanceof Cupcake) {
                Cupcake cupcake = (Cupcake) item;
                cupcake.type();
                System.out.println(cupcake.getPrice());
                subTotal += cupcake.getPrice();
            } else if (item instanceof Drink) {
                Drink drink = (Drink) item;
                drink.type();
                System.out.println(drink.getPrice());
                subTotal += drink.getPrice();
            }
        }
        System.out.println("$" + subTotal + "\n");
        new CreateFile();
        new WriteToFile(order);
    }
}

class CreateFile {
    public CreateFile(){
        try
        {
            File salesData = new File("salesData.txt");
            if (salesData.createNewFile()) {
                System.out.println("File created: " + salesData.getName());
            } else {
                System.out.println("File already exists.");
            }
        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
        }
    }
}

class WriteToFile{
    public WriteToFile(ArrayList<Object> order){
        try {
            FileWriter fw = new FileWriter("salesData.txt", true);
            PrintWriter salesWriter = new PrintWriter(fw);
            for (int i = 0; i < order.size(); i++) {
                salesWriter.println(order.get(i));
            }
            salesWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}