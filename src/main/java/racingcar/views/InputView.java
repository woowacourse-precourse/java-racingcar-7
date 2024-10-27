package racingcar.views;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_PROMPT = "시도할 횟수는 몇 회인가요?";
    private static Scanner sc = new Scanner(System.in);

    public static String readStringInput() {
        return sc.nextLine();
    }

    public static int readNumberInput() {
        return sc.nextInt();
    }

    public static void displayInputPrompt() {
        System.out.println(INPUT_PROMPT);
    }

    public static void displayTryCountPrompt() {
        System.out.println(TRY_COUNT_PROMPT);
    }
}
