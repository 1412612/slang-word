package app;

import dictinary.Dictionary;

import java.util.List;
import java.util.Scanner;

public class SlangWordApp {
    private Dictionary dictionary;
    private Scanner scanner;

    public SlangWordApp(){
        dictionary = new Dictionary();
        dictionary.loadDictionary();

        this.scanner = new Scanner(System.in);
    }

    public void run(){
        while (true){
            menu();
            int intScanner = Integer.parseInt(scanner.nextLine());

            switch (intScanner){
                case 1: functionOne();
            }
        }

    }


    public void menu(){
        System.out.println("SLANG WORD\n" +
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
        System.out.println(
                "Chức năng không được hỗ trợ vui lòng nhập lkại!"
        );
    }

    public void menuFunctionOne(){
        System.out.println(
                "               SLANG WORD\n" +
                        "===========================================\n" +
                        "Chức năng 1: Tìm kiếm theo slang word.\n" +
                        "===========================================\n" +
                        "Mời bạn nhập slang word (nhấn phím 0 để quay lại menu):\n"
        );
    }

    public void functionOne(){
        while (true){
            menuFunctionOne();
            String line = scanner.nextLine();
            if(line.equals("0")){
                break;
            }
            List<String> definition = dictionary.getSlangDictionary().get(line);

            if(definition==null){
                System.out.println("Không có slang word "+  line + "trong từ điển!");
            }else{
                System.out.println("Slang word: "+ line + "  "+ definition);
            }

            System.out.println("1: Tiếp tục tìm kiếm slang word.\n" +
                    "0: Quay về menu.\n");
        line = scanner.nextLine();
            if(line.equals("0")){
                break;
            }
        }
    }
}
