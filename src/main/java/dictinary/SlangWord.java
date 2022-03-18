package dictinary;

import java.util.List;

public class SlangWord implements Comparable<SlangWord>{
    private String slang;
    private List<String> definitions;

    public SlangWord(){}

    public SlangWord(String slang, List<String> definitions) {
        this.slang = slang;
        this.definitions = definitions;
    }

    public String getSlang() {
        return slang;
    }

    public void setSlang(String slang) {
        this.slang = slang;
    }

    public List<String> getDefinition() {
        return definitions;
    }

    public void setDefinition(List<String> definitions) {
        this.definitions = definitions;
    }


    @Override
    public int compareTo(SlangWord slangWord) {
        return slang.compareTo(slangWord.getSlang());
    }
}