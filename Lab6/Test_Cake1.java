class Cake{

   String name;
   String[] topping;
   String[] topping_order;
   double price_small, price_medium, price_big, total_price;
   int size, quantity;

   Cake(String cake_name){
      name = cake_name;
   }
   
  public void setCake(String[] t, double ps, double pm, double pb){
     topping = t;
     price_small = ps;
     price_medium = pm;
     price_big = pb;      
   }

   void order_cake (String[] topping_selection, int quants, int s){
      topping_order = topping_selection;
      size = s;
      quantity = quants;
   }
      
   double get_size_price(){
   double the_price = 0;
      if (size == 1){
         the_price = price_small;}
      
      else if (size == 2){
         the_price = price_medium;}
         
      else if (size == 3){
         the_price = price_big;}
      return the_price;
    }
    
    double get_total_price (){
      total_price = get_size_price() * quantity + (topping_order.length * 10);
      return total_price;
    }
      
    String get_size(){
    String the_size = " ";
      if (size == 1){
         the_size = "Small";}
      else if (size == 2){
         the_size = "Medium";}
      else if (size == 3){
         the_size = "Big";}
      return the_size;
    }
    
    void print_cake (){
      System.out.println ("-------------------------------------");
      System.out.println ("               Cake Menu             ");
      System.out.println ("-------------------------------------");
      System.out.println (name + " Cake with available toppings:");
      
      for (int i=0; i<topping.length; i++){
         System.out.println ((i+1)+ ")" + topping[i]);}
      
      System.out.println ();
      System.out.println ("Price:");
      System.out.println ("Small : RM" + price_small);
      System.out.println ("Medium: RM" + price_medium);
      System.out.println ("Big   : RM" + price_big);
      System.out.println ();
    }

    public String print_cake_GUI(){
      String text = "-------------------------------------\n";
      text += "               Cake Menu             \n";
      text += "-------------------------------------\n";
      text += name + " Cake with available toppings:\n";
      
      for (int i=0; i<topping.length; i++){
         text += (i+1)+ ") " + topping[i] + "\n";}
      
      text += "\n";
      text += "Price:\n";
      text += "Small : RM" + price_small;
      text += "\nMedium: RM" + price_medium;
      text += "\nBig   : RM" + price_big;
      text += "\n\nCake Order detail:\n";
      text += "-------------------------------------\n";
       
      text += "Topping:\n";
      for (int i=0; i<topping_order.length; i++){
      text +=    (i+1) + ") " + topping_order[i]+" \n";}
        
      text += "\nSize  :" + get_size();
      
      text += "\n-------------------------------------";
      text += "\nTotal Price:" + get_total_price ();
      text += "\n-------------------------------------\n";

     return text;
    }
    
    void print_order(){
       System.out.println ("Cake Order detail:");
       System.out.println ("-------------------------------------");
       
       System.out.println ("Topping:");
       for (int i=0; i<topping_order.length; i++){
         System.out.print (  (i+1) + ") " + topping_order[i]+" ");}
         
       System.out.println ("\nSize  :" + get_size());
       
       System.out.println ("-------------------------------------");
       System.out.println ("Total Price:" + get_total_price ());
       System.out.println ("-------------------------------------");
    }
}

public class Test_Cake1{
   public static void main(String args[]){
      
      Cake c = new Cake("Generic");
      String[] topping = {"Lava Chocolate", "Cream Cheese", "Butter Cream","Fondant"};
      c.setCake(topping, 45.00, 65.00, 80.00);
      c.print_cake();
      String[] order = {"Lava Chocolate", "Cream Cheese"};
      c.order_cake(order, 1, 2);
      c.print_order();
 }
}
