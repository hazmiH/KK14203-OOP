
import java.util.Scanner;

class Cake{
   String name;
   String[] topping;
   String[] toppingOrder;
   double price_small;
   double price_medium;
   double price_big;
   double totalPrice;
   int size;
   int quantity;
   
   Cake(String name){this.name=name;}
   
   public void setCake(String[] t, double ps, double pm, double pb){
      topping = t;
      price_small = ps;
      price_medium = pm;
      price_big = pb;
   }
   
   public void cakeOrder(String[] to, int q, int s){
      toppingOrder = to;
      quantity = q;
      size = s;
   }
   
   public double getSizePrice(){
      double sprice=0.0;
      if(size==1) sprice = price_small;
      else if(size==2) sprice = price_medium;
      else if(size==3) sprice = price_big;
      
      return sprice;
   }
   
   public double getTotalPrice(){
      totalPrice = getSizePrice();
      totalPrice *= quantity;
      totalPrice += (toppingOrder.length*10);
      return totalPrice;  
   }
   
   public String getSize(){
      String size_str="";
      if(size==1) size_str="Small";
      else if (size==2) size_str="Medium";
      else if (size==3) size_str="Large";
      return size_str;
   }
   
   public void printCake(){
      System.out.println("-----------------------------");
      System.out.println("           Cake Menu");
      System.out.println("-----------------------------");
      System.out.println(name + " Cake with available toppings:");
      for(int i=0; i<topping.length; i++){
         System.out.println(i+1 + ") " + topping[i]);
      } 
      System.out.println("\nPrice:");
      System.out.println("[1] Small : RM" + price_small);
      System.out.println("[2] Medium: RM" + price_medium);
      System.out.println("[3] Big   : RM" + price_big);
   }
   
   public void printOrder(){
      System.out.println("\n\nCake Order detail:");
      System.out.println("-------------------------------------------");
      System.out.print("Topping : ");
      for(int i=0; i<toppingOrder.length; i++){
         System.out.print(i+1 + ") " + toppingOrder[i] + " ");
      } 
      System.out.println("\nSize    : " + getSize());
      System.out.println("-------------------------------------------");
      System.out.println("Total Price: RM" + getTotalPrice()); 
      System.out.println("-------------------------------------------"); 
   }      
}

class BlackForest extends Cake{
   BlackForest(String name){
      super(name);
   }

   void set_Cake(String[] topping, double price_small, double price_medium, double price_big){
      this.topping = topping;
      this.price_small = price_small;
      this.price_medium = price_medium;
      this.price_big = price_big;
   }
}

public class TestCake1{
   public static void main(String args[]){
      Cake c = new BlackForest("BlackForest");
      //Initialize available selection of toppings and price
      String[] topping = {"Chocolate", "Cherries", "Whipped Cream"};
      c.setCake(topping, 45.00, 65.00, 80.00);
      c.printCake();
      //Initialize order, quantity and size
      String[] order = {"Chocolate", "Cherries"};
      c.cakeOrder(order, 1, 2);
      c.printOrder();
   }
}

