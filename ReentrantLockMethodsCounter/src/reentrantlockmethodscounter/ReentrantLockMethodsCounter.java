/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reentrantlockmethodscounter;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author salma
 */
public class ReentrantLockMethodsCounter {

    private final ReentrantLock lock = new ReentrantLock();
    private int count = 0;

    public int incrementAndGet() {
// Check if the lock is currently acquired by any thread
        System.out.println("IsLocked : " + lock.isLocked());
// Check if the lock is acquired by the current thread itself.
        System.out.println("IsHeldByCurrentThread : "
                + lock.isHeldByCurrentThread());
// Try to acquire the lock
        boolean isAcquired = lock.tryLock();
        System.out.println("Lock Acquired : " + isAcquired + "\n");
        if (isAcquired) {
            try {
                Thread.sleep(2000);
                count = count + 1;
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            } finally {
                lock.unlock();
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ReentrantLockMethodsCounter lockMethodsCounter
                = new ReentrantLockMethodsCounter();
        new Thread(() -> {
            System.out.println("IncrementCount (First Thread) : "
                    + lockMethodsCounter.incrementAndGet() + "\n");
        }).start();
        new Thread(() -> {
            System.out.println("IncrementCount (Second Thread) : "
                    + lockMethodsCounter.incrementAndGet() + "\n");
        }).start();
    }
}


