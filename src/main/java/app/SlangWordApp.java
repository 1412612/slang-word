package app;

import dictinary.Dictionary;
import function.*;
import io.IOFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static function.AppFunction.*;

public class SlangWordApp {
    private Dictionary dictionary;
    private Scanner scanner;
    private List<AppFunction> functions;
    private IOFile ioFile;

    public SlangWordApp() {
        this.dictionary = new Dictionary();
        this.dictionary.loadDictionary();
        this.scanner = new Scanner(System.in);
        functions = new ArrayList<>();
        this.ioFile = new IOFile();
        functions.add(new FunctionOne(scanner, dictionary, ioFile));
        functions.add(new FunctionTwo(scanner, dictionary, ioFile));
        functions.add(new FunctionThree(scanner, dictionary, ioFile));
        functions.add(new FunctionFour(scanner, dictionary, ioFile));
        functions.add(new FunctionFive(scanner, dictionary, ioFile));
        functions.add(new FunctionSix(scanner, dictionary, ioFile));
        functions.add(new FunctionSeven(scanner, dictionary, ioFile));
        functions.add(new FunctionEight(scanner, dictionary, ioFile));
        functions.add(new FunctionNine(scanner, dictionary, ioFile));
        functions.add(new FunctionTen(scanner, dictionary, ioFile));
    }

    public void run() {
        startApp();
        while (true) {
            menu();
            int intScanner = 0;
            try {
                intScanner = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                intScanner = -1;
            }


            switch (intScanner) {
                case 1:
                    functions.get(0).run();
                    break;
                case 2:
                    functions.get(1).run();
                    break;
                case 3:
                    functions.get(2).run();
                    break;
                case 4:
                    functions.get(3).run();
                    break;
                case 5:
                    functions.get(4).run();
                    break;
                case 6:
                    functions.get(5).run();
                    break;
                case 7:
                    functions.get(6).run();
                    break;
                case 8:
                    functions.get(7).run();
                    break;
                case 9:
                    functions.get(8).run();
                    break;
                case 10:
                    functions.get(9).run();
                    break;
                case 0:
                    menuExitApp();
                    String exit = scanner.nextLine();
                    if (exit.equals("1")) {
                        exitApp();
                        return;
                    }
                    break;
                default:
                    errorMenu();
            }
        }

    }


    public void menu() {
        System.out.println("\n                 SLANG WORD\n" +
                "===========================================\n" +
                "                   MENU\n" +
                "===========================================\n" +
                "               Ch???n ch???c n??ng:\n" +
                "1: T??m ki???m theo slang word.\n" +
                "2: T??m ki???m theo definition. \n" +
                "3: L???ch s??? c??c slang word ???? t??m ki???m.\n" +
                "4: Th??m slang word.\n" +
                "5: Ch???nh s???a slang word.\n" +
                "6: X??a m???t slang word.\n" +
                "7: ?????t l???i slang word g???c.\n" +
                "8: Slang word ng???u nhi??n.\n" +
                "9: ????? vui ??o??n slang word. \n" +
                "10: ????? vui ??o??n definition.\n" +
                "0: Tho??t ch????ng tr??nh.\n"
        );
    }

    public void errorMenu() {
        System.out.println(Constant.Color.ANSI_RED +
                "Ch???c n??ng kh??ng ???????c h??? tr??? vui l??ng nh???p l???i!"
                + Constant.Color.ANSI_RESET
        );
    }


    public void menuExitApp() {
        System.out.println(
                "B???n c?? mu???n tho??t ???ng d???ng:\n" +
                        "1: ?????ng ??!\n" +
                        "Ph??m b???t k???: Quay l???i!"
        );
    }

    public void exitApp() {
        ioFile.exitApp(dictionary.getSlangDictionary(), dictionary.getDefinitionDictionary());
        System.out.println("Ch????ng tr??nh k???t th??c!");
    }

    public void startApp() {
        System.out.println("M???i ng??y m???t slang word:");
        String line = "1";
        while (line.equals("1")) {
            String randomKey = dictionary.getRandomKey(dictionary.getSlangDictionary());
            printInfo("Slang word ng???u nhi??n:");
            printHighlight(randomKey + "  :  " + listToString(dictionary.getSlangDictionary().get(randomKey)));
            printInfo("1: Ti???p t???c h???c c??c slang word m???i.\n" +
                    "B???m ph??m b???t k??? ????? b???t ?????u menu!");
            line = scanner.nextLine();
        }
    }
}
