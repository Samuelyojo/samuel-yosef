import java.util.Scanner;

public class PasswordChecer {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String password ;
        int upperCase = 0 , lowerCase = 0 , digit =  0 , specialCharacter = 0;

       
        do{ 
            System.out.print("Please enter password : ");
             password = scanner.next();
        }while(password.length() < 8);
        

        for(int i = 0 ; i < password.length() ; i++){
            char characther = password.charAt(i);

            if (characther > 64 && characther < 91) {
                upperCase++;
            }else if(characther > 96 && characther < 123){
                lowerCase++;
            }else if(characther > 47 && characther < 58){
                digit++;
            }else if(characther > 32 && characther < 48){
                specialCharacter++;
            }else if(characther > 57 && characther < 65){
                specialCharacter++;
            }else if(characther > 90 && characther < 97){
                specialCharacter++;
            }else if(characther > 122 && characther < 127){
                specialCharacter++;
            }

        }

        if (upperCase > 0 && lowerCase > 0 && digit > 0 && specialCharacter > 0) {
            System.out.println( password.toString() + " : is a strong password" );
        }else System.out.println( password.toString() + " : is a weak password");


        scanner.close();
    }
}
