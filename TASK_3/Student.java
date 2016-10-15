import java.util.Arrays;
import java.util.Comparator;

public class Student implements Comparable<Student>{
    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    public Student(int id, String name, String surname, int age,
                   String group, String[] grades, int debt) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.group = group;
        this.grades = Arrays.stream(grades).mapToInt(Integer::parseInt).toArray();
        this.debt=debt;
    }
    String name,surname,group;
    int age,debt;
    int grades[];
    int id;
    public int compareTo(Student o) {
        if (this.id > o.id)
            return 1;
        else if (this.id == o.id)
            return 0;
        else
            return -1;
    }
}
class Averages implements Comparator {
    public int compare( Object o1, Object o2 ){

        int sum1 = 0;
        int sum2 = 0;
        for (int i=0;i<((Student)o1).grades.length;i++){
            sum1+=((Student)o1).grades[i];
            sum2+=((Student)o2).grades[i];
        }
        int avg1=sum1/((Student)o1).grades.length;
        int avg2=sum2/((Student)o2).grades.length;

        if ( avg1 > avg2 ){ return 1; }
        else if ( avg1 < avg2 ){ return -1; }
        return 0;
    }
}
class Debts implements Comparator {
    public int compare( Object o1, Object o2 ){

        int sum1 = 0;
        int sum2 = 0;
        for (int i=0;i<((Student)o1).grades.length;i++){
            sum1+=((Student)o1).grades[i];
            sum2+=((Student)o2).grades[i];
        }
        int avg1=sum1/((Student)o1).grades.length;
        int avg2=sum2/((Student)o2).grades.length;

        int debt1=((Student)o1).debt;
        int debt2=((Student)o2).debt;

        if ( avg1 > avg2 ){ return 1; }
        else if ( avg1 < avg2 ){ return -1; }
        return 0;
    }
}
