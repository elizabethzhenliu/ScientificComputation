/*
 * Elizabeth Liu zl2358
 * c) the answer is 2027 units at t = 0.2 seconds
 */
public class RungeKutta {
	
	public static void rungeKutta(){
		double t = 0;
		double h = .01;
		double w = h/2;
		double n = 20;
		
		for (int i = 0; i<= n; i++){
			System.out.println(w);
			w = w + h* (myFunct(t + (h/2), w + (h/2) * myFunct(t, w)));
			t += i*h;
		}
		
	}
	
	public static double myFunct(double t, double x){

		
		double k = 6.22 * Math.pow(10, -19);
		double n_1 = 2000;
		double n_2 = 2000;
		double n_3 = 3000;
		
		double myFunct;
		myFunct = k*Math.pow((n_1 - x/2),2)*Math.pow((n_2 - x/2),2)*Math.pow((n_3 - 3*x/4),3);
		
		return myFunct;
	}
	
	public static void main(String[] args){
		rungeKutta();
	}
}
