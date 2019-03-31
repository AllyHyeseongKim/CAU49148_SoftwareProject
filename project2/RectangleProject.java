class Rectangle {
	float width;
	float height;
	
	Rectangle(double width, double height) {
		this.width = (float)width;
		this.height = (float)height;
	}
	
	static void printRectangleInformation(Rectangle r) {
		System.out.println("Location of the Rectangle : " + r);
		System.out.println("Width of the Rectangle : " + r.width);
		System.out.println("Height of the Rectangle : " + r.height);
	}
	
	static void compareRectangle(Rectangle r1, Rectangle r2) {
		CompareRectangle.printIsItEqualRectangle(r1, r2);
		CompareRectangle.printComparisonRectangleArea(r1, r2);
	}
	
	static void resizeRectangleWithRatio(Rectangle r1, double ratio) {
		r1.width *= ratio;
		r1.height *= ratio;
	}
	
	static float calculateAreaOfRectangle(Rectangle r) {
		return r.width * r.height;
	}
}

class CompareRectangle {
	
	static void printIsItEqualRectangle(Rectangle r1, Rectangle r2) {
		if (isItEqualRectangle(TestRectangle.r2, TestRectangle.r3)) {
			System.out.println("Two rectangles are equal.");
		}
		else {
			System.out.println("Two rectangles are different.");
		}
	}
	
	static void printComparisonRectangleArea(Rectangle r1, Rectangle r2) {
		
		if (comparisonOfRectangleArea(r1, r2) == Compare.termOfComparison("value1IsBigger")) {
			System.out.println("The Area of the first rectangle is bigger than the second one.");
		}
		else if (comparisonOfRectangleArea(r1, r2) == Compare.termOfComparison("value1IsSmaller")) {
			System.out.println("The Area of the first rectangle is smaller than the second one.");
		}
		else {
			System.out.println("Two rectangles are same in area.");
		}
	}
	
		static boolean isItEqualRectangle(Rectangle r1, Rectangle r2) {
		if (Compare.comparisonOfTwoValues(r1.width, r2.width) == Compare.termOfComparison("same") 
				&& Compare.comparisonOfTwoValues(r1.height, r2.height) == Compare.termOfComparison("same")) {
			return true;
		}
		else {
			return false;
		}
	}

	static int comparisonOfRectangleArea(Rectangle r1, Rectangle r2) {
		if (Compare.comparisonOfTwoValues(Rectangle.calculateAreaOfRectangle(r1), 
				Rectangle.calculateAreaOfRectangle(r2)) == Compare.termOfComparison("value1IsBigger")) {
			return Compare.termOfComparison("value1IsBigger");
		}
		else if (Compare.comparisonOfTwoValues(Rectangle.calculateAreaOfRectangle(r1), 
				Rectangle.calculateAreaOfRectangle(r2)) == Compare.termOfComparison("value1IsSmaller")){
			return Compare.termOfComparison("value1IsSmaller");
		}
		else {
			return Compare.termOfComparison("same");
		}
	}
	
}
class Compare {
	
	static int comparisonOfTwoValues(double value1, double value2) {
		if (value1 > value2){
			return Compare.termOfComparison("value1IsBigger");
		}
		else if (value1 < value2){
			return Compare.termOfComparison("value1IsSmaller");
		}
		else {
			return Compare.termOfComparison("same");
		}
	}
	
	static int termOfComparison(String term) {
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

class TestRectangle {
	static Rectangle r1 = new Rectangle(1.0, 1.0);
	static Rectangle r2 = new Rectangle(1.0, 2.0);
	static Rectangle r3 = new Rectangle(2.0, 1.0);
	
}

public class RectangleProject {

	public static void main(String[] args) {
		
		System.out.println("* * * Comparison of the rectangle * * *");
		System.out.println("* rectangle r2 *");
		Rectangle.printRectangleInformation(TestRectangle.r2);
		System.out.println("* rectangle r3 *");
		Rectangle.printRectangleInformation(TestRectangle.r3);
		System.out.println("* Comparison *");
		Rectangle.compareRectangle(TestRectangle.r2, TestRectangle.r3);
		
		System.out.println("\n* * * Information of the rectangle r1 before changed. * * *");
		Rectangle.printRectangleInformation(TestRectangle.r1);
		
		Rectangle.resizeRectangleWithRatio(TestRectangle.r1, 2.0);
		
		System.out.println("\n* * * Information of the rectangle r1 after changed. * * *");
		Rectangle.printRectangleInformation(TestRectangle.r1);
	}

}

