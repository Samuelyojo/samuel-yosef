import java.util.Scanner;
import java.text.NumberFormat;
class Learning{
    public static void main(String[] args){
        //first attemte 
        System.out.print("Amount:");
        Scanner scanAmount = new Scanner(System.in);
        int amount = scanAmount.nextInt();
        
        System.out.print("Rate:");
        Scanner scanRate = new Scanner(System.in);
        double Rate = scanRate.nextDouble();
        
        System.out.print("Period:");
        Scanner scanPeriod = new Scanner(System.in);
        int period = scanPeriod.nextInt();
        
        String mortgage = NumberFormat.getCurrencyInstance().format();
        
        
        System.out.println(mortgage );

        // second attemte
        System.out.print("Amount:");
        Scanner scanAmount = new Scanner(System.in);
        int amount = scanAmount.nextInt();
        
        System.out.print("Rate:");
        Scanner scanRate = new Scanner(System.in);
        double rate = scanRate.nextDouble();
        rate /= 1200;
        
        System.out.print("Period:");
        Scanner scanPeriod = new Scanner(System.in);
        int period = scanPeriod.nextInt();
        period *= 12;
        
        double numunater = rate * Math.pow((1+rate) , period) ;
        double dumunater = (Math.pow((1+rate) , period)) - 1 ;
        double result = amount * (numunater/dumunater);
        String mortgage = NumberFormat.getCurrencyInstance().format(result);
        
        
        System.out.println("Mortgage :" + mortgage );


        //third attemte
        Scanner scannner = new Scanner(System.in);
        
        System.out.print("Amount:");
        int amount = scannner.nextInt();
        
        System.out.print("Rate:");
        double rate = scannner.nextDouble();
        rate /= 1200;
        
        System.out.print("Period:");
        int period = scannner.nextInt();
        period *= 12;
        
        double numunater = rate * Math.pow((1+rate) , period) ;
        double dumunater = (Math.pow((1+rate) , period)) - 1 ;
        double result = amount * (numunater/dumunater);
        String mortgage = NumberFormat.getCurrencyInstance().format(result);
        
        
        System.out.println("Mortgage :" + mortgage );
    }
}
