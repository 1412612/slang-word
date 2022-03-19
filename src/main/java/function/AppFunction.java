package function;

import app.Constant;
import dictinary.Dictionary;

import java.util.Scanner;

public abstract class AppFunction {
    public abstract void run();
    public abstract void function();
    public abstract void menu();
    public boolean checkBack(String line){
        if(line.equals("0")) return true;
        return false;
    }
    public void printSuccess(String line){
        System.out.println(Constant.Color.ANSI_GREEN + line + Constant.Color.ANSI_RESET);
    }

    public void printError(String line){
        System.out.println(Constant.Color.ANSI_RED+ line + Constant.Color.ANSI_RESET);
    }

    public void printWarning(String line){
        System.out.println(Constant.Color.ANSI_YELLOW + line + Constant.Color.ANSI_RESET);
    }

    public void printInfo(String line){
        System.out.println(Constant.Color.ANSI_RESET + line + Constant.Color.ANSI_RESET);
    }

    public void printHighlight(String line){
        System.out.println(Constant.Color.ANSI_BLUE + line + Constant.Color.ANSI_RESET);
    }
}
