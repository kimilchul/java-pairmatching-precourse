package pairmatching;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CrewRepository {

    public List<String> getCrews(String course) {
        List<String> crews = new LinkedList<>();
        try (BufferedReader objReader = new BufferedReader(new FileReader("src/main/resources/" + course))) {
            String currentLine;
            while ((currentLine = objReader.readLine()) != null) {
                crews.add(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return crews;
    }
}
