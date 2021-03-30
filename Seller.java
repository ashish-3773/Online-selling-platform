import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Seller<V> extends SellerBase<V> {
	
    public Seller (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, Queue<V> inventory) {
        this.setSleepTime(sleepTime);
        this.lock=lock;
        this.full=full;
        this.empty=empty;
        this.catalog=catalog;
        this.inventory=inventory;
    }
    
    public void sell() throws InterruptedException {
    	lock.lock();
	try {
			NodeBase<V> n=null;
            if(inventory.isEmpty()){
            	
            }
            else {
            	n= inventory.dequeue();
            	while(catalog.isFull()) {
                	full.await();
                }
                	Node<V> no = new Node<V>(n.getPriority(),n.getValue());
                	catalog.enqueue(no);
                
                empty.signalAll();
            }
            
            
	} catch(Exception e) {
            e.printStackTrace();
	} finally {
            lock.unlock();
	}		
    }
}
