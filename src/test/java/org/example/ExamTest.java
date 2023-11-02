package org.example;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("application.properties")
public class ExamTest
{
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExamConfigure.class);
    CsvReaderAndLists csvReaderAndLists = applicationContext.getBean(CsvReaderAndLists.class);
    HashMap<Integer, String> hashMap1 = new HashMap<>();
    HashMap<Integer, String> hashMap2 = new HashMap<>();

    int i = 1;
    @Before
    public void testBefore() {
        csvReaderAndLists.setRightAnswers(hashMap1);
        csvReaderAndLists.setStudentAnswers(hashMap2);
    }
    @Test
    public void resultProcessor () {
        for (i =1; i<=10; i++) {//подсчет всех правильных значений
            csvReaderAndLists.getRightAnswers().put(i, "A");
            csvReaderAndLists.getStudentAnswers().put(i, "A");
        }
        System.out.println(csvReaderAndLists.getStudentAnswers());
        System.out.println(csvReaderAndLists.getRightAnswers());
        ResultProcessor resultProcessor = applicationContext.getBean(ResultProcessor.class);
        resultProcessor.resultCalculation();
        resultProcessor.systemOut();
        assertEquals(18, resultProcessor.getResult());
    }


}
