package function;

import app.Constant;
import dictinary.Dictionary;

import java.util.List;
import java.util.Scanner;

public class FunctionOne implements AppFunction{
    private Scanner scanner;
    private Dictionary dictionary;

    public FunctionOne(){};

    public FunctionOne(Scanner scanner, Dictionary dictionary){
        this.scanner = scanner;
        this.dictionary = dictionary;
    }
    @Override
    public void run() {
        function();
    }

    public void menu(){
        System.out.println(
                "               SLANG WORD\n" +
                        "===========================================\n" +
                        "Chức năng 1: Tìm kiếm theo slang word.\n" +
                        "===========================================\n" +
                        "Mời bạn nhập slang word (nhấn phím 0 để quay lại menu):\n"
        );
    }

    public void function(){
        while (true){
            menu();
            String line = scanner.nextLine();
            if(line.equals("0")){
                break;
            }
            List<String> definition = dictionary.getSlangDictionary().get(line);

            if(definition==null){
                System.out.println(Constant.Color.ANSI_YELLOW + "Không có slang word "+  line + " trong từ điển!" + Constant.Color.ANSI_RESET);
            }else{
                System.out.println(Constant.Color.ANSI_GREEN + "Slang word: "+ line + "  "+ definition + Constant.Color.ANSI_RESET);
            }

//            System.out.println("1: Tiếp tục tìm kiếm slang word.\n" +
//                    "0: Quay về menu.\n");
//            line = scanner.nextLine();
//            if(line.equals("0")){
//                break;
//            }
        }
    }
}
