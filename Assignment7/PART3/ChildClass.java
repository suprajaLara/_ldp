package Assignment7.PART3;

public class ChildClass extends ConcreteClass implements ChildInterface{
    @Override
    public void method7() {
        System.out.println("method7 of ChildInterface");
    }

    @Override
    public void method1() {
        System.out.println("method1 of Interface1");
    }

    @Override
    public void method2() {
        System.out.println("method2 of Interface1");
    }

    @Override
    public void method3() {
        System.out.println("method3 of Interface2");
    }

    @Override
    public void method4() {
        System.out.println("method4 of Interface2");
    }

    @Override
    public void method5() {
        System.out.println("method5 of Interface3");
    }

    @Override
    public void method6() {
        System.out.println("method6 of Interface3");
    }
}
