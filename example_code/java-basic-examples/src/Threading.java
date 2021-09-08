import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Threading implements Runnable{
    private static ThreadGroup tg = new ThreadGroup("Chief");

    @Override public void run() {
        new Thread(tg, "thread1").start();
        new Thread(tg, "thread2").start();
        new Thread(tg, "thread3").start();
    }

    public static void printActiveCount(int point) {
        System.out.println("Active Threads in Thread Group " + tg.getName() +
                " at point(" + point + "):" + " " + tg.activeCount());
    }

    public static void printEnumeratedThreads(Thread[] ta, int len) {
        System.out.println("Enumerating all threads...");
        for (int i = 0; i < len; i++) {
            System.out.println("Thread " + i + " = " + ta[i].getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Start thread controller
        Thread thread = new Thread(tg, new Threading(), "controller");
        thread.start();

        thread.stop();
        // Gets the active count (insecure)
        Thread[] ta = new Thread[tg.activeCount()];

        printActiveCount(1); // P1
        // Delay to demonstrate TOCTOU condition (race window)
        Thread.sleep(1000);
        // P2: the thread count changes as new threads are initiated
        printActiveCount(2);
        // Incorrectly uses the (now stale) thread count obtained at P1
        int n = tg.enumerate(ta);
        // Silently ignores newly initiated threads
        printEnumeratedThreads(ta, n);
        // (between P1 and P2)

        // This code destroys the thread group if it does
        // not have any live threads
        for (Thread thr : ta) {
            thr.interrupt();
            while(thr.isAlive());
        }
        tg.destroy();
    }

    public final class ProcessStep implements Runnable {
        private static final Object lock = new Object();
        private static int time = 0;
        private final int step; // Perform operations when field time
        // reaches this value
        public ProcessStep(int step) {
            this.step = step;
        }

        @Override public void run() {
            try {
                synchronized (lock) {
                    while (time != step) {
                        lock.wait();
                    }

                    // Perform operations

                    time++;
                    lock.notify(); // Use notifyAll() instead of notify()
                }
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt(); // Reset interrupted status
            }
        }
    }

    public class ProcessStep2 implements Runnable {
        private static final Lock lock = new ReentrantLock();
        private static final Condition condition = lock.newCondition();
        private static int time = 0;
        private final int step; // Perform operations when field time
        // reaches this value
        public ProcessStep2(int step) {
            this.step = step;
        }

        @Override public void run() {
            lock.lock();
            try {
                if (time != step) {
                    condition.await();
                }

                while (time != step) {
                    condition.await();
                }

                // Perform operations

                time++;
                condition.signal();
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt(); // Reset interrupted status
            } finally {
                lock.unlock();
            }
        }
    }
}
