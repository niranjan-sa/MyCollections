/**
 * 
 */
package higherlevelabstraction;

/**
 * @author Niranjan
 *
 */
public interface Stack<E> {
	/*Returns the size*/
	public int size();
	/*Returns true if stack is empty*/
	public boolean isEmpty();
	/*Inserts the element on top of the stack*/
	public void push(E e);
	/*Deletes the element on top of the stack*/
	public E pop();
	/*Returns the element on top of the class*/
	public E top();
}
