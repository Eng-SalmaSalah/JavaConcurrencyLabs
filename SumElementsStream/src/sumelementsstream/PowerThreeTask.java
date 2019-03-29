/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumelementsstream;

import java.util.concurrent.RecursiveAction;

/**
 *
 * @author salma
 */
public class PowerThreeTask extends RecursiveAction {

    final int seqThreshold = 500;
    double insertedArray[];
    int start, end;

    public PowerThreeTask(double[] values, int startIndex, int endIndex) {
        insertedArray = values;
        start = startIndex;
        end = endIndex;
    }
    
    public void printArray(int startOfPrinting,int endOfPrinting)
    {
    System.out.println("array elements are:");
    for (int i=startOfPrinting;i<=endOfPrinting;i++)
        System.out.println(this.insertedArray[i]);
    }

    @Override
    protected void compute() {
        if ((end - start) < seqThreshold) {
            for (int i = start; i < end; i++) {
                insertedArray[i] = Math.pow(i, 3);
            }
        } else {
            int middle = (end + start) / 2;
            invokeAll(new PowerThreeTask(insertedArray, start, middle),
                    new PowerThreeTask(insertedArray, middle, end));
        }
    }

}
