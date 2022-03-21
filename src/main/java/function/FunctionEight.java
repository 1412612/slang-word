package function;

import dictinary.Dictionary;
import io.IOFile;

import java.util.*;

public class FunctionEight extends AppFunction {
    private Scanner scanner;
    private Dictionary dictionary;
    private IOFile ioFile;

    public FunctionEight() {
    }

    public FunctionEight(Scanner scanner, Dictionary dictionary, IOFile ioFile) {
        this.scanner = scanner;
        this.dictionary = dictionary;
        this.ioFile = ioFile;

    }

    @Override
    public void run() {
        function();
    }

    public void menu() {
        System.out.println(
                "               SLANG WORD\n" +
                        "===========================================\n" +
                        "Chức năng 8: Slang word ngẫu nhiên (bấm phím 0 để quay lại menu).\n"
        );
    }

    public void function() {
        menu();
        String randomKey = dictionary.getRandomKey(dictionary.getSlangDictionary());
        printInfo("Slang word ngẫu nhiên:");
        printHighlight(randomKey + "  :  " + listToString(dictionary.getSlangDictionary().get(randomKey)));
        printInfo("Bấm phím bất kỳ để quay về menu.");
        scanner.nextLine();
    }
}
