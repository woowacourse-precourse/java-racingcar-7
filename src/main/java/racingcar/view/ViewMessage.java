package racingcar.view;

public class ViewMessage {
    private ViewMessage() {}

    private static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRIAL_TIMES_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static void printInputNameMessage() {
        System.out.println(INPUT_NAME_MESSAGE);
    }

    public static void printTrialTimesMessage() {
        System.out.println(INPUT_TRIAL_TIMES_MESSAGE);
    }
}
