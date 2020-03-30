package Lab3;




import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    
    private String groupId;
    private List<Double> grades = new ArrayList<>();
    private double average;
    private double suma;
    
    public Student(String firstName, String lastName,String emailAddress, String groupId) {
        super(firstName, lastName, emailAddress);
        this.groupId = groupId;
    }   

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    
    public List<Double> getGrades() {
        return grades;
    }
    
    public void addGrade(double grade){
        grades.add(grade);
    }
    
    public void getGradesAverage(){
        
        suma = 0;
        for ( int i = 0 ; i<grades.size();i++){
            average += grades.get(i);
            suma+=1;
        }
        
        System.out.format("%.2f%n",average/suma);
    }
}