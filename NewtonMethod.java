
public class NewtonMethod {
	public static double pi= Math.PI;
	public static double e = Math.E;
	
	public static double myFunct(double p){
		// takes the value of pn and puts it through function
		// returns value of the function
		
		/*!!!!!HOMEWORK 3 FUNCTION!!!!*/
		double myFunct = (6 * Math.pow(e, -p)) * (Math.cos(2*pi*p))-3; 
		
		/*!!!!!EXTRA CREDIT FUNCTION!!!!!
		 * double myFunct = (1000.0/p)*(1-Math.pow((1+p),-360))- 135000; 
		 */
		
		//System.out.println(myFunct);
		return myFunct;
		
		
	}

	public static double myFunctDeriv(double p){
		// takes value of p returns derivative value
		
		/*!!!!!HOMEWORK 3 FUNCTION!!!!*/
		double myFunctDeriv= -6 * Math.pow(e, -p) * (Math.cos(2*pi*p)+(2*pi*Math.sin(2*pi*p)));
		
		/*!!!!!EXTRA CREDIT FUNCTION!!!!!
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
			System.out.println(p);
		} while (Math.abs(p-pPrev) > epsilon); 
		//at the end of every iteration, checks to see if P(n)-P(n-1) is greater than the error
		//this is the termination criterion that I chose
			
		
		return p;
	}
	public static void main (String[] args){
		
		double p = .01;
		double epsilon = .0001; 
		
		
		
		System.out.println(newton(p, epsilon));
		
		
	}
}
