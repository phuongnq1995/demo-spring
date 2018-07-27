package com.spring.mvc.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class DemoAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before(value="execution(* com.spring.mvc.service.CustomerService.create(Object))")
    public void before(JoinPoint joinPoint) {
        //Advice
        logger.info(" Check for user access ");
        
        logger.info(" Allowed execution for {}", joinPoint);
        logger.info(Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(value = "execution(* com.spring.mvc.service.CustomerService.findAll())",
        returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info("{} returned with value {}", joinPoint, result);
    }

}
