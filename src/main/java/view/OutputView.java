package view;

import camp.nextstep.edu.missionutils.Console;
import util.Constants;

public class OutputView {
    public static void outputWindow(String[] results){
        for(String result : results){
            printOutputString(result + "\n");
        }
    }

    private static void printOutputString(String prompt) {
        System.out.println(prompt);
    }
}
