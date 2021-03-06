package Algorithms;

import Sort.ArchetypeSort;

public class BubbleEvenOdd extends ArchetypeSort{
    public BubbleEvenOdd(int[] sourceArray, String nameSort){
        super(sourceArray, nameSort);
    }
    
    @Override
    public void run() {

        analyze.start(nameSort);

        for (int i = 0; i < size-1; i++) {
           
            analyze.step();
            
            boolean swapped =  false;

            if(i % 2 == 0){
                for (int j = size-1; j > 0; j--) {

                    analyze.cycle();

                    if(array[j-1] > array[j]){
                        swap(j-1, j);
                        swapped = true;
                    }
                 }
            }else{
                for (int j = size-2; j > 1; j--) {

                    analyze.cycle();

                    if(array[j-1] > array[j]){
                        swap(j-1, j);
                        swapped = true;
                    }
                }
            }
             if(swapped == false)
                 break;
         }
        analyze.stop();
    }
}