/*
* Solving an integral (equal to a constant) for an unknown bound 
* Uses Composite Simpson's rule to approximate for the integral and
* Newton to find the zero
*/
public class NewtonSimpson {


	public static double pi= Math.PI;
	public static double e = Math.E;
	
	public static double myFunct(double p){
		// takes the value of pn and puts it through function
		// returns value of the function
		
		//function
		double myFunct = simpson(0, p, 20) - 0.45; 
		
		
		//System.out.println(myFunct);
		return myFunct;
		
		
	}
	
	public static double simpson(double a, double b, int n){ 
		double h = (b-a)/n;
		double sum_1 = 0;
		double sum_2 = 0;
		
		for (int j = 1; j < n/2; j++){
			sum_1 += myFunctDeriv(( 2*j*h) + a);
		}
		
		for (int j = 1; j < n/2 + 1 ; j++){
			sum_2 += myFunctDeriv( a + ( 2*j - 1) *h);
		}
		
		double answer = (h/3)*(myFunctDeriv(a) + 2*sum_1 + 4*sum_2 + myFunctDeriv(b));
			
				
		return answer;
	
	}

	public static double myFunctDeriv(double p){
		// takes value of p returns derivative value
		
		//function 1
		double myFunctDeriv = (1/(Math.sqrt(2*pi)))*Math.pow(e, -Math.pow(p, 2)/2);; 
		
		/* another possible function
		 * double myFunctDeriv= (-1000.0/(p*p))*(1-Math.pow((1+p),-360)) + (1000.0/p)*(360/Math.pow((1+p),361));
		 */
		
		//System.out.println(myFunctDeriv);
		
		return myFunctDeriv;
		
	}
	
	public static double newton(double p, double epsilon){ // method pointers suck in java

		double pPrev; 
		
		//this do-while loop evaluates the condition at the end
		
		do{
			pPrev = p; //sets current p to pPrev (will update current p in next line)
			p = p-(myFunct(p)/myFunctDeriv(p)); //updating PsubN
			//System.out.println(p);
		} while (Math.abs(p-pPrev) > epsilon); 
		//at the end of every iteration, checks to see if P(n)-P(n-1) is greater than the error
		//this is the termination criterion that I chose
			
		
		return p;
	}
	public static void main (String[] args){
		
		double p = .5;
		double epsilon = .00001; 
		
	
		System.out.println("Answer: " + newton(p, epsilon));
		
	}


	
}
