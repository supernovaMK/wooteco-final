package pairmatching.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrewFileReader {
    public List<String> readFile(String backendCrewSource) {
        List<String> crewNames= new ArrayList<>();
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader(backendCrewSource))) {
            String line;
            while((line=bufferedReader.readLine())!=null){
                crewNames.add(line);
            }

        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    return crewNames;
    }
}
