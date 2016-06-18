package higherlevelabstraction;

public interface Position<E> {
/*
 * Returns the element stored at this position
 * @return stored element
 * 
 * */
	E getElement() throws IllegalStateException;
}
