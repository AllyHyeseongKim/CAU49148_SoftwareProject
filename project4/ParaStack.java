public class ParaStack<E> {
	int size = 4;
	E[] list = (E[]) new Object[4];
	
	protected int top = -1;
	
	public void push(E element) {
		if (top != size - 1) {
			list[++top] = element;
		}
	}
	
	public E pop() {
		if (isEmpty())
			return null;
		E topElement = list[top--];
		return topElement;
	}
	
	public boolean isEmpty() {
		if (top == -1)
			return true;
		return false;
	}
}

