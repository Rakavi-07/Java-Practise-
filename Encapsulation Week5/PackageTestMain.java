package com.company.main;

import com.company.security.AccessModifierDemo;

public class PackageTestMain {
    public static void main(String[] args) {
        AccessModifierDemo demo = new AccessModifierDemo(1, "MainPkg", 2.5, true);

        System.out.println(demo.publicField);
        demo.publicMethod();
        demo.testInternalAccess();
    }
}
