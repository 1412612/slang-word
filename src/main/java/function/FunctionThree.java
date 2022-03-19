package function;

import app.Constant;
import dictinary.Dictionary;
import io.IOFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

public class FunctionThree implements AppFunction{
    private Scanner scanner;
    private Dictionary dictionary;
    private IOFile ioFile;

    public FunctionThree(){};

    public FunctionThree(Scanner scanner, Dictionary dictionary, IOFile ioFile){
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
                        "Chức năng 3: Lịch sử tìm kiếm slang word.\n" +
                        "===========================================\n" +
                        "Lịch sử bạn đã tìm kiếm:"
        );
    }

    public void function(){
        menu();
        File file = ioFile.openHistory();

        if(!file.exists()){
            System.out.println(Constant.Color.ANSI_YELLOW + "Lịch sử trống!" + Constant.Color.ANSI_RESET);
        }
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(Constant.Color.ANSI_GREEN + line + Constant.Color.ANSI_RESET);
                line = reader.readLine();
            }
        }catch (Exception e){
            System.out.println("Lỗi khi đọc tệp lịch sử!");
        }

        System.out.println("Bấm phím bất kỳ để quay lại menu: ");
        scanner.nextLine();

    }
}
