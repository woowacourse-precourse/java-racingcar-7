package racingcar.io;

public class ProgramOutput {
    private static final String REQUEST_CARS_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_GAME_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    public void requestCarsName() {
        System.out.println(REQUEST_CARS_NAME_MESSAGE);
    }

    public void requestGameCount() {
        System.out.println(REQUEST_GAME_COUNT_MESSAGE);
    }
}
