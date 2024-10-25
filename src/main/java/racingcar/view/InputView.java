package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final String CAR_NAME_QUESTION = "경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)";
    private static final String CAR_TRY_QUESTION = "시도할 횟수";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputCarNames() {
        System.out.println(CAR_NAME_QUESTION);
        return SCANNER.nextLine();
    }

    public static int inputTryCount() {
        System.out.println();
        System.out.println(CAR_TRY_QUESTION);
        int tryCount = SCANNER.nextInt();
        SCANNER.nextLine();
        return tryCount;
    }

}
