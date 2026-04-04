import java.util.Scanner;
import java.text.NumberFormat;

public class CalculatingSales {
     public static void main(String[] args) {
    
      final float product_1 = 2.98F;
      final float product_2 = 4.50F;
      final float product_3 = 9.98F;
            char value = 'y';
            float retailPrice = 0;

      Scanner scanner = new Scanner(System.in);

      while (value != 'n' && value != 'N') {
        System.out.print("Product id : ");
        int id = scanner.nextInt();
        
        System.out.print("Quantity of product : ");
        int quantity = (scanner.nextInt())*-1;

        switch (id) {
            case 1:
                retailPrice = retailPrice + (product_1 * quantity);
                break;
            case 2:
             retailPrice = retailPrice + (product_2 * quantity);
                    break;
            case 3:
                retailPrice = retailPrice + (product_3 * quantity);
                break;        
            default:
                System.out.println("Not found .");
                break;
        }

        System.out.print("Any other product ? ( y for yes annd n for no ) : ");
        value = scanner.next().charAt(0);
      }

      String retailPrice_ = NumberFormat.getCurrencyInstance().format(retailPrice);

      System.out.println("The retail price is : " + retailPrice_);

scanner.close();
}
}
