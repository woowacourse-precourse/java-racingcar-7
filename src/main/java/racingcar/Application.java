package racingcar;

import java.util.List;

public class Application {

    private static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NUMBER_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static void main(String[] args) {

        Writer.writeMessage(NAME_INPUT_MESSAGE);
        List<String> carNames = Reader.readCarNames();

        Writer.writeMessage(NUMBER_INPUT_MESSAGE);
        int tryNumber = Reader.readNumber();

        CarManager carManager = new CarManager(carNames);
        RacingGame racingGame = new RacingGame(carManager, tryNumber);
        racingGame.play();
    }
}
