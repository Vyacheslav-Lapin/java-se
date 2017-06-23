package com.luxoft.training.javase.bankapp.jmx;

import lombok.SneakyThrows;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class SimpleAgent {

    private MBeanServer mbs;

    public SimpleAgent() {

        // Get the platform MBeanServer
        mbs = ManagementFactory
                .getPlatformMBeanServer();

        // Unique identification of MBeans
        Hello helloBean = new Hello();
        ObjectName helloName;

        try {
            // Uniquely identify the MBeans and register them with the platform MBeanServer
            helloName = new ObjectName("FOO:name=HelloBean");
            mbs.registerMBean(helloBean, helloName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Utility method: so that the application continues to run
    @SneakyThrows
    private static void waitForEnterPressed() {
        System.out.println("Press  to continue...");
        System.in.read();
    }

    public static void main(String argv[]) {
        SimpleAgent agent = new SimpleAgent();
        System.out.println("SimpleAgent is running...");
        SimpleAgent.waitForEnterPressed();
    }
}
