package function;

import app.Constant;
import dictinary.Dictionary;
import io.IOFile;
import utils.AppUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class FunctionSeven extends AppFunction{
    private Scanner scanner;
    private Dictionary dictionary;
    private IOFile ioFile;

    public FunctionSeven(){};

    public FunctionSeven(Scanner scanner, Dictionary dictionary, IOFile ioFile){
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
                        "Chức năng 7: Reset về danh sách slang word gốc (Nhấn phím 1 để xác nhận! Nhấn phím bất kỳ để quay lại menu).\n"
        );
    }

    public void function(){
        menu();
        String key = scanner.nextLine();
        if(!key.equals("1")) return;
        ioFile.resetDictionary();
        dictionary.loadDictionary();
        printSuccess("Reset thành công!");
        printInfo(" Bấm phím bất kỳ để quay về menu.");
        scanner.nextLine();
    }
}
