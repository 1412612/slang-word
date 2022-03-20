package function;

import app.Constant;
import dictinary.Dictionary;
import io.IOFile;
import utils.AppUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class FunctionSix extends AppFunction{
    private Scanner scanner;
    private Dictionary dictionary;
    private IOFile ioFile;

    public FunctionSix(){};

    public FunctionSix(Scanner scanner, Dictionary dictionary, IOFile ioFile){
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
                        "Chức năng 6: Xóa slang word(nhấn phím 0 để quay lại menu).\n" +
                        "===========================================\n" +
                        "Mời bạn nhập slang word muốn xóa:"
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
        printWarning("Bạn có chắc chắn muốn xóa slang word " + slangWord + " bấm phím 1 để xác nhận (bấm phím bất kỳ để bỏ qua):");

        String confirm = scanner.nextLine();
        if(confirm.equals("1")){
            AppUtils.deleteDefinitionDictionary(slangWord, dictionary.getSlangDictionary().get(slangWord), dictionary);
            printSuccess("Đã xóa thành công!");
            printInfo("Bấm phím bất kỳ để quay trở lại menu.");
            scanner.nextLine();
        }
    }
}
