package io;

import dictinary.SlangWord;

import java.io.*;
import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class IOFile {
    public SortedSet<SlangWord> read(String url) throws FileNotFoundException {
        SortedSet<SlangWord> dictionary = new TreeSet();
        url = "/home/thanhnv/Desktop/slang-word/src/main/resources/root-lang.txt";
        File file = new File(url);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int i=0;
        try {
            String line = reader.readLine();
            if(line!=null){
                line = reader.readLine();

                while (line != null) {
                    i++;
                    //System.out.println(line);
                    if(!line.contains("`")) {
                        line = reader.readLine();
                        continue;
                    }
                    String[] wordLine = line.split("`");
                    SlangWord slangWord = new SlangWord();
                    slangWord.setSlang(wordLine[0]);

                    String[] definitions = wordLine[1].trim().split("\\|");

                    slangWord.setDefinition(Arrays.asList(definitions)
                            .stream()
                            .map(definition -> definition.trim())
                            .collect(Collectors.toList()));

                    dictionary.add(slangWord);

                    line = reader.readLine();
                }
            }

        } catch (Exception ex) {
            System.out.println("Lỗi trong qua trình đọc file!");
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                System.out.println("không thể đóng file!");
            }
        }

        return dictionary;
    }
}
