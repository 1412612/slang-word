package function;


import app.Constant;
import dictinary.Dictionary;
import io.IOFile;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class FunctionTwo extends AppFunction{
    private Scanner scanner;
    private Dictionary dictionary;
    private IOFile ioFile;

    public FunctionTwo(){};

    public FunctionTwo(Scanner scanner, Dictionary dictionary, IOFile ioFile){
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
                        "Chức năng 2: Tìm kiếm theo definition.\n" +
                        "===========================================\n" +
                        "Mời bạn nhập definition (nhấn phím 0 để quay lại menu):\n"
        );
    }

    public void function(){
        while (true){
            menu();
            String line = scanner.nextLine();
            if(line.equals("0")){
                break;
            }
            List<String> slangWords = dictionary.getDefinitionDictionary().get(line.toLowerCase(Locale.ROOT));

            if(slangWords==null){
                System.out.println(Constant.Color.ANSI_YELLOW + "Không có slang word nào phù hợp với definition \""+  line +"\""+ Constant.Color.ANSI_RESET);
            }else{
                System.out.println(Constant.Color.ANSI_GREEN + "Các slang word phù hợp với definition \""+ line + "\":\n"+ slangWords.toString().substring(1, slangWords.toString().length()-1) + Constant.Color.ANSI_RESET);
            }

        }
    }
}
