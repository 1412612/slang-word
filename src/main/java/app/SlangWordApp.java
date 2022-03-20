package app;

import dictinary.Dictionary;
import function.*;
import io.IOFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SlangWordApp {
    private Dictionary dictionary;
    private Scanner scanner;
    private List<AppFunction> functions;
    private IOFile ioFile;

    public SlangWordApp(){
        this.dictionary = new Dictionary();
        this.dictionary.loadDictionary();
        this.scanner = new Scanner(System.in);
        functions = new ArrayList<>();
        this.ioFile = new IOFile();
        functions.add(new FunctionOne(scanner, dictionary, ioFile));
        functions.add(new FunctionTwo(scanner, dictionary));
        functions.add(new FunctionThree(scanner, dictionary, ioFile));
        functions.add(new FunctionFour(scanner, dictionary, ioFile));
        functions.add(new FunctionFive(scanner, dictionary, ioFile));
        functions.add(new FunctionSix(scanner, dictionary, ioFile));
        functions.add(new FunctionSeven(scanner, dictionary, ioFile));
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
                case 2: functions.get(1).run();
                        break;
                case 3: functions.get(2).run();
                        break;
                case 4: functions.get(3).run();
                    break;
                case 5: functions.get(4).run();
                    break;
                case 6: functions.get(5).run();
                    break;
                case 7: functions.get(6).run();
                    break;
                default: errorMenu();
            }
        }

    }


    public void menu(){
        System.out.println("\n                 SLANG WORD\n" +
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
