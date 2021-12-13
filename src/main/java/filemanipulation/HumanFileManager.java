package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {

    private List<Human> humans = new ArrayList<>();

    public List<Human> getHumans() {
        return humans;
    }

    public void readHumansFromFile(Path path){
        try {
            List<String> humanFromFile = Files.readAllLines(path);
            for (String s : humanFromFile){
                String[] lines = s.split(";");
                humans.add(new Human(lines[0], lines[1]));
            }
        } catch (IOException ioe){
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    public void writeMaleHumansToFile(Path path){
        List<String> maleHumans = new ArrayList<>();

        for (Human human : humans){
            if (human.getIdentityNumber().charAt(0) == '1' || human.getIdentityNumber().charAt(0) == '3'){
                maleHumans.add(human.getName() + ";" + human.getIdentityNumber());
            }
        }

        try {
            Files.write(path, maleHumans);
        } catch (IOException ioe){
            throw new IllegalStateException("Can't write file!", ioe);
        }
    }
}
