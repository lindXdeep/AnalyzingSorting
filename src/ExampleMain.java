import Analyze.*;
import Sort.*;

class ExampleMain{
    
    private static ArrayHandle arrayHandle = ArrayHandle.getInstance();
    
    private static int[] array = arrayHandle.getRandomIntArray(1000000);
    
    public void initializing(){
        // System.out.print("Source array: ");
        // arrayHandle.printArray(array);
        // System.out.println();
    }

    public void sortingAlgorithms(){

        SelectSort sortSelect = new SelectSort(array);

        Sorting selection = sortSelect.getSorting(TypeSort.SELECTION);
        Thread selection_thread = new Thread(selection); 
                selection_thread.start();      
        
        Sorting insertion = sortSelect.getSorting(TypeSort.INSERTION);
        Thread insertion_thread = new Thread(insertion); 
                insertion_thread.start();     
        
        Sorting insertionGuarded = sortSelect.getSorting(TypeSort.INSERTIONGUARDED);
        Thread insertionGuarded_thread = new Thread(insertionGuarded);
                insertionGuarded_thread.start();

        Sorting bubble = sortSelect.getSorting(TypeSort.BUBBLE);
        Thread bubble_thread =  new Thread(bubble);
                bubble_thread.start();
        
        Sorting bubbleOptim = sortSelect.getSorting(TypeSort.BUBBLEOPTIM);
        Thread bubble_optim_thread = new Thread(bubbleOptim);
                bubble_optim_thread.start(); 

        Sorting bubbleTwoForcked = sortSelect.getSorting(TypeSort.BUBBLETWOFORCKED);
        Thread bubbleTwoForcked_thread = new Thread(bubbleTwoForcked);
                bubbleTwoForcked_thread.start();

        Sorting bubbleShaker = sortSelect.getSorting(TypeSort.BUBBLESHAKER);
        Thread bubbleShaker_thread = new Thread(bubbleShaker);
                bubbleShaker_thread.start();

        Sorting bubbleEvenOdd = sortSelect.getSorting(TypeSort.BUBBLEEVENODD);
        Thread bubbleEventOdd_thread = new Thread(bubbleEvenOdd);
                bubbleEventOdd_thread.start();

        Sorting comb = sortSelect.getSorting(TypeSort.COMB);
        Thread comb_thread =  new Thread(comb);
                comb_thread.start();

        Sorting shell = sortSelect.getSorting(TypeSort.SHELL);
        Thread shell_thread = new Thread(shell);
                shell_thread.start();
    
        Sorting shell_Sedgewick = sortSelect.getSorting(TypeSort.SHELL_SEDGEWICK);
        Thread shell_Sedgewick_thread = new Thread(shell_Sedgewick);
            shell_Sedgewick_thread.start();
               
        Sorting quick = sortSelect.getSorting(TypeSort.QUICK);      
                Thread quick_thread =  new Thread(quick);
                        quick_thread.start();

        Sorting merge = sortSelect.getSorting(TypeSort.MERGE);
        Thread merge_thread = new Thread(merge);
                merge_thread.start();
        
        Sorting heap = sortSelect.getSorting(TypeSort.HEAP);
        Thread heap_thread = new Thread(heap);
                heap_thread.start();

        Sorting bucket = sortSelect.getSorting(TypeSort.BUCKET);
        Thread bucket_thread = new Thread(bucket);
                bucket_thread.start();

        Sorting counting = sortSelect.getSorting(TypeSort.COUNTING);
        Thread counting_thread =  new Thread(counting);
                counting_thread.start();
                
        try {
            selection_thread.join();
            insertion_thread.join(); 
            bubble_thread.join(); 
            bubble_optim_thread.join();
            bubbleEventOdd_thread.join();
            bubbleTwoForcked_thread.join();
            bubbleShaker_thread.join();
            comb_thread.join();
            shell_thread.join();
            shell_Sedgewick_thread.join();
            insertionGuarded_thread.join();
            quick_thread.join();
            merge_thread.join();
            heap_thread.join();
            bucket_thread.join();
            counting_thread.join();

        } catch (InterruptedException e) {
            e.getMessage();
        }
                
        arrayHandle.checkSequence(selection);
        arrayHandle.checkSequence(insertion);
        arrayHandle.checkSequence(insertionGuarded);
        arrayHandle.checkSequence(bubble);
        arrayHandle.checkSequence(bubbleOptim);
        arrayHandle.checkSequence(bubbleTwoForcked);
        arrayHandle.checkSequence(bubbleShaker);
        arrayHandle.checkSequence(bubbleEvenOdd);
        arrayHandle.checkSequence(comb);
        arrayHandle.checkSequence(shell);
        arrayHandle.checkSequence(shell_Sedgewick);
        arrayHandle.checkSequence(quick);
        arrayHandle.checkSequence(merge);
        arrayHandle.checkSequence(heap);
        arrayHandle.checkSequence(bucket);

        arrayHandle.checkSequence(counting);
        
        // arrayHandle.printArray(selection.getResultsArrray());
        // arrayHandle.printArray(selection);
        // arrayHandle.printArray(insertion);
        // arrayHandle.printArray(insertionGuarded);
        // arrayHandle.printArray(bubble);
        // arrayHandle.printArray(bubbleOptim);
        // arrayHandle.printArray(bubbleTwoForcked);
        // arrayHandle.printArray(bubbleShaker);
        // arrayHandle.printArray(bubbleEvenOdd);
        // arrayHandle.printArray(comb);
        // arrayHandle.printArray(shell);
        // arrayHandle.printArray(shell_Sedgewick);
        // arrayHandle.printArray(quick);
        // arrayHandle.printArray(merge);
        // arrayHandle.printArray(heap);
        // arrayHandle.printArray(counting);

        ResultsAnalyze.getInstance().viewResults();
    }

    public static void main(String[] args) {
        
        Thread mainThread =  new Thread(new Runnable(){
            @Override
            public void run() {
                ExampleMain basicAlgorithms = new ExampleMain();
                            basicAlgorithms.initializing();
                            basicAlgorithms.sortingAlgorithms();
            }
        });

        mainThread.setName("Main");
        mainThread.start();
        System.out.println("Thread: " + mainThread.getName() + " started . . .");
    }
}