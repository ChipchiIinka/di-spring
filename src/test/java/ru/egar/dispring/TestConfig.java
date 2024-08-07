package ru.egar.dispring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.egar.dispring.di.InjectRandomIntAnnotationProcessor;
import ru.egar.dispring.di.aspect.BenchmarkAspect;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "ru.egar.dispring")
public class TestConfig {

    @Bean
    public InjectRandomIntAnnotationProcessor injectRandomIntAnnotationProcessor() {
        return new InjectRandomIntAnnotationProcessor();
    }

    @Bean
    public BenchmarkAspect benchmarkAspect() {
        return new BenchmarkAspect();
    }
}
