package dictinary;

import io.IOFile;

import java.util.HashMap;
import java.util.List;

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
}
