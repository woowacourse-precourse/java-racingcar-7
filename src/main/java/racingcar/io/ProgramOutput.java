package racingcar.io;

public class ProgramOutput {
    private static final String REQUEST_CARS_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public void requestCarsName() {
        System.out.println(REQUEST_CARS_NAME_MESSAGE);
    }
}
