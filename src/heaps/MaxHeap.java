package heaps;

import java.util.Arrays;

//This will only take comparable objects
public class MaxHeap<T extends Comparable> {
	
	//declarations
	private T data[];
	private int size;
	private int capacity;
	
	public MaxHeap(int capacity) {
		super();
		this.capacity = capacity;
		size=0;
		data = (T[]) new Comparable[capacity];//beautiful concept try without typecasting
	}
	
	//get root index
    int parent(int i) {return (i-1)/2;}
    //get index of left child of i
    int left(int i) {return 2*i+1;}
    //get index of right child of i
    int right(int i) {return 2*i+2;}
    
    //get and delete the min element
	
	
	public void insert(T key) {
		
		if(size == capacity) {
			//double the size
			capacity*=2;
			data=Arrays.copyOf(data, capacity);
		}
		
		int i=size;//get the index of inserted node
		data[size]=key;
		size++;
		
		//perform heap up
		while (i!=0 && data[i].compareTo(data[parent(i)]) > 0) {
			//swap with the root
			T s_tmp = data[parent(i)];
			data[parent(i)] = data[i];
			data[i] = s_tmp;
			
			i = parent(i);
		}
	}
	
	@Override
	public String toString() {
		return "MaxHeap [data=" + Arrays.toString(data) + ", size=" + size + ", capacity=" + capacity + "]";
	}

	public T getMax() {return data[0];}
	
	public T extractMax() {
		if(size == 0)
			return null;
		
		T d=data[0];
		size--;//decrement the size
		data[0] = data[size];
		data[size]=null;
		maxHeapify(0);
		return d;
	}
	
	//
	private void maxHeapify(int i) {
		int l=left(i);
		int r=right(i);
		
		int big=i;
		
		if(l < size && data[i].compareTo(data[l]) < 0) {
			big = l;
		}
		
		if(r < size && data[big].compareTo(data[r]) < 0) {
			big = r;
		}
		
		if( i != big) {
			T s_tmp = data[big];
			data[big] = data[i];
			data[i] = s_tmp;
			
			maxHeapify(big);
		}
		
	}
	
	//delete key at index i
	public void deleteKey(int i) {
		/*
		 * To be implemented later
		 * */
	}

	public void decreaseKey(int i, T new_val) {
		if(i>=size) {
			return;
		}
		
		data[i]=new_val;
		//perform heap up
		
		maxHeapify(i);
		/*
		while (i!=0 && data[i].compareTo(data[parent(i)]) > 0) {
			//swap with the root
			T s_tmp = data[parent(i)];
			data[parent(i)] = data[i];
			data[i] = s_tmp;
					
			i = parent(i);
		}*/
	}
}
