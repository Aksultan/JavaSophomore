import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.*;
import java.util.*;
public class StudentViewerTask {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		HashMap<String,ArrayList<Student>> groups = new HashMap<>();
		ArrayList<Student> students = new ArrayList<>();
		loadValues(groups,students);
		/* This lines should output students ordered by id
		 * Uncomment following line	 */
		Collections.sort(groups.get("A03"));
		System.out.println((groups.get("A03")));
		/* Output students sorted by their average */

		/* Output students who doesn't have debt and has average above 80 points */

		/* Your code should return ArrayList<String>
		 * that contains name and surname in "Mr. J. Bezos" format */

		/* Find if student with specified name and surname present in list */
		String name = in.nextLine();
		String surname = in.nextLine();
		Student s = new Student(name,surname);

		/* Count number of students from each group that got more than 50 points in average*/

		in.close();
	}
	public static void loadValues(HashMap<String,ArrayList<Student>> maps,ArrayList<Student> students){
		try{
			List<String> lines = Files.readAllLines(Paths.get(".", "students.txt"),StandardCharsets.UTF_8);
			lines.forEach((line)->{
				String parts[] = line.split(" ");
				Student s = new Student(Integer.parseInt(parts[0]),parts[1],parts[2],Integer.parseInt(parts[3]),parts[4],parts[5].split(";"),Integer.parseInt(parts[6]));
				students.add(s);
				maps.putIfAbsent(s.group, new ArrayList<Student>());
				maps.get(s.group).add(s);
			});
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
