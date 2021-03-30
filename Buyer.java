import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Buyer<V> extends BuyerBase<V> {
    public Buyer (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, int iteration) {
        this.setSleepTime(sleepTime);
        this.lock=lock;
        this.full=full;
        this.empty=empty;
        this.catalog=catalog;
        this.setIteration(iteration);
    }
    public void buy() throws InterruptedException {
    	lock.lock();
	try {
			NodeBase<V> n = null;
			while(catalog.isEmpty()) {
				empty.await();
			}
	        n=catalog.dequeue();
	            
		    System.out.print("Consumed "); 
	            n.show(); 
	        full.signalAll();
	} catch (Exception e) {
            e.printStackTrace();
	} finally {
            lock.unlock();
	}
    }
}
