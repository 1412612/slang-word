package utils;

import dictinary.Dictionary;

import java.util.*;

public class AppUtils {
    public void updateDefinitionDictionary(String slangWord, List<String> listDefinitions, Dictionary dictionary){
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
