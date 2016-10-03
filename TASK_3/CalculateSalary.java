import java.util.*;
import java.lang.*;
import java.io.*;
public class CalculateSalary {
	public static void main(String args[]){
		File file=new File("staff.txt");
		Scanner in=new Scanner(System.in);
		Scanner scanner=new Scanner(System.in);
		ArrayList<Staff> staff=new ArrayList<>();
		try{
			in=new Scanner(file);
			while(in.hasNext()){
				String line=in.nextLine();
				String[] parts=line.split(" ");
					Staff sff=new Staff(parts[1], parts[2],Integer.parseInt(parts[3]),Integer.parseInt(parts[4]));
					if(parts[0].equals("P")){
						Pedagogical ped=new Pedagogical(Integer.parseInt(parts[6]),parts[5]);
						staff.add(ped);

					}
					else{
						if(parts[6].equals("M")){
							Technical tech=new Technical(true,parts[5]);
						}
						else{
							Technical tec=new Technical(false,parts[5]);
						}
						staff.add(tec);
						/*dont works without {}*/
					}

			}
			//staff.stream().filter((i)->i.salary()>1000).collect();
		}catch(FileNotFoundException e){
				System.out.print("NO FILE!");
		}
	}
}
class Pedagogical extends Staff{
	int papers;
	String degree;
public Pedagogical(int papers, String degree){
	this.papers=papers;
	this.degree=degree;
}
public int salary(){
	double salary=0;
	int max=0;
	 if (degree.equals("MSc")){
		 salary=300;
	 }
	 else if (degree.equals("BSc")){
		 salary=200;
	 }
	 else if (degree.equals("PhD")){
		 salary=500;
	 }
	 else if (degree.equals("none")){
		 salary=150;
	 }
	 if(papers>1 && papers!=5){
		 salary+=100;
	 }
	 else if(papers>=5){
		 salary+=500;

	 }
	 System.out.println( salary);
	 /*if(papers>max){
		 max=papers;
	 }*/
	}
}
class Technical extends Staff{
	boolean managerial;
	 String department;
	 public Technical(boolean managerial, String department){
		 	this.managerial=managerial;
			this.department=department;
	 }
	 public int salary(){
		double salary=0;
		int year=startedWork-2016;
 		 if (managerial==true){
 			 salary=1500;
 		 }
 		 else{
 			 salary=700;
 		 }
/*ff*/
 		if(year>10){
 				salary=(salary*0.3)+salary;
 		}
 		else if(year>5 && year<10){
 			salary=(salary*0.2)+salary;
 		}
 		else if(year>3 && year<5){
 			salary=(salary*0.1)+salary;
 		}

 	}
}
/*
Or Staff extends Technical and Pedagogical??
*/

class Staff{
		String Name, Surname;
		 int birth_year, startedWork;
		public Staff(String Name, String Surname, int birth_year, int startedWork){
			this.Name=Name;
			this.Surname=Surname;
			this.birth_year=birth_year;
			this.startedWork=startedWork;
		}
		public int salary(){


}
}
