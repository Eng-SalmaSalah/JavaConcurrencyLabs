/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraysaccumlator;

/**
 *
 * @author salma
 */
public class ArraysAccumlator implements Runnable {

    static int arr1[] = {1, 2, 3, 4, 5};
    static int arr2[] = {10, 20, 30, 40, 50};
    static int arr3[] = {100, 200, 300, 400, 500};
    static int arr[] = new int[15];
    Thread th1;
    Thread th2;
    Thread th3;
    

    public ArraysAccumlator() {

        th1 = new Thread(this);
        th1.start();
        th2 = new Thread(this);
        th2.start();
        th3 = new Thread(this);
        th3.start();

    }

    public void printArray() {
        for (int k = 0; k < 15; k++) {
            System.out.println(arr[k]);
        }
    }

    public static int checkIndex() {
        int index = 0;
        for (int check = 14; check >=0; check--) {
            if (arr[check] == 0) {
                index = check;
            }
        }
        return index;
    }

    synchronized public static void copyArray(int[] array) {
        int index;
        for (int i = 0; i < 5; i++) {
            index = checkIndex();
            arr[index]=array[i];
        }
    }

    public static void main(String[] args) {
        ArraysAccumlator obj = new ArraysAccumlator();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println("handle interruption");
        }
        obj.printArray();

    }

    @Override
    public void run() {

            if (Thread.currentThread() == th1) {
                copyArray(arr1);
            } else if (Thread.currentThread() == th2 ) {
                copyArray(arr2);
            } else if (Thread.currentThread() == th3 ) {
                copyArray(arr3);
            }
        }
    }


