public class GenericStack {

	String[] list = (String[]) new Object[4];
	
	private int top = -1;
	
	public void push(String element) {
		if (top != 3) {
			list[++top] = element;
		}
	}
	
	public String pop() {
		if (isEmpty())
			return null;
		String topElement = list[top--];
		return topElement;
	}
	
	public boolean isEmpty() {
		if (top == -1)
			return true;
		return false;
	}
}

