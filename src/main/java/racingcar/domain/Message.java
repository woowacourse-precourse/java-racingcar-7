package racingcar.domain;

public class Message {

    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT = "시도할 횟수는 몇 회인가요?";

    // 외부에서 접근 못하는 private 메서드를 읽기전용으로 접근가능하게 함
    public static String promptInputCarNames() {
        return INPUT_CAR_NAMES;
    }


    public static String promptInputTryCount() {
        return INPUT_TRY_COUNT;
    }
}
