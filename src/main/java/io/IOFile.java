package io;

import dictinary.SlangWord;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class IOFile {
    public HashMap<String, List<String>> readFileFirstTime(String url) throws FileNotFoundException {
        HashMap<String, List<String>> slangDictionary = new HashMap<>();
        HashMap<String, List<String>> definitionDictionary = new HashMap<>();
        url = "/home/thanhnv/Desktop/DAN/slang-word/src/main/resources/root-slang.txt";
        File file = new File(url);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        try {
            String line = reader.readLine();
            if(line!=null){
                line = reader.readLine();
                int i =1;
                while (line != null) {
                    i++;
                    if(!line.contains("`")) {
                        System.out.println(i + " " + line);
                        line = reader.readLine();
                        continue;
                    }

                    String[] wordLine = line.split("`");
                    String[] definitions = wordLine[1].trim().split("\\|");

                    List<String> listDefinitions = Arrays.asList(definitions)
                            .stream()
                            .map(definition -> definition.trim())
                            .collect(Collectors.toList());

                    slangDictionary.put(wordLine[0], listDefinitions);

                    Set<String> indexs = new HashSet<>();
                    for(String item : listDefinitions){
                        indexs.addAll(indexDefinition(item));
                    }

                    Iterator<String> iterator = indexs.iterator();
                    while (iterator.hasNext()) {
                        String index  = iterator.next();
                        List<String> values = new ArrayList<>();
                        if(definitionDictionary.containsKey(index)){
                            values = definitionDictionary.get(index);
                        }
                        values.add(wordLine[0]);
                        definitionDictionary.put(index, values);
                    }

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

        return slangDictionary;
    }


    Set<String> indexDefinition(String definition){
        Set<String> indexs = new HashSet<>();
        for(int i=0;i<definition.length();i++){
            for(int j=i+1; j<=definition.length();j++){
                indexs.add(definition.substring(i, j));
            }
        }
        return indexs;
    }

}
