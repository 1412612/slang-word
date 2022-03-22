package io;

import utils.AppUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class IOFile {
    public static String URL_HISTORY = "src/main/resources/history.txt";
    public static String URL_SLANG_DICTIONARY = "src/main/resources/slang-dictionary.txt";
    public static String URL_DEFINITION_DICTIONARY = "src/main/resources/definition-dictionary.txt";
    public static String URL_ROOT = "src/main/resources/root-slang.txt";

    public void readFileFirstTime() {
        HashMap<String, List<String>> slangDictionary = new HashMap<>();
        HashMap<String, List<String>> definitionDictionary = new HashMap<>();
        File file = new File(URL_ROOT);
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
                        indexs.addAll(AppUtils.indexDefinition(item));
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

        writeDictionary(URL_SLANG_DICTIONARY, slangDictionary);
        writeDictionary(URL_DEFINITION_DICTIONARY, definitionDictionary);
    }


    public HashMap<String, List<String>> getSlangDictionary(){
        String url =URL_SLANG_DICTIONARY;
        File file = new File(url);

        if (!file.exists()) {
            readFileFirstTime();
        }

        return readDictionary(url);
    }

    public HashMap<String, List<String>> getDefinitionDictionary(){
        String url = URL_DEFINITION_DICTIONARY;
        File file = new File(url);

        if (!file.exists()) {
            readFileFirstTime();
        }

        return readDictionary(url);
    }

    public void writeDictionary(String url, Map<String, List<String>> dictionary){
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

    public void writeHistorySearchSlangWord(String slangWord){
        try{
        File file =new File(URL_HISTORY);
        if(!file.exists()){
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file,true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "  :  "+ slangWord+"\n");
        bw.close();
    }catch (Exception e){
            System.out.println("Lỗi khi cập nhật lịch sử!");
        }
    }

    public File openHistory(){
        File file = new File(URL_HISTORY);
        return file;
    }

    public void deleteFile(String url){
        try {
            File file = new File(url);
                file.delete();
        } catch (Exception e) {}
    }

    public void resetDictionary(){
        deleteFile(URL_DEFINITION_DICTIONARY);
        deleteFile(URL_SLANG_DICTIONARY);
        readFileFirstTime();
    }

    public void exitApp(Map<String, List<String>> slangDictionary, Map<String, List<String>> definitionDictionary){
        deleteFile(URL_DEFINITION_DICTIONARY);
        deleteFile(URL_SLANG_DICTIONARY);
        writeDictionary(URL_SLANG_DICTIONARY, slangDictionary);
        writeDictionary(URL_DEFINITION_DICTIONARY, definitionDictionary);
    }

}
