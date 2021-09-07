import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockingObject {
    public Object lock = new Object();

    public void changeValue() {
        synchronized (lock) {
            // ...
            System.out.println("Test");
        }
    }
    
    public void changeValue2() {
        synchronized (getClass()) {
            // ...
            System.out.println("Test");
        }
    }

    public void changeValue3() {
        synchronized ("lock") {
            // ...
            System.out.println("Test");
        }
    }

    private Integer primitive = 2;
    public void changeValue4() {
        synchronized (primitive) {
            // ...
            System.out.println("Test");
        }
    }

    private final Lock intrinsic = new ReentrantLock();
    public void changeValue5() {
        synchronized (intrinsic) {
            // ...
            System.out.println("Test");
        }
    }
}
