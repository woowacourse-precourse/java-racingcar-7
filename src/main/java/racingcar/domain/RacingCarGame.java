package racingcar.domain;

import racingcar.io.InputReader;
import racingcar.io.OutputPrinter;

import java.util.List;

public class RacingCarGame {

    private final InputReader reader = new InputReader();
    private final OutputPrinter printer = new OutputPrinter();
    private final RaceState raceState = new RaceState();

    public void play() {

        // 자동차 이름 및 실행횟수 입력받기
        List<String> carNames = reader.readCarNames();
        int roundCount = reader.readCount();

        // 게임 초기화
        raceState.initGame(carNames);

        // 라운드 실행
        printer.printStartMessage();
        for (int i = 0; i < roundCount; i++) {
            raceState.playRound();
            printer.printRoundResult(raceState.getCars());
        }

        // 우승자 출력
        printer.printWinners(raceState.getWinners());
    }

}