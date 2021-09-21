package com.example;

import java.io.File;
import java.util.Optional;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws LifecycleException
    {
        File appDir = new File("src/main/webapp");

        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir("temp");
        String port = Optional.ofNullable(System.getenv("PORT")).orElse("8080");
        

        tomcat.setPort(Integer.parseInt(port));
        tomcat.getConnector();

        tomcat.addWebapp("/", appDir.getAbsolutePath());
        tomcat.start();
        tomcat.getServer().await();
    }
}
