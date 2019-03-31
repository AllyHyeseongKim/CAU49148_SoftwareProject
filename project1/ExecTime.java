public class ExecTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 3;
        long startTime = System.nanoTime();
        double result = a * a;
        long endTime = System.nanoTime();

        System.out.println("Execution Time of multipication = " + (endTime - startTime));

        startTime = System.nanoTime();
        double result2 = Math.pow(a,2);
        endTime = System.nanoTime();

        System.out.println("Execution Time of exponentiation = " + (endTime - startTime));
        
	}
	
	

}
