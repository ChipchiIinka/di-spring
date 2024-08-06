package ru.egar.dispring.di.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BenchmarkAspect {
    @Around("@annotation(ru.egar.dispring.di.annotation.Benchmark)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.printf("[[BENCHMARKED METHOD: %s\n", joinPoint.getSignature().getName());
        long start = System.nanoTime();
        Object result = joinPoint.proceed();
        long end = System.nanoTime();
        System.out.printf("Execution time: %d]]]\n", end - start);
        return result;
    }
}
