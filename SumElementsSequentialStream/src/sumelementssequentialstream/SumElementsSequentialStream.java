/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumelementssequentialstream;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 *
 * @author salma
 */
public class SumElementsSequentialStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Double> myListOfNumbers = new ArrayList<>();
        for (int i = 0; i < 3000; i++) {
            myListOfNumbers.add((double) i);
        }
        ArrayList<Double> result;

        result = myListOfNumbers.stream()
                .map((element) -> Math.pow(element, 3)).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println("first 15 array elements are:");
        for (int i=0;i<15;i++)
            System.out.println(result.get(i));

    }
}
