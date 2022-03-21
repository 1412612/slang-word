package dictinary;

import io.IOFile;

import java.util.*;
import java.util.stream.Collectors;

public class Dictionary {
    private HashMap<String, List<String>> slangDictionary;
    private HashMap<String, List<String>> definitionDictionary;
    private IOFile ioFile;

    public Dictionary(){
        this.ioFile = new IOFile();
    }

    public void loadDictionary(){
        slangDictionary = ioFile.getSlangDictionary();
        definitionDictionary = ioFile.getDefinitionDictionary();
    }

    public HashMap<String, List<String>> getSlangDictionary() {
        return slangDictionary;
    }

    public void setSlangDictionary(HashMap<String, List<String>> slangDictionary) {
        this.slangDictionary = slangDictionary;
    }

    public HashMap<String, List<String>> getDefinitionDictionary() {
        return definitionDictionary;
    }

    public void setDefinitionDictionary(HashMap<String, List<String>> definitionDictionary) {
        this.definitionDictionary = definitionDictionary;
    }

    public IOFile getIoFile() {
        return ioFile;
    }

    public void setIoFile(IOFile ioFile) {
        this.ioFile = ioFile;
    }

    public String getRandomKey(HashMap dictionary){
        Set<String> keySet = dictionary.keySet();
        List<String> keyList = new ArrayList<>(keySet);
        Collections.shuffle(keyList);
        Optional<String> randomKey = keyList.stream().findFirst();
        return randomKey.get();
    }

    public List<String> getRandomNKey(HashMap dictionary, int n){
        Set<String> keySet = dictionary.keySet();
        List<String> keyList = new ArrayList<>(keySet);
        Collections.shuffle(keyList);
        int i=0;
        Set<String> nKey = new HashSet<>();
        while (i++<n){
            nKey.add(keyList.get(i));
        }
        return new ArrayList<>(nKey);
    }
}
