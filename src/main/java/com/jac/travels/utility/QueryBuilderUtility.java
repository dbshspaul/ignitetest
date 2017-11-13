package com.jac.travels.utility;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class QueryBuilderUtility {


    public void print() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        ctx.register(CassandraConfig.class);
        ctx.refresh();

        EmployeeRepository employeeRepository = ctx.getBean(EmployeeRepository.class);
        employeeRepository.findAll().stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        QueryBuilderUtility queryBuilderUtility = new QueryBuilderUtility();
        queryBuilderUtility.print();
    }
}
