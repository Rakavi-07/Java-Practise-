package com.company.security;

public class AccessModifierDemo {
    private int privateField;
    String defaultField;
    protected double protectedField;
    public boolean publicField;

    public AccessModifierDemo(int privateField, String defaultField, double protectedField, boolean publicField) {
        this.privateField = privateField;
        this.defaultField = defaultField;
        this.protectedField = protectedField;
        this.publicField = publicField;
    }

    private void privateMethod() {
        System.out.println("Private method called");
    }

    void defaultMethod() {
        System.out.println("Default method called");
    }

    protected void protectedMethod() {
        System.out.println("Protected method called");
    }

    public void publicMethod() {
        System.out.println("Public method called");
    }

    public void testInternalAccess() {
        System.out.println("--- Internal Access ---");
        System.out.println("Private field: " + privateField);
        System.out.println("Default field: " + defaultField);
        System.out.println("Protected field: " + protectedField);
        System.out.println("Public field: " + publicField);

        privateMethod();
        defaultMethod();
        protectedMethod();
        publicMethod();
    }

    public static void main(String[] args) {
        AccessModifierDemo demo = new AccessModifierDemo(10, "Hello", 99.9, true);

        // System.out.println(demo.privateField); // error if uncommented
        System.out.println(demo.defaultField);
        System.out.println(demo.protectedField);
        System.out.println(demo.publicField);

        // demo.privateMethod(); // error if uncommented
        demo.defaultMethod();
        demo.protectedMethod();
        demo.publicMethod();

        demo.testInternalAccess();
    }
}

class SamePackageTest {
    public static void testAccess() {
        AccessModifierDemo demo = new AccessModifierDemo(20, "World", 123.45, false);

        // System.out.println(demo.privateField); // error if uncommented
        System.out.println(demo.defaultField);
        System.out.println(demo.protectedField);
        System.out.println(demo.publicField);

        // demo.privateMethod(); // error if uncommented
        demo.defaultMethod();
        demo.protectedMethod();
        demo.publicMethod();
    }
}

