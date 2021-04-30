package Assignment7.PART5;

public class SecondOuterClass {
    public class SecondInnerClass extends FirstOuterClass.FirstInnerClass{
        public SecondInnerClass(String message) {
            //FirstInnerClass needs an instance of FirstOuterClass
            new FirstOuterClass().super(message);
            System.out.println("Constructor message from second inner class : "+message);
        }
        @Override
        public void method(){
            System.out.println("method call of : SecondOuterClass->SecondInnerClass");
        }
    }
}
