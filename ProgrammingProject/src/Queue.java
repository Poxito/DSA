import java.util.EmptyStackException;

public class Queue<T> {

	private T[] queue;
	private final int CAPACITY;
	private int front, rear, count;
	
	public Queue(){
		CAPACITY = 50;
		queue = (T[]) new Object[CAPACITY];
		front = rear = count = 0;
	}
	
	public void enqueue(T element) {
		if(size() == queue.length) {
			expand();
		}
		queue[rear] = element;
		rear = (rear+1) % queue.length;
		count++;
	}
	
	public T dequeue()  throws EmptyStackException{
		if(isEmpty()) throw new EmptyStackException();
		
		T result = queue[front];
		queue[front] = null;
		front = (front+1) % queue.length;
		count--;
		return result;
	}
	
	public T first() {
		if(isEmpty()) throw new EmptyStackException();
		
		return queue[front];
	}
	
	public boolean isEmpty() {
		return (count == 0);
	}
	
	public int size() {
		return count;
	}
	
	public void expand() {
		T[] expanded = (T[]) new Object[CAPACITY*2];
		for(int i=0; i<count; i++) {
			expanded[i] = queue[front];
			front = (front+1) % queue.length;
		}
		
		front = 0;
		rear = count;
		queue = expanded;
	}
}
