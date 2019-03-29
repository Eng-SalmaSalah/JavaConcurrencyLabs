/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reentrantlockcounter;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author salma
 */
public class ReentrantLockCounter {

    private final ReentrantLock lock = new ReentrantLock();
    private int count = 0;
// Thread Safe Increment

    public void increment() {
        lock.lock();
        try {
            count = count + 1;
        } finally {
            lock.unlock();
        }
    }
    public void printCounter() {
        System.out.println(count);
    }
    

    public static void main(String[] args) {
        ReentrantLockCounter counterObj = new ReentrantLockCounter();
        counterObj.increment();
        counterObj.printCounter();    
    }

}
