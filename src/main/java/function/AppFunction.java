package function;

import app.Constant;
import dictinary.Dictionary;

import java.util.List;
import java.util.Scanner;

public abstract class AppFunction {
    public abstract void run();
    public abstract void function();
    public abstract void menu();
    public boolean checkBack(String line){
        if(line.equals("0")) return true;
        return false;
    }
    public static void printSuccess(String line){
        System.out.println(Constant.Color.ANSI_GREEN + line + Constant.Color.ANSI_RESET);
    }

    public static void printError(String line){
        System.out.println(Constant.Color.ANSI_RED+ line + Constant.Color.ANSI_RESET);
    }

    public static void printWarning(String line){
        System.out.println(Constant.Color.ANSI_YELLOW + line + Constant.Color.ANSI_RESET);
    }

    public static void printInfo(String line){
        System.out.println(Constant.Color.ANSI_RESET + line + Constant.Color.ANSI_RESET);
    }

    public static void printHighlight(String line){
        System.out.println(Constant.Color.ANSI_BLUE + line + Constant.Color.ANSI_RESET);
    }

    public static String listToString(List<String> list){
        return list.toString().substring(1, list.toString().length()-1);
    }
}
