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
					Staff sff=new Staff();
					sff.Name=parts[1];
					sff.Surname=parts[2];
					sff.birth_year=Integer.parseInt(parts[3]);
					sff.startedWork=Integer.parseInt(parts[4]);
					sff.Say();
			}

		}catch(FileNotFoundException e){
				System.out.print("NO FILE!");
		}
	}
}
class Staff{
		String Name, Surname;
		 int birth_year, startedWork;
		 public void Say(){
			 System.out.println(Name+" "+birth_year);
		 }
		 abstract void Salarycalc();
		 /*Pedagogical(String degree,int papers){
			 this.degree=degree;
			 this.papers=papers;
		 }
		 Technical(String department,boolean managerial){
			 this.department=department;
			 this.managerial=managerial;
		 }
		 public String toString(){
			 return department+" "+papers+" ";
			 return degree+" "+managerial+" ";
		 }*/
}
class Salary extends Staff{

}
