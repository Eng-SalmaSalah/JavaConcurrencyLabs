/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumelementsstream;

import java.util.ArrayList;

/**
 *
 * @author salma
 */
public class SumElementsStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double[] nums = new double[3000];
        for (int i = 1; i <= nums.length; i++) {
            nums[i - 1] = i;
        }
            PowerThreeTask calcPower = new PowerThreeTask(nums, 0, nums.length);
            calcPower.invoke();
            calcPower.printArray(0, 14);
        

    }

}
