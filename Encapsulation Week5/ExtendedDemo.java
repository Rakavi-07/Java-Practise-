package com.company.extended;

import com.company.security.AccessModifierDemo;

public class ExtendedDemo extends AccessModifierDemo {

    public ExtendedDemo(int privateField, String defaultField, double protectedField, boolean publicField) {
        super(privateField, defaultField, protectedField, publicField);
    }

    public void testInheritedAccess() {
        System.out.println(protectedField);
        System.out.println(publicField);
        protectedMethod();
        publicMethod();
    }

    @Override
    protected void protectedMethod() {
        System.out.println("Overridden protected method in ExtendedDemo");
    }

    public static void main(String[] args) {
        AccessModifierDemo parent = new AccessModifierDemo(10, "Parent", 5.5, true);
        ExtendedDemo child = new ExtendedDemo(20, "Child", 7.7, false);

        System.out.println("--- Testing parent object ---");
        System.out.println(parent.publicField);
        parent.publicMethod();

        System.out.println("--- Testing child object (subclass) ---");
        child.testInheritedAccess();
    }
}

