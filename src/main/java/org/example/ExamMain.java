package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExamMain
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExamConfigure.class);
        CsvReaderAndLists csvReaderAndLists = applicationContext.getBean(CsvReaderAndLists.class);
        ResultProcessor resultProcessor =applicationContext.getBean(ResultProcessor.class);
        csvReaderAndLists.read();
        resultProcessor.resultCalculation();
        resultProcessor.systemOut();
        System.out.println();
    }
}
