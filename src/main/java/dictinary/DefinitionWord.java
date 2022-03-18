package dictinary;

import java.util.List;

public class DefinitionWord implements Comparable<DefinitionWord>{
    private String definition;
    private List<String> slang;

    public DefinitionWord(){}

    public DefinitionWord(String definition, List<String> slang) {
        this.definition = definition;
        this.slang = slang;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public List<String> getSlang() {
        return slang;
    }

    public void setSlang(List<String> slang) {
        this.slang = slang;
    }

    @Override
    public int compareTo(DefinitionWord definitionWord) {
        return definition.compareTo(definitionWord.getDefinition());
    }
}
