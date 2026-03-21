public class sorting {
    public static void main(String[] args){
        int array[] = {3,4,8,1,6,2,7,5,9};
        int array1[] = {3,4,8,1,6,2,7,5,9};
        int array2[] = {3,4,8,1,6,2,7,5,9};

        System.out.print("Unsorted : ");
        for (int e : array) {
            System.out.print( e + " ");
        }
       System.out.println();
            bubbleSort(array);
            selectionSort(array1);
            insertionSort(array2);
       
    }

    
    private static void bubbleSort(int array[]){
            System.out.println("bubbleSort : ");
        for(int i = 0 ; i < array.length ; i++){
            int temp = 0 ;
            for(int j = 1 ; j < array.length ; j++){
                if (array[j] < array[j-1]) {
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
            for (int e : array) {
            System.out.print(e + " ");
        }
        System.out.println();
        }
    }


    private static void selectionSort(int array[]){
                System.out.println("selectionSort : ");
            for(int i = 0 ; i < array.length ; i++){
                int small = i ;
                int temp = 0 ;
                for(int j = i + 1 ; j < array.length  ; j++){
                    if (array[small] > array[j]) {
                        small = j;
                    }
                }
                temp =  array[i];
                array[i] = array[small];
                array[small] = temp;

                for (int e : array) {
            System.out.print(e + " ");
        }
        System.out.println();
            }

}


    private static void insertionSort(int array[]){
            System.out.println("insertionSort : ");
        for(int i = 1 ; i < array.length ; i++ ){
            int temp = array[i] ;
            int j = i - 1;

            while ( j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;

            for (int e : array) {
            System.out.print(e + " ");
        }
        System.out.println();
        }
    }


}
