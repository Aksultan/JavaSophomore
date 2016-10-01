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
					if(parts[5].equals("MSc") || parts[5].equals("BSc") || parts[5].equals("PhD") || parts[5].equals("Prof") || parts[5].equals("none")){
						Pedagogical ped=new Pedagogical(Integer.parseInt(parts[6]),parts[5]);
					}
					else{
						if(parts[6].equals(M))
						Technical tech=new Technical("true",parts[5]);
						else
						Technical tec=new Technical("false",parts[5]);
					}

			}

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
}
class Technical extends Staff{
	String managerial;
	 String department;
	 public Technical(String managerial, String department){
		 	this.managerial=managerial;
			this.department=department;
	 }

}

/*
Or Staff extends Technical and Pedagogical??
*/

class Staff{
		String Name, Surname;
		 int birth_year, startedWork;
		 /*abstract void Salarycalc();*/
}
/*class Salary extends Staff{

}*/
