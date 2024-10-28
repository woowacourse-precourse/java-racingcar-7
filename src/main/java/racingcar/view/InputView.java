package racingcar.view;

public class InputView {

    public static String PRINT_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static String PRINT_LIMIT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static void printInputMessage() {
        System.out.println(PRINT_INPUT_MESSAGE);
    }

    public static void printLimitMessage() {
        System.out.println(PRINT_LIMIT_MESSAGE);
    }


}
