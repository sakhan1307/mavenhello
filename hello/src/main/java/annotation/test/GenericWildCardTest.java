package annotation.test;

//import java.util.*;

class WaitStackP<I>{

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

class GenericWildCardTest{

	private static void printStack(WaitStackP<?> stack){
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}

	public static void main(String[] args){
		WaitStackP<Double> store = new WaitStackP<Double>();
		store.push(19.3);
		store.push(22.7);
		store.push(15.8);
		store.push(27.6);
		store.push(13.3);

		printStack(store);		
	}
}













