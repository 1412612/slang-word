package function;

import app.Constant;
import dictinary.Dictionary;
import io.IOFile;

import java.util.*;
import java.util.stream.Collectors;

public class FunctionTen extends AppFunction {
    private Scanner scanner;
    private Dictionary dictionary;
    private IOFile ioFile;

    public FunctionTen() {
    }

    public FunctionTen(Scanner scanner, Dictionary dictionary, IOFile ioFile) {
        this.scanner = scanner;
        this.dictionary = dictionary;
        this.ioFile = ioFile;

    }

    @Override
    public void run() {
        function();
    }

    public void menu() {
        System.out.println(
                "               SLANG WORD\n" +
                        "===========================================\n" +
                        "Chức năng 10: Đố vui đoán slang word (bấm phím 0 để quay lại menu):\n"
        );
    }

    public void function() {
        String loop = "1";
        while (loop.equals("1")) {
            menu();
            List<String> randomKey = dictionary.getRandomNKey(dictionary.getSlangDictionary(), 4);
            List<String> result = new ArrayList<>();
            result.addAll(randomKey);
            Collections.shuffle(result);
            String definition = randomKey.stream().map(dictionary.getSlangDictionary()::get).map(lists -> lists.get(0)).collect(Collectors.toList()).get(0);
            printInfo("Chọn đáp án đúng với definition: " + Constant.Color.ANSI_BLUE + definition+ Constant.Color.ANSI_RESET);
            System.out.println(Constant.Color.ANSI_PURPLE + "A : " + result.get(0) + Constant.Color.ANSI_RESET);
            System.out.println(Constant.Color.ANSI_PURPLE + "B : " + result.get(1) + Constant.Color.ANSI_RESET);
            System.out.println(Constant.Color.ANSI_PURPLE + "C : " + result.get(2) + Constant.Color.ANSI_RESET);
            System.out.println(Constant.Color.ANSI_PURPLE + "D : " + result.get(3) + Constant.Color.ANSI_RESET);

            String pickStr = "";
            while (pickStr.equals("")) {
                String pick = scanner.nextLine();
                switch (pick.toLowerCase(Locale.ROOT)) {
                    case "a":
                        pickStr = result.get(0);
                        break;
                    case "b":
                        pickStr = result.get(1);
                        break;
                    case "c":
                        pickStr = result.get(2);
                        break;
                    case "d":
                        pickStr = result.get(3);
                        break;
                    case "0":
                        return;
                    default:
                        printError("Hãy chọn A B C hoặc D (bấm phím 0 để quay về menu). Chọn lại:");
                }
                if (pickStr.equals(randomKey.get(0))) {
                    printSuccess("Bạn đã trả lời đúng!");
                } else if (!pickStr.equals("")) {
                    printError("Bạn đã trải lời sai!");
                    printHighlight("Đáp án đúng là: " + randomKey.get(0));
                }
            }

            printInfo("1: Tiếp tục chơi.\n Thoát (phím bất kỳ)!");
            loop = scanner.nextLine();
        }
    }
}
