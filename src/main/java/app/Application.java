package app;

import io.IOFile;

import java.io.FileNotFoundException;

public class Application {

    public static void menu(){
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

    public static void main(String[] args) throws FileNotFoundException {


        IOFile ioFile = new IOFile();
        ioFile.read("");

        menu();

    }
}
