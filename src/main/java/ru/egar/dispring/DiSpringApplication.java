package ru.egar.dispring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.egar.dispring.model.RobotClerk;

@ComponentScan
@EnableAspectJAutoProxy
public class DiSpringApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DiSpringApplication.class);
        RobotClerk robot = context.getBean(RobotClerk .class);
        robot.doWork();
    }
}
