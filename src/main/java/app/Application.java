package app;

import io.IOFile;

import java.io.FileNotFoundException;

public class Application {
    public static void main(String[] args) throws FileNotFoundException {
        SlangWordApp app = new SlangWordApp();
        app.run();
    }
}
