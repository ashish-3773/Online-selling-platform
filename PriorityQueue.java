public class PriorityQueue<V> implements QueueInterface<V>{

    private NodeBase<V>[] queue;
    private int capacity, currentSize;
    public PriorityQueue(int capacity) {    
    	this.capacity= capacity; //
    	queue = new NodeBase[this.capacity];
    	currentSize=0;
    }

    public int size() {
    	return currentSize;
    }

    public boolean isEmpty() {
    	return currentSize<=0;
    }
	
    public boolean isFull() {
    	return currentSize >= capacity;
    }

    public void enqueue(Node<V> node) {
    	if(isFull()) {
    	return;
    	}
		queue[currentSize]=node;    	
    	currentSize++;
    }

    // In case of priority queue, the dequeue() should 
    // always remove the element with minimum priority value
    public NodeBase<V> dequeue() {
    	if (isEmpty()) {
    		return null;
    	}
    	int i,j=0;
    	NodeBase<V> a = queue[0];
    	for( i=1;i<currentSize;i++) {

    		if(queue[i].getPriority()<a.getPriority()){
    			a = queue[i];
    			j=i;
        		}
    	}
    	for(;j<currentSize-1;j++) {
    		queue[j]=queue[j+1];    			
    	}
    		
    	currentSize--;
    	
		return a;

    }

    public void display () {
	if (this.isEmpty()) {
            System.out.println("Queue is empty");
	}
	for(int i=0; i<currentSize; i++) {
            queue[i].show();
	}
    }

	public void add(int priority, V v) {

		Node<V> node = new Node<V>(priority,v);
		enqueue(node);
	}
}

