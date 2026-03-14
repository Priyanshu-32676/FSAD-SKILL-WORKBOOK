package Workbook.Experiment_4;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        
    	 ClassPathXmlApplicationContext context =
         		new ClassPathXmlApplicationContext("ApplicationContext.xml");
    	 
//    	 Constructor Injection
    	 Student s = (Student)context.getBean("student1");
    	 System.out.println(s);
    	 System.out.println();
//    	 Setter Dependency Injection
    	 Student s1= (Student)context.getBean("student2");
    	 System.out.println(s1);
    }
}
