package function;

import app.Constant;
import dictinary.Dictionary;
import io.IOFile;
import utils.AppUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class FunctionFive extends AppFunction{
    private Scanner scanner;
    private Dictionary dictionary;
    private IOFile ioFile;

    public FunctionFive(){};

    public FunctionFive(Scanner scanner, Dictionary dictionary, IOFile ioFile){
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
                        "Chức năng 5: Chỉnh sửa slang word(nhấn phím 0 để quay lại menu).\n" +
                        "===========================================\n" +
                        "Mời bạn nhập slang word muốn chỉnh sửa:"
        );
    }

    public void function(){
        menu();
        String slangWord = scanner.nextLine();
        if(checkBack(slangWord)) return;
        while (!dictionary.getSlangDictionary().containsKey(slangWord)){
            if(checkBack(slangWord)) return;
            printError("slang word không tồn tại vui lòng nhập lại: ");
            slangWord = scanner.nextLine();
        }
        printInfo("Slang word hiện tại:");
        printHighlight(slangWord + "  :  " + dictionary.getSlangDictionary().get(slangWord));
        printInfo("Mời bạn nhập slang word mới(Nhập 1 nếu giữ nguyên):");

        String newSlangWord = scanner.nextLine();
        if(checkBack(slangWord)) return;

        while (!newSlangWord.equals("1") && dictionary.getSlangDictionary().containsKey(newSlangWord)){
            if(checkBack(slangWord)) return;
            printError("Slang word đã tồn tại mời bạn nhập lại slang word mới(Nhập 1 nếu giữ nguyên):");
            newSlangWord = scanner.nextLine();
        }

        printInfo("Mời bạn nhập definition mới (Cách nhau bởi dấu \"|\". Nhập 1 nếu giữ nguyên):");

        String newDefinition = scanner.nextLine();
        if(checkBack(slangWord)) return;

        if(newSlangWord.equals("1") && newDefinition.equals("1")){
            printError("Không có sự thay đổi!");
            printInfo("Bấm phím bất kỳ để quay lại menu.");
            scanner.nextLine();
            return;
        }

        updateNewSlangWordToDictionary(slangWord,
                dictionary.getSlangDictionary().get(slangWord),
                newSlangWord.equals("1") ? slangWord : newSlangWord,
                newDefinition.equals("1") ? String.join( "|", dictionary.getSlangDictionary().get(slangWord)): newDefinition);

        printSuccess("Cập nhật thành công!");

        printInfo("Bấm phím bất kỳ để quay lại menu.");

        scanner.nextLine();
    }

    private void updateNewSlangWordToDictionary(String oldSlang, List<String> oldDefinitions, String newSlang, String newDefinition){
        AppUtils.deleteDefinitionDictionary(oldSlang, oldDefinitions, dictionary);

        List<String> newDefinitions = Arrays.asList(newDefinition.split("\\|"));
        AppUtils.addDefinitionDictionary(newSlang, newDefinitions, dictionary);
    }
}
