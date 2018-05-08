package annotation.test;

//import java.util.*;

class WaitStackI<I>{

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

class GenericTypeTest{

	public static void main(String[] args){
		WaitStackI<Double> store = new WaitStackI<Double>();
		store.push(19.3);
		store.push(22.7);
		store.push(15.8);
		store.push(27.6);
		store.push(13.3);

		Double total = 0.0;
		while(!store.isEmpty()){
			total += store.pop();
		}
		System.out.printf("Total = %f%n", total);
	}
}













