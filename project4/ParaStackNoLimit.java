public class ParaStackNoLimit<E> extends ParaStack<E> {

	@Override
	public void push(E element) {
		if (top == super.size - 1) {
			super.size = super.size * 2;
			E[] temp = (E[]) new Object[super.size];
			System.arraycopy(super.list, 0, temp, 0, super.list.length);
			super.list = temp;
		}
		super.push(element);
	}
}
