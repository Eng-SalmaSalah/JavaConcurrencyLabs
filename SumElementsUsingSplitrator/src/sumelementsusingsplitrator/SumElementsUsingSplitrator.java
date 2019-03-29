/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumelementsusingsplitrator;

import java.util.ArrayList;
import java.util.Spliterator;

/**
 *
 * @author salma
 */
public class SumElementsUsingSplitrator {

    static double sum=0;
    public static void main(String[] args) {
        ArrayList<Double> myListOfNumbers = new ArrayList<>();
        for (int i = 0; i < 3000; i++) {
            myListOfNumbers.add((double) i+1);
        }
        Spliterator<Double> mainSpliterator = myListOfNumbers.stream().spliterator();

        Spliterator<Double> splitItr1 = mainSpliterator.trySplit();
        Spliterator<Double> splitItr2 = mainSpliterator.trySplit();
        Spliterator<Double> splitItr3 = splitItr1.trySplit();
        

        System.out.println("Output from first splitItr: ");
        mainSpliterator.forEachRemaining((n) -> {
                n=Math.pow(n, 3);
                //System.out.println(n);
                sum+=n;
            });
            System.out.println("kkkkkkkkk");
        if (splitItr1 != null) {
            splitItr1.forEachRemaining((n) -> {
                n=Math.pow(n, 3);
                //System.out.println(n);
                sum+=n;
            });
            System.out.println("kkkkkkkkk");
        }
        System.out.println("Output from second splitItr: ");
        if (splitItr2 != null) {
            System.out.println("kkkkkkkkk");
            splitItr2.forEachRemaining((n) -> {
                n=Math.pow(n, 3);
               // System.out.println(n);
                sum+=n;
            });
        }
        System.out.println("Output from third splitItr: ");
        if (splitItr3 != null) {
            splitItr3.forEachRemaining((n) -> {
                n=Math.pow(n, 3);
                System.out.println(n);
                sum+=n;
            });
        }
        System.out.println("\n"+sum);
      
    }

}
