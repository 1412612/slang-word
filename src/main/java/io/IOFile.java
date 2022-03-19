package io;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class IOFile {
    public void readFileFirstTime() {
        HashMap<String, List<String>> slangDictionary = new HashMap<>();
        HashMap<String, List<String>> definitionDictionary = new HashMap<>();
        File file = new File("src/main/resources/root-slang.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String line = reader.readLine();
            if(line!=null){
                line = reader.readLine();
                //int i =1;
                while (line != null) {
                    //i++;
                    if(!line.contains("`")) {
                        //System.out.println(i + " " + line);
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

        writeFile("src/main/resources/slang-dictionary.txt", slangDictionary);
        writeFile("src/main/resources/definition-dictionary.txt", definitionDictionary);
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

    public HashMap<String, List<String>> getSlangDictionary(){
        String url = "src/main/resources/slang-dictionary.txt";
        File file = new File(url);

        if (!file.exists()) {
            readFileFirstTime();
        }

        return readDictionary(url);
    }

    public HashMap<String, List<String>> getDefinitionDictionary(){
        String url = "src/main/resources/definition-dictionary.txt";
        File file = new File(url);

        if (!file.exists()) {
            readFileFirstTime();
        }

        return readDictionary(url);
    }

    public void writeFile(String url, Map<String, List<String>> dictionary){
        try {
            FileWriter fw = new FileWriter(url);

            Set<String> keySet = dictionary.keySet();
            for (String key : keySet) {

                String line = key +"`";

                List<String> values = dictionary.get(key);

                for(int i=0;i<values.size()-1;i++){
                    line+=values.get(i) + "|";
                }
                line += values.get(values.size()-1);
                fw.write(line+"\n");
            }

            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public HashMap<String, List<String>> readDictionary(String url) {
        HashMap<String, List<String>> dictionary = new HashMap<>();
        File file = new File(url);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String line = reader.readLine();
            if(line!=null){
                line = reader.readLine();
                while (line != null) {
                    if(!line.contains("`")) {
                        line = reader.readLine();
                        continue;
                    }

                    String[] wordLine = line.split("`");
                    String[] definitions = wordLine[1].trim().split("\\|");

                    List<String> listDefinitions = Arrays.asList(definitions)
                            .stream()
                            .map(definition -> definition.trim())
                            .collect(Collectors.toList());

                    dictionary.put(wordLine[0], listDefinitions);

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
