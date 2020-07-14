import java.util.Scanner; //hazmi hashim bi19110034

class Menu{
 String item;
 double price;

    public Menu(String item,double price){
    this.item = item;
    this.price = price;
    }

    public double getPrice(){
    return price;
    }

    public void printItem(){
    System.out.println("\t" + item);
    System.out.print("\tPrice: ");

    }
}


public class Lab4_MenuDemo {
   public static void main(String args[]) throws java.io.IOException{
      String item;
      double price;
      int qty;
      double total=0.0;
 
      Scanner scan = new Scanner(System.in);
      System.out.println("Menu: ");
      System.out.println("------------------------------------------------");
      System.out.println("[1] Nasi Lemak [RM2.00]");
      System.out.println("[2] Roti [RM1.00]");
      System.out.println("[3] Teh Tarik [RM1.50]");
      System.out.println("[4] Kopi O [RM2.00]");
      System.out.println("------------------------------------------------");
      System.out.println("Place order [1-4] or type q to quit");
      
      do{
      System.out.print("Add menu: ");
      item = scan.next();

String[] mkanan = {"Nasi Lemak", "Roti", "Teh Tarik", "Kopi O"};//
double[] hrga = {2.0, 1.0, 1.5, 2.0};                                         //
                                                                                               //
Menu[] menu = new Menu[4];                                                //Array of object implementation
    for (int i = 0; i < 4; i++) {                                                     //
       menu[i] = new Menu(mkanan[i], hrga[i]);                             //
    }

      switch(item.charAt(0)){
      case '1':
      System.out.print("Nasi Lemak - Quantity: ");
      qty = scan.nextInt();
      menu[0].printItem();
      total += (menu[0].getPrice() * qty);
      System.out.println(menu[0].getPrice() * qty);
      break;

       case '2':
       System.out.print("Roti - Quantity: ");
       qty = scan.nextInt();
       menu[1].printItem();
       total += (menu[1].getPrice() * qty);
       System.out.println(menu[1].getPrice() * qty);
       break;

       case '3':
       System.out.print("Teh Tarik - Quantity: ");
       qty = scan.nextInt();
       menu[2].printItem();
       total += (menu[2].getPrice() * qty);
       System.out.println(menu[2].getPrice() * qty);
       break;

       case '4':
       System.out.print("Kopi O - Quantity: ");
       qty = scan.nextInt();
       menu[3].printItem();
       total += (menu[3].getPrice() * qty);
       System.out.println(menu[3].getPrice() * qty);
       break;

        case 'q':
        break;

      
      
      
      default:
      break;
      }      
      }while(item.charAt(0) != 'q');

      
      System.out.println("\nThank you for your order.");
      System.out.printf("Total due: RM %.2f", total);
            
   }
}