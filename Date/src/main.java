
public class main {

	public static void main(String[] args) {
		
		/*Create a date object*/
		Date date = new Date(31,2,3);
		System.out.println("Date:"+date.getDay()+"/"+
		date.getMonth()+"/"+date.getYear());
		
		/*Increase the date*/
		date.increseDay(date);
		System.out.println("Incresed date :"+date.getDay()+"/"+
		date.getMonth()+"/"+date.getYear());
		
		/*Trying set*/
		date.setDay(56);
		System.out.println("Trying setDate:"+date.getDay()+"/"+
		date.getMonth()+"/"+date.getYear());
		
		
		//Insert different day in an array

		Date d[] = new Date [10]; // Creato array
		System.out.println("Creating a new array\n");

		/*Creating array*/
			
		for (int i = 0; i < d.length; i++) {
		d[i] = new Date(i, 2, 3);
		d[i].increseDay(d[i]);;
		System.out.println("\nThis is the "+(i+1)+" object:"+d[i].getDay());
		}
		
		/*Finding the max*/
		
		d[d.length-1].findMax(d);
		

	}

}
