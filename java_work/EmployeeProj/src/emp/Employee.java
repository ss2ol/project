package emp;
public abstract class Employee {
   private String id;
   private String name;
   
   Employee(){}
   
   Employee(String id, String name){
      this.id = id;
      this.name = name;
   }

   public abstract int getPay();   
   
   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
   
   @Override
   public String toString() {
      return "사번 : "+getId()+", 이름 : "+getName();
   }
   
   
}