import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFinder {
    public static void main(String[] args) throws IOException {
        String filePath = args[0];
        String word = args[1];

        System.out.println(secondTask(filePath, word));
    }

    public static String secondTask(String filePath, String word) throws IOException {
        List<String> lines = stringList(filePath);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).contains(word + " ")) {
                Integer count = numberOfWordsInStringLine(lines.get(i), word);
                stringBuilder.append("Line ").append((i + 1) + ": ").append(count).append(" found \n");
            }
        }
        return stringBuilder.toString();
    }

    public static List<String> stringList(String pathName) throws IOException {

        List<String> lines = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader(new File(pathName)));
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }

    public static Integer numberOfWordsInStringLine(String line, String word) {
        String rez[] = line.split(" ");
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < rez.length; i++) {
            Integer integer = map.get(rez[i]);
            if (integer == null) {
                integer = 0;
            }
            integer++;
            map.put(rez[i], integer);
        }
        return map.get(word);
    }

}
