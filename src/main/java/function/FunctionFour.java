package function;

import app.Constant;
import dictinary.Dictionary;
import io.IOFile;
import utils.AppUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class FunctionFour extends AppFunction{
    private Scanner scanner;
    private Dictionary dictionary;
    private IOFile ioFile;

    public FunctionFour(){};

    public FunctionFour(Scanner scanner, Dictionary dictionary, IOFile ioFile){
        this.scanner = scanner;
        this.dictionary = dictionary;
        this.ioFile = ioFile;

    }
    @Override
    public void run() {
        function();
    }

    public void menu(){
        System.out.println(
                "               SLANG WORD\n" +
                        "===========================================\n" +
                        "Chức năng 4: Thêm một slang word mới(nhấn phím 0 để quay lại menu).\n" +
                        "===========================================\n" +
                        "Mời bạn nhập slang word mới:"
        );
    }

    public void function(){
        menu();
        String newSlangWord = scanner.nextLine();
        if(checkBack(newSlangWord)) return;
        while (dictionary.getSlangDictionary().containsKey(newSlangWord)){
            if(checkBack(newSlangWord)) return;
            printError("slang word đã có tồn tại vui lòng nhập lại: ");
            newSlangWord = scanner.nextLine();
        }
        printInfo("Mời bạn nhập definition cho slang word "+ newSlangWord+" (các định nghĩa cách nhau bằng dấu \"|\") ");
        String newDefinition = scanner.nextLine();

        if(checkBack(newSlangWord)) return;

        addNewSlangWordToDictionary(newSlangWord, newDefinition);

        printSuccess("Thêm slang word thành công!");
        printHighlight(newSlangWord + "  :  " + Arrays.asList(newDefinition).toString().substring(1, Arrays.asList(newDefinition).toString().length()-1));
        printInfo("Nhập phím bất kỳ để trở về menu");
        scanner.nextLine();

        }

    private void addNewSlangWordToDictionary(String slang, String definition){
        List<String> definitions = Arrays.asList(definition.split("\\|"));
       AppUtils.addDefinitionDictionary(slang, definitions, dictionary);
    }
}
