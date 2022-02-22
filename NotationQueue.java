package assignment2;
import java.util.ArrayList;


public class NotationQueue<T> implements QueueInterface<T>{
	
	public ArrayList<T> queueArray;
	public int capacity;
	
	public NotationQueue(int size){
		queueArray = new ArrayList<T>(size);
		capacity = size;
	}
	
	public NotationQueue(){
		queueArray = new ArrayList<T>(5);
		capacity = 5;
	}
	public boolean isEmpty(){
		if (queueArray.isEmpty())
			return true;
		else
			return false;
	}
	
	public boolean isFull(){
		boolean fullQueue;
		if (queueArray.size() == capacity)
			fullQueue = true;
		else
			fullQueue = false;
		return fullQueue;
	}
	
	public boolean enqueue(T e) throws QueueOverflowException {
		
		try {
			if(isFull())
				throw new QueueOverflowException("Your queue is currently full");
			}
		catch (QueueOverflowException exception) {
			exception.printStackTrace();
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		return queueArray.add(e);
	}
	
	public T dequeue() throws QueueUnderflowException{
		T remove;
		try {
			if (queueArray.isEmpty()) {
				throw new QueueUnderflowException("Your queue is currently empty");
			}
		}
		catch (QueueUnderflowException exception) {
			exception.printStackTrace();
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		remove = queueArray.get(0);
		queueArray.remove(0);
		
		return remove;
	}

	
	public int size() {
		return queueArray.size();
	}
	
	public String toString() {
		String output = "";
		for (int i = 0; i < queueArray.size(); i++)
			output += queueArray.get(i);
		return output;
	}
	public String toString(String delimiter) {
		String output = "";
		for (int i = 0; i < queueArray.size(); i++)
			if (i < queueArray.size()-1)
				output += queueArray.get(i) + delimiter;
			else 
				output += queueArray.get(i);
		return output;
	}

	@Override
	public void fill(ArrayList list) {
		for (int i = 0; i < list.size(); i++) {
			queueArray.add((T) list.get(i));
		}
	}

}
