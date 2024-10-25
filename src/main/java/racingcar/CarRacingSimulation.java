package racingcar;

import racingcar.io.ConsoleInputHandler;
import racingcar.io.ConsoleOutputHandler;

import java.util.List;

public class CarRacingSimulation {
    private final ConsoleOutputHandler consoleOutputHandler = new ConsoleOutputHandler();
    private final ConsoleInputHandler consoleInputHandler = new ConsoleInputHandler();
    public void run() {
        consoleOutputHandler.racingCarNamingMessage(); // "자동차 이름 입력 안내" 메세지 출력
        String userInputString = consoleInputHandler.getUserInput(); // 유저 입력 받기
        List<String> carNameList = UserInputStringConverter.toList(userInputString); // 입력 문자열 자동치 이름 리스트로 변환
    }
}
