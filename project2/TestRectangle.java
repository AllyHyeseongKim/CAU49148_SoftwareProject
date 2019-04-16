class Rectangle {
	private float width;
	private float height;
	
	Rectangle(double width, double height) {
		this.width = (float)width;
		this.height = (float)height;
	}
	
	void printRectangleInformation(Rectangle r) {
		System.out.println("Location of the Rectangle : " + r);
		System.out.println("Width of the Rectangle : " + r.width);
		System.out.println("Height of the Rectangle : " + r.height);
	}
	
	void compareRectangle(Rectangle r1, Rectangle r2) {
		printIsItEqualRectangle(r1, r2);
		printComparisonRectangleArea(r1, r2);
	}
	
	void resizeRectangleWithRatio(Rectangle r1, double ratio) {
		r1.width *= ratio;
		r1.height *= ratio;
	}
	
	float calculateAreaOfRectangle(Rectangle r) {
		return r.width * r.height;
	}

	void printIsItEqualRectangle(Rectangle r1, Rectangle r2) {
		if (isItEqualRectangle(r1, r2)) {
			System.out.println("Two rectangles are equal.");
		}
		else {
			System.out.println("Two rectangles are different.");
		}
	}
	
	void printComparisonRectangleArea(Rectangle r1, Rectangle r2) {
		
		if (comparisonOfRectangleArea(r1, r2) == termOfComparison("value1IsBigger")) {
			System.out.println("The Area of the first rectangle is bigger than the second one.");
		}
		else if (comparisonOfRectangleArea(r1, r2) == termOfComparison("value1IsSmaller")) {
			System.out.println("The Area of the first rectangle is smaller than the second one.");
		}
		else {
			System.out.println("Two rectangles are same in area.");
		}
	}
	
	boolean isItEqualRectangle(Rectangle r1, Rectangle r2) {
		if (comparisonOfTwoValues(r1.width, r2.width) == termOfComparison("same") 
				&& comparisonOfTwoValues(r1.height, r2.height) == termOfComparison("same")) {
			return true;
		}
		else {
			return false;
		}
	}

	int comparisonOfRectangleArea(Rectangle r1, Rectangle r2) {
		if (comparisonOfTwoValues(calculateAreaOfRectangle(r1), 
				calculateAreaOfRectangle(r2)) == termOfComparison("value1IsBigger")) {
			return termOfComparison("value1IsBigger");
		}
		else if (comparisonOfTwoValues(calculateAreaOfRectangle(r1), 
				calculateAreaOfRectangle(r2)) == termOfComparison("value1IsSmaller")){
			return termOfComparison("value1IsSmaller");
		}
		else {
			return termOfComparison("same");
		}
	}
	
	int comparisonOfTwoValues(double value1, double value2) {
		if (value1 > value2){
			return termOfComparison("value1IsBigger");
		}
		else if (value1 < value2){
			return termOfComparison("value1IsSmaller");
		}
		else {
			return termOfComparison("same");
		}
	}
	
	int termOfComparison(String term) {
		if (term == "value1IsBigger") {
			return 1;
		}
		else if (term == "value1IsSmaller") {
			return -1;
		}
		else {
			return 0;
		}
	}
}


public class TestRectangle {

	public static void main(String[] args) {
		
		Rectangle r1 = new Rectangle(1.0, 1.0);
		Rectangle r2 = new Rectangle(1.0, 2.0);
		Rectangle r3 = new Rectangle(2.0, 1.0);
		
		System.out.println("* * * Comparison of the rectangle * * *");
		System.out.println("* rectangle r2 *");
		r2.printRectangleInformation(r2);
		System.out.println("* rectangle r3 *");
		r3.printRectangleInformation(r3);
		System.out.println("* Comparison *");
		r2.compareRectangle(r2, r3);
		
		System.out.println("\n* * * Information of the rectangle r1 before changed. * * *");
		r1.printRectangleInformation(r1);
		
		r1.resizeRectangleWithRatio(r1, 2.0);
		
		System.out.println("\n* * * Information of the rectangle r1 after changed. * * *");
		r1.printRectangleInformation(r1);
	}

}
