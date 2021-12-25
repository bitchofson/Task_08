package com.metanit;


import javax.swing.*;
import java.io.PrintStream;

public class Main {

    public static class InputArgs {
        public String inputFile;
        public String outputFile;
        public boolean error;
        public boolean help;
        public boolean window;
    } // Аргументы, которые разбираются при запуске

    public static InputArgs parseArgs(String[] args) {
        InputArgs params = new InputArgs();

        if (args.length > 0) {
            if (args[0].equals("--help")) {
                params.help = true;
                return params;
            }
            if (args[0].equals("--window")) {
                params.window = true;
                return params;
            }
            if (args.length < 2) {
                params.help = true;
                params.error = true;
                return params;
            }
            params.inputFile = args[0];
            if (args.length > 1) {
                params.outputFile = args[1];
            }
        } else {
            params.help = true;
            params.error = true;
        }
        return params;
    }  // Функция парсинга аргументов

    public static void winMain() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WindowFrame();
            }
        });
    } // GUI

    public static void main(String[] args) throws RuntimeException {

        InputArgs params = parseArgs(args);

        if (params.help) {
            PrintStream out = params.error ?  System.err : System.out;
            out.println("Usage:");
            out.println("  <cmd> args <input-file> (<output-file>)");
            out.println("  <cmd> --help");
            out.println("  <cmd> --window  // show window");
            System.exit(params.error ? 1 : 0);
        }

        if (params.window) {
            winMain();
        } else {
            int row = 4;
            int col = 4;
            int inputDataArr[][] = new int[row][col];
            int outDataArr[][] = new int[row][col];

            inputDataArr    = DataFile.readFile(params.inputFile);
            Logic logic = new Logic(inputDataArr, row, col);
            outDataArr      =  logic.findingNeighbors();
            DataFile.writeToFile(outDataArr, params.outputFile);

        }



    }
}
