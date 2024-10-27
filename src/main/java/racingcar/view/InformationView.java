package racingcar.view;

public class InformationView {
    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT = "시도할 횟수는 몇 회인가요?";

    public void printRequestCarNames(){
        System.out.println(INPUT_CAR_NAMES);
    }

    public void printRequestTryCount(){
        System.out.println(INPUT_TRY_COUNT);
    }
}
