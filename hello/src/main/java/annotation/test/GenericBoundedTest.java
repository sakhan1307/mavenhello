package annotation.test;

//import java.util.*;

class WaitStack<I>{

	private StackNode<I> top;

	public synchronized void push(I value){
		StackNode<I> node = new StackNode<I>(value);
		node.previous = top;
		top = node;
		notify();
	}

	public synchronized I pop(){
		if(top == null){
			try{
				wait();
			}catch(InterruptedException e){
				return null;
			}
		}
		I value = top.item;
		top = top.previous;
		return value;
	}

	public boolean isEmpty(){
		return top == null;
	}

	private static class StackNode<T>{

		T item;
		StackNode<T> previous;

		public StackNode(T value){
			item = value;
		}
	}
}

class GenericBoundedTest{

	private static<T extends Comparable<T>> T maximum(WaitStack<T> stack){
		if(stack.isEmpty()) return null;
		T max = stack.pop();
		while(!stack.isEmpty()){
			T val = stack.pop();
			if(val.compareTo(max) > 0) max = val;
		}
		return max;
	}

/*	private static<T> void printStack(WaitStack<T> stack){
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}*/

	public static void main(String[] args){
		WaitStack<Double> store = new WaitStack<Double>();
		store.push(19.3);
		store.push(22.7);
		store.push(15.8);
		store.push(27.6);
		store.push(13.3);

		// printStack(store);
		System.out.printf("Maximum = %f%n", maximum(store));
	}
}













