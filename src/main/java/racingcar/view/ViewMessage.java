package racingcar.view;

public class ViewMessage {
    private ViewMessage() {}

    static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
//    static final String INPUT_TRIAL_TIME_MESSAGE = "시도할 횟수는 몇 회인가요?";

    static void printInputNameMessage() {
        System.out.println(INPUT_NAME_MESSAGE);
    }

//    static void printTrialTimesMessage() {
//        System.out.println(INPUT_TRIAL_TIME_MESSAGE);
//    }
}
