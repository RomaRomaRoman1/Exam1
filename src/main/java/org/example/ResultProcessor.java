package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ResultProcessor {
    CsvReaderAndLists csvReaderAndLists;
    @Value("${db.group1}")
    private int group1;
    @Value("${db.group2}")
    private int group2;
    @Value("${db.group3}")
    private int group3;
    private int result;
    public ResultProcessor(CsvReaderAndLists csvReaderAndLists) {
        this.csvReaderAndLists = csvReaderAndLists;
    }

    public int getResult() {
        return result;
    }

    void resultCalculation () {
        int i=0;
        for (i = 1; i<=10; i++) {
            if ((csvReaderAndLists.getRightAnswers().get(i)).equals(csvReaderAndLists.getStudentAnswers().get(i))) {
                if (i<= 4) {
                    result = result + group1;
                }
                else if (i>4 && i<=8) {
                    result = result + group2;
                } else if (i>8 && i <=10) {
                    result = result + group3;
                }
            }
    }
    }
    void systemOut () {
        System.out.println("Результат студента: " + result + " баллов");
    }

}
