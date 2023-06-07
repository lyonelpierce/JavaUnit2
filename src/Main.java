import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//       Cupcake Menu
        ArrayList<Cupcake> cupcakeMenu = new ArrayList<Cupcake>();
        Cupcake cupcake = new Cupcake();
        RedVelvet redVelvet = new RedVelvet();
        Chocolate chocolate = new Chocolate();

        System.out.println("We are in the middle of creating the cupcake menu. We currently have three cupcakes on the menu but we need to decide on pricing.");
        Scanner input = new Scanner(System.in);

    //        Basic Cupcake
        System.out.println("We are deciding on the price of the standard cupcake. Here is the description:");
        cupcake.type();
        System.out.println("How much would you like to charge for this cupcake? (Input a numerical number taken to 2 decimal places)");
        String priceText = input.nextLine();
        double price = Double.parseDouble(priceText);
        cupcake.setPrice(price);

    //        RedVelvet Cupcake
        System.out.println("We are deciding on the price of the Red Velvet cupcake. Here is the description:");
        redVelvet.type();
        System.out.println("How much would you like to charge for this cupcake? (Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        redVelvet.setPrice(price);

    //        Chocolate Cupcake
        System.out.println("We are deciding on the price of the Red Velvet cupcake. Here is the description:");
        chocolate.type();
        System.out.println("How much would you like to charge for this cupcake? (Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        chocolate.setPrice(price);

    //        Add to the cupcake menu
        cupcakeMenu.add(cupcake);
        cupcakeMenu.add(redVelvet);
        cupcakeMenu.add(chocolate);

    //        Drink Menu
        ArrayList<Drink> drinkMenu = new ArrayList<Drink>();
        Drink water = new Drink();
        Soda soda = new Soda();
        Milk milk = new Milk();

        System.out.println("We are in the middle of creating the drink menu. We currently have three drinks on the menu but we need to decide on pricing.");

    //        Water Drink
        System.out.println("We are deciding on the price of the water. Here is the description:");
        water.type();
        System.out.println("How much would you like to charge for this drink? (Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        water.setPrice(price);

    //        Soda Drink
        System.out.println("We are deciding on the price of the soda. Here is the description:");
        soda.type();
        System.out.println("How much would you like to charge for this drink? (Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        soda.setPrice(price);

    //        Milk Drink
        System.out.println("We are deciding on the price of the milk. Here is the description:");
        milk.type();
        System.out.println("How much would you like to charge for this drink? (Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        milk.setPrice(price);

    //        Add to the drink menu
        drinkMenu.add(water);
        drinkMenu.add(soda);
        drinkMenu.add(milk);

        new Order(cupcakeMenu, drinkMenu);

//        Scanner close
        input.close();
    }
}

class Cupcake {
    public double price;
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void type(){
        System.out.println("A basic, generic cupcake, with vanilla frosting");
    }
}

class RedVelvet extends Cupcake {
    public void type(){
        System.out.println("A red velvet based cupcake, with cream cheese frosting");
    }
}

class Chocolate extends Cupcake{
    public void type()
    {
        System.out.println("A chocolate based cupcake, with chocolate frosting");
    }
}

class Drink{
    public double price;
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void type(){
        System.out.println("A bottle of water");
    }
}

class Soda extends Drink{
    public void type(){
        System.out.println("A bottle of soda");
    }
}

class Milk extends Drink{
    public void type(){
        System.out.println("A bottle of milk");
    }
}