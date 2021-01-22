import javax.xml.crypto.Data;

public class Date {

	private int day;
	private int month;
	private int year;
	
	/*Date constructor*/
	Date(int a, int b, int c) {
		
		this.day=a;
		this.month=b;
		this.year=c;
	}
	/*Method to increse the day*/
	public void increseDay(Date d) {
		
		if (d.day == 31) {
	d.day=1;
	d.month++;
			}
		else {
			d.day++;
		}
	}
	
	public Date (Date f) {
	 this.day = f.getDay();
	 this.month = f.getMonth();
	 this.year = f.getYear();
	}
	
	
	/*Finding the max number*/
	
	public void findMax(Date d[]) {
		for (int i = 0; i < d.length; i++) {
		int massimo = d[i].getDay();
		if (d[i].getDay() > massimo) {
			massimo = d[i].getDay();} 
		
		/*Printing the max number*/
		if ( i == (d.length-1)) {
			System.out.println("\n The max number is:"+massimo);}
	 }
	}
	
	
    public int getDay()
	{return day;}
	
    public int getMonth()
 	{return month;}
     
    public int getYear()
 	{return year;}
    
    public void setDay(int a) {
    this.day=a;}
    
    public void setMonth(int a) {
    this.month=a;}

    public void setYear(int a) {
    this.year=a;}
    
}
