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
					if(parts[5].equals("MSc") || parts[5].equals("BSc") || parts[5].equals("PhD") || parts[5].equals("Prof") || parts[5].equals("none")){
						Pedagogical ped=new Pedagogical(Integer.parseInt(parts[6]),parts[5]);
					}
					else{
						if(parts[6].equals("M")){
							Technical tech=new Technical(true,parts[5]);
						}
						else{
						Technical tec=new Technical(false,parts[5]);
						}
						/*dont works without {}*/
					}

			}

		}catch(FileNotFoundException e){
				System.out.print("NO FILE!");
		}
	}
}
class Pedagogical{
	int papers;
	String degree;
public Pedagogical(int papers, String degree){
	this.papers=papers;
	this.degree=degree;
}
}
class Technical{
	boolean managerial;
	 String department;
	 public Technical(boolean managerial, String department){
		 	this.managerial=managerial;
			this.department=department;
	 }

}


/*
Or Staff extends Technical and Pedagogical??
*/

class Staff {
		String Name, Surname;
		 int birth_year, startedWork;
		public Staff(String Name, String Surname, int birth_year, int startedWork){
			this.Name=Name;
			this.Surname=Surname;
			this.birth_year=birth_year;
			this.startedWork=startedWork;
		}
}
