package racingcar.views;

import camp.nextstep.edu.missionutils.Console;
import java.util.Scanner;

public class InputView {

    private static final String INPUT_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_PROMPT = "시도할 횟수는 몇 회인가요?";

    public static String readInput() {
        return Console.readLine();
    }

    public static void displayInputPrompt() {
        System.out.println(INPUT_PROMPT);
    }

    public static void displayTryCountPrompt() {
        System.out.println(TRY_COUNT_PROMPT);
    }
}
