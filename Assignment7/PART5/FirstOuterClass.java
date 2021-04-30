package Assignment7.PART5;

public class FirstOuterClass {
    public class FirstInnerClass{
        public FirstInnerClass(String message){
            System.out.println("Constructor message from first inner class : "+message);
        }
        public void method(){
            System.out.println("method call of : FirstOuterClass->FirstInnerClass");
        }
    }
}
