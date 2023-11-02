package org.example;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ExamTest
{
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExamConfigure.class);
    CsvReaderAndLists csvReaderAndLists = applicationContext.getBean(CsvReaderAndLists.class);
    HashMap<Integer, String> hashMap1 = new HashMap<>();
    HashMap<Integer, String> hashMap2 = new HashMap<>();
    ResultProcessor resultProcessor = applicationContext.getBean(ResultProcessor.class);

    int i = 1;
    @Before
    public void testBefore() {
        csvReaderAndLists.setRightAnswers(hashMap1);
        csvReaderAndLists.setStudentAnswers(hashMap2);
    }
    @Test
    public void resultProcessorFromFiveToEight () {
        for (i =1; i<=10; i++) {//подсчет всех правильных значений
            if (i>4 && i<=8) {
                csvReaderAndLists.getRightAnswers().put(i, "A");
                csvReaderAndLists.getStudentAnswers().put(i, "A");
            }
            else {
                csvReaderAndLists.getRightAnswers().put(i, "C");
                csvReaderAndLists.getStudentAnswers().put(i, "B");
            }
        }
        resultProcessor.resultCalculation();
        assertEquals(8, resultProcessor.getResult());

    }
    @Test
    public void resultProcessorFromOneToFour() {
        for (i =1; i<=10; i++) {//подсчет всех правильных значений
            if (i>0 && i<5) {
                csvReaderAndLists.getRightAnswers().put(i, "A");
                csvReaderAndLists.getStudentAnswers().put(i, "A");
            }
            else {
                csvReaderAndLists.getRightAnswers().put(i, "C");
                csvReaderAndLists.getStudentAnswers().put(i, "B");
            }
        }
        resultProcessor.resultCalculation();
        assertEquals(4, resultProcessor.getResult());
    }
    @Test
    public void resultProcessorFromNineToTen () {
        for (i =1; i<=10; i++) {//подсчет всех правильных значений
            if (i>8 && i<=11) {
                csvReaderAndLists.getRightAnswers().put(i, "A");
                csvReaderAndLists.getStudentAnswers().put(i, "A");
            }
            else {
                csvReaderAndLists.getRightAnswers().put(i, "C");
                csvReaderAndLists.getStudentAnswers().put(i, "B");
            }
        }
        resultProcessor.resultCalculation();
        assertEquals(6, resultProcessor.getResult());
    }
    @Test
    public void resultProcessorAllValues () {
        for (i =1; i<=10; i++) {//подсчет всех правильных значений
                csvReaderAndLists.getRightAnswers().put(i, "A");
                csvReaderAndLists.getStudentAnswers().put(i, "A");

        }
        resultProcessor.resultCalculation();
        assertEquals(18, resultProcessor.getResult());
    }
}
