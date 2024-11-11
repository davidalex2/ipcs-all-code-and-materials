public class DPDemo {  
   public static void main(String[] args) {  
      SD sD = new SDI();  
    
      for (S s : sD.getAllStudents()) {  
         System.out.println("Student: [RollNo : " + s.getRollNo() + ", Name : " + s.getName() + " ]");  
      }  
 
      S s =sD.getAllStudents().get(0);  
      s.setName("JavaTpoint");  
      sD.updateStudent(s);  
     
      sD.getStudent(0);  
      System.out.println("Student: [RollNo : " + s.getRollNo() + ", Name : " + s.getName() + " ]");       
   }  
}  