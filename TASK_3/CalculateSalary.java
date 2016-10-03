import java.util.*;
import java.lang.*;
import java.io.*;
public class CalculateSalary {
	public static void main(String args[]){
		File file=new File("staff.txt");
		Scanner in=new Scanner(System.in);
		Scanner scanner=new Scanner(System.in);
		ArrayList<Pedagogical> pedo=new ArrayList<>();
		ArrayList<Technical> tehno=new ArrayList<>();
		try{
			in=new Scanner(file);
			while(in.hasNext()){
				String line=in.nextLine();
				String[] parts=line.split(" ");
					if(parts[0].equals("P")){
						Pedagogical ped=new Pedagogical(parts[1], parts[2],Integer.parseInt(parts[3]),Integer.parseInt(parts[4]),Integer.parseInt(parts[6]),parts[5]);
						pedo.add(ped);

					}
					else{
						if(parts[6].equals("M")){
							Technical tec=new Technical(parts[1], parts[2],Integer.parseInt(parts[3]),Integer.parseInt(parts[4]), true,parts[5]);
							tehno.add(tec);
						}
						else{
							Technical tec=new Technical(parts[1], parts[2],Integer.parseInt(parts[3]),Integer.parseInt(parts[4]), false,parts[5]);
							tehno.add(tec);
						}

						/*dont works without {}*/
					}

			}
			//staff.stream().filter((i)->i.salary()>1000).collect();
		}catch(FileNotFoundException e){
				System.out.print("NO FILE!");
		}
	}
}
class Pedagogical{
	String Name;
	String Surname;
	int birth_year;
	int startedWork;
	int papers;
	String degree;
public Pedagogical(String Name, String Surname, int birth_year, int startedWork, int papers, String degree){
	this.Name=Name;
	this.Surname=Surname;
	this.birth_year=birth_year;
	this.startedWork=startedWork;
	this.papers=papers;
	this.degree=degree;
}
public int salary(){
	double salary=0;
	int max=0;
	int year=(2016-startedWork);
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
	 if(year>10){
			 salary=(salary*0.3)+salary;
	 }
	 else if(year>5 && year<10){
		 salary=(salary*0.2)+salary;
	 }
	 else if(year>3 && year<5){
		 salary=(salary*0.1)+salary;
	 }
	 System.out.println(salary);
	 /*if(papers>max){
		 max=papers;
	 }*/
	}
}

class Technical{
	String Name;
	String Surname;
	int birth_year;
	int startedWork;
	boolean managerial;
	String department;
	 public Technical(String Name, String Surname, int birth_year, int startedWork, boolean managerial, String department){
		 this.Name=Name;
		 this.Surname=Surname;
		 this.birth_year=birth_year;
		 this.startedWork=startedWork;
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
class Staff{
	String Name;
	String Surname;
	int birth_year;
	int startedWork;
	int papers;
	String degree;
	boolean managerial;
	String department;
	public Staff(
		String Name,String Surname,String degree, String department,
		int birth_year,int startedWork,int papers,
		boolean managerial){
			this.Name=Name;
 		 this.Surname=Surname;
 		 this.birth_year=birth_year;
 		 this.startedWork=startedWork;
 		 this.managerial=managerial;
 		 this.department=department;
	 	this.papers=papers;
	 	this.degree=degree;

		}
}
