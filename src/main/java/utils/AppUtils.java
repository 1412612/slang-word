package utils;

import dictinary.Dictionary;

import java.util.*;

public class AppUtils {
    public static void addDefinitionDictionary(String slangWord, List<String> listDefinitions, Dictionary dictionary){
        dictionary.getSlangDictionary().put(slangWord, listDefinitions);
        Set<String> indexs = new HashSet<>();
        for(String item : listDefinitions){
            indexs.addAll(indexDefinition(item));
        }

        Iterator<String> iterator = indexs.iterator();
        while (iterator.hasNext()) {
            String index  = iterator.next();
            List<String> values = new ArrayList<>();
            if(dictionary.getDefinitionDictionary().containsKey(index)){
                values = dictionary.getDefinitionDictionary().get(index);
            }
            values.add(slangWord);
            dictionary.getDefinitionDictionary().put(index, values);
        }

    }

    public static void deleteDefinitionDictionary(String slangWord, List<String> listDefinitions, Dictionary dictionary){
        dictionary.getSlangDictionary().remove(slangWord);
        Set<String> indexs = new HashSet<>();
        for(String item : listDefinitions){
            indexs.addAll(indexDefinition(item));
        }

        Iterator<String> iterator = indexs.iterator();
        while (iterator.hasNext()) {
            String index  = iterator.next();
            List<String> values = new ArrayList<>();
            if(dictionary.getDefinitionDictionary().containsKey(index)){
                values = dictionary.getDefinitionDictionary().get(index);
            }

            if(values.size()==1) dictionary.getDefinitionDictionary().remove(index);
            else{
                values.remove(slangWord);
                dictionary.getDefinitionDictionary().put(index, values);
            }
        }

    }

    public static Set<String> indexDefinition(String definition){
        Set<String> indexs = new HashSet<>();
        for(int i=0;i<definition.length();i++){
            for(int j=i+1; j<=definition.length();j++){
                indexs.add(definition.substring(i, j));
            }
        }
        return indexs;
    }
}
