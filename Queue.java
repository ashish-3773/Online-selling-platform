public class Queue<V> implements QueueInterface<V>{

    //TODO Complete the Queue implementation
    private NodeBase<V>[] queue;
    private int capacity, currentSize, front, rear;
	
    public Queue(int capacity) {    
    	this.capacity=capacity;
    	front = 0;
    	rear= -1;
    	queue=new NodeBase[capacity];
    	currentSize = 0;
    }

    public int size() {
    	return currentSize;
    }

    public boolean isEmpty() {
    	return (currentSize<=0);
    }
	
    public boolean isFull() {
    	return (currentSize >= capacity);
    
    }

    public void enqueue(Node<V> node) {
    	if(isFull()) {
    		return;
    	}
    	if(isEmpty()) {
    		front =0;
    		rear =0;
    		queue[rear]= node;
    	}
    	else  {
    		rear = ((rear+1)%capacity);
    		queue[rear]= node;
    	}
    	currentSize++;
    }

    public NodeBase<V> dequeue() {
    	NodeBase<V> node;
    	if (isEmpty()) {
    		return null;
    	}
    	
		node=queue[front];
		front = ((front+1)%capacity);
    	currentSize--;
    	return node;
    }

}

