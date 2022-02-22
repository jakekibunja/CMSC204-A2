package assignment2;

import java.util.ArrayList;

public class NotationStack<T> implements StackInterface<T> {

	public ArrayList<T> stackArray;
	public int capacity;
	
	public NotationStack(int size){
		stackArray = new ArrayList<T>(size);
		capacity = size;
	}
	
	public NotationStack(){
		stackArray = new ArrayList<T>(5);
		capacity = 10;
	}
	
	public boolean isEmpty() {
		if (stackArray.isEmpty())
			return true;
		else
			return false;
	}

	
	public boolean isFull() {
		boolean fullStack;
		if (stackArray.size() == capacity)
			fullStack = true;
		else
			fullStack = false;
		return fullStack;
	}

	
	public T pop() throws StackUnderflowException {
		T topStack;
		try {
			if (isEmpty())
				throw new StackUnderflowException("Your stack is currently empty");
		}
		catch (StackUnderflowException exception) {
			exception.printStackTrace();
		}
		topStack = stackArray.get(stackArray.size()-1);
		stackArray.remove(stackArray.get(stackArray.size()-1));
		return topStack;
	}

	
	public T top() throws StackUnderflowException {
		try {
			if (isEmpty())
				throw new StackUnderflowException("Your stack is currently empty");
		}
		catch (StackUnderflowException exception) {
			exception.printStackTrace();
		}
		return stackArray.get(stackArray.size()-1);
	}


	public int size() {
		return stackArray.size();
	}


	public boolean push(T e) throws StackOverflowException {
		try {
			if (isFull())
				throw new StackOverflowException("Your stack is currently empty");
		}
		catch (StackOverflowException exception) {
			exception.printStackTrace();
		}
		return stackArray.add(e);
	}

	public String toString() {
		String output = "";
		for (int i = 0; i < stackArray.size(); i++)
			output += stackArray.get(i);
		return output;
	}
	
	public String toString(String delimiter) {
		String output = "";
		for (int i = 0; i < stackArray.size(); i++)
			if (i < stackArray.size()-1)
				output += stackArray.get(i) + delimiter;
			else 
				output += stackArray.get(i);
		return output;
	}


	public void fill(ArrayList list) {
		for (int i = 0; i < list.size(); i++) {
			stackArray.add((T) list.get(i));
		}
	}



}
