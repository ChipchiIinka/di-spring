package ru.egar.dispring.di.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class BenchmarkAspect {
    @Around("@annotation(ru.egar.dispring.di.annotation.Benchmark)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("[[BENCHMARKED METHOD: {}", joinPoint.getSignature().getName());
        long start = System.nanoTime();
        Object result = joinPoint.proceed();
        long end = System.nanoTime();
        log.info("Execution time: {}]]]", end - start);
        return result;
    }
}
