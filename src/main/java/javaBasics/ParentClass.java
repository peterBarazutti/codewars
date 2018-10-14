package javaBasics;

public class ParentClass implements Protec {

    private String name = "name";
    public String info = "info";

    public ParentClass() {
        System.out.println("Parent constructor");
    }

    public void printer() {
        System.out.println(name);
        System.out.println(info);
    }

    public void parentNamePrinter(){
        System.out.println(name);
    }

}
