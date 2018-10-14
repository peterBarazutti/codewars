package javaBasics;

public class ChildClass extends ParentClass {

    static {
        System.out.println("static child init block");
    }

    private String name = "childName";

    public ChildClass() {
        super();
        System.out.println("Child constructor");
    }


    public void printer() {
        System.out.println(name);
        System.out.println(info);
    }

    public void childPrinter(){
        System.out.println("What");
    }
}
