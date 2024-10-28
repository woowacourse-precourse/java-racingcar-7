package racingcar.application.util.io;

public final class RequestPrinter {

    private static final String REQUEST_NAMES_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_TRIAL_INPUT = "시도할 횟수는 몇 회인가요?";

    private RequestPrinter() {}

    public static void printRequestNamesInput() {
        System.out.println(REQUEST_NAMES_INPUT);
    }

    public static void printRequestTrialInput() {
        System.out.println(REQUEST_TRIAL_INPUT);
    }

}
