import java.util.ArrayList;  
import java.util.List;  
public class SDI implements SD {  
   
   List<S> ss;  
   public SDI(){  
      ss = new ArrayList<S>();  
      S s1 = new S("Sonoo",0);  
      S s2 = new S("Jaiswal",1);  
      ss.add(s1);  
      ss.add(s2);         
   }  
   
   public void deleteStudent(S s) {  
      students.remove(s.getRollNo());  
      System.out.println(" Student: Roll No " + student.getRollNo() + ", has been deleted from the database");  
   }  
      
   public List<S> getAllStudents() {  
      return ss;  
   }  
     
   public S getStudent(int r) {  
      return ss.get(r);  
   }  
 
   public void updateStudent(S s) {  
      ss.get(s.getRollNo()).setName(s.getName());  
      System.out.println(" Student: Roll No " + student.getRollNo() + ", has been updated in the database");  
   }  
}  