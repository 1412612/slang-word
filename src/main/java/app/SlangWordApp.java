package app;

import dictinary.Dictionary;
import function.AppFunction;
import function.FunctionOne;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SlangWordApp {
    private Dictionary dictionary;
    private Scanner scanner;
    private List<AppFunction> functions;

    public SlangWordApp(){
        this.dictionary = new Dictionary();
        this.dictionary.loadDictionary();
        this.scanner = new Scanner(System.in);
        functions = new ArrayList<>();
        functions.add(new FunctionOne(scanner, dictionary));
    }

    public void run(){
        while (true){
            menu();
            int intScanner = 0;
            try {
                intScanner = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                intScanner = -1;
            }


            switch (intScanner){
                case 1: functions.get(0).run();
                break;
                default: errorMenu();
            }
        }

    }


    public void menu(){
        System.out.println("                 SLANG WORD\n" +
                "===========================================\n" +
                "                   MENU\n" +
                "===========================================\n" +
                "               Chọn chức năng:\n" +
                "1: Tìm kiếm theo slang word.\n" +
                "2: Tìm kiếm theo definition. \n" +
                "3: Lịch sử các slang word đã tìm kiếm.\n" +
                "4: Thêm slang word.\n" +
                "5: Chỉnh sửa slang word.\n" +
                "6: Xóa một slang word.\n" +
                "7: Đặt lại slang word gốc.\n" +
                "8: Slang word ngẫu nhiên.\n" +
                "9: Đố vui đoán slang word. \n" +
                "10: Đố vui đoán definition.\n" +
                "0: Thoát chương trình.\n"
        );
    }

    public void errorMenu(){
        System.out.println( Constant.Color.ANSI_RED +
                "Chức năng không được hỗ trợ vui lòng nhập lại!"
                + Constant.Color.ANSI_RESET
        );
    }

}
