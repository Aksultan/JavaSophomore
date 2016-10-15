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

        Collections.sort(groups.get("A03"));
       // System.out.println(groups.get("A03"));

        Collections.sort(groups.get("A03"),new Averages());
        // System.out.println(groups.get("A03"));
        ArrayList<String> debts = new ArrayList<>();
        for (String l: groups.keySet()) {
            for (int i = 0; i < groups.get(l).size(); i++) {
                int summ = 0;
                for (int y = 0; y < groups.get(l).get(i).grades.length; y++) {
                    summ += groups.get(l).get(i).grades[y];
                }
                if (summ>240 & groups.get(l).get(i).debt == 0) {
                    debts.add("Mr. " + groups.get(l).get(i).name.substring(0, 1) + ". " + groups.get(l).get(i).surname);
                }
            }
        }
        System.out.println(debts);

        String name = in.nextLine();
        String surname = in.nextLine();
        Student s = new Student(name,surname);
        System.out.println(s.name+" "+s.surname);
        for (String l: groups.keySet()) {
            for(int i=0;i<groups.get(l).size();i++){
                if(groups.get(l).get(i).name.equals(s.name) & groups.get(l).get(i).surname.equals(s.surname)){
                    System.out.println("Exist");
                }
            }
        }
		int count=0;
        for (String l: groups.keySet()) {
            for (int x = 0; x < groups.get(l).size(); x++) {
                int summ = 0;
                for (int y = 0; y < groups.get(l).get(x).grades.length; y++) {
                    summ += groups.get(l).get(x).grades[y];
                }
                if (summ>150) {
                    count++;
                }
            }
        }
        System.out.println(count);

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
