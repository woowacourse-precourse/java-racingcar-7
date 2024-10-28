package view;

import camp.nextstep.edu.missionutils.Console;
import util.Constants;

public class InputView {
    public static String[] inputWindow(){
        return new String[]{inputString(Constants.NOTICE_INPUT_CAR_NAME), inputString(Constants.NOTICE_INPUT_TRY_COUNT)};
    }

    private static String inputString(String prompt) {
        System.out.println(prompt);
        return Console.readLine();
    }
}
