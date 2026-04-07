public class GuthrieSequence {
       public static void main(String[] args) {
    int list[] = {7,22,11,34,17,52,26,13,40,20,10,5,16,8,4,2,1};
    System.out.println(isGuthrieSequence(list));
   
  } 
  
  public static int isGuthrieSequence(int list[]){
       for(int i = 0 ; i < list.length - 1 ; i++){
            if (list[i] % 2 == 0) {
                if (list[i] / 2 == list[i+1]) {
                    continue;
                }else return 0;
            }else if(list[i] % 2 != 0 ){
                if ( (list[i] * 3) + 1 == list[i+1]) {
                    continue;
                }else return 0;
            }
       }

       if ((list[list.length - 1 ]) == 1) {
        return 1;
       }
return 0;
    }
}
