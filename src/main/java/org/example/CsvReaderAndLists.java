package org.example;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;

@Component
public class CsvReaderAndLists {
    private int numberOfExercise;
    private String answer;
    private HashMap<Integer, String> rightAnswers = new HashMap<>();
    private HashMap<Integer, String> studentAnswers = new HashMap<>();
    private String path1 = "C:\\Users\\Roman\\Desktop\\Key.csv";
    private String path2 = "C:\\Users\\Roman\\Desktop\\Student.csv";

    public void setRightAnswers(HashMap<Integer, String> rightAnswers) {
        this.rightAnswers = rightAnswers;
    }

    public void setStudentAnswers(HashMap<Integer, String> studentAnswers) {
        this.studentAnswers = studentAnswers;
    }

    public HashMap<Integer, String> getRightAnswers() {
        return rightAnswers;
    }

    public HashMap<Integer, String> getStudentAnswers() {
        return studentAnswers;
    }

    void read() {
        char separator = ';';
        CSVParser parser = new CSVParserBuilder().withSeparator(separator).build();
        try (CSVReader reader1 = new CSVReaderBuilder(new FileReader(path1))
                .withCSVParser(parser)
                .build();
             CSVReader reader2 = new CSVReaderBuilder(new FileReader(path2))
                .withCSVParser(parser)
                .build())
        {
            String[] header = reader1.readNext();//обычный массив для чтения заголовка, куда мы читаем данные из таблицы csv
            String[] header2 = reader2.readNext();//обычный массив для чтения заголовка, куда мы читаем данные из таблицы csv
            String [] row;
            while ((row = reader1.readNext()) != null) {
               numberOfExercise = Integer.parseInt(row[0]);
               answer = row[1];
            rightAnswers.put(numberOfExercise, answer);
            }
            while ((row = reader2.readNext()) != null) {
                numberOfExercise = Integer.parseInt(row[0]);
                answer = row[1];
                studentAnswers.put(numberOfExercise, answer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
