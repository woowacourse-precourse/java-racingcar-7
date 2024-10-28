package racingcar.domain;

import racingcar.io.InputReader;
import racingcar.io.Printer;

import java.util.List;

public class RacingCarGame {

    private final InputReader reader = new InputReader();
    private final Printer printer = new Printer();
    private final RaceState raceState = new RaceState();

    public void play() {

        // 자동차 이름 입력 받기
        printer.printInputNamesMessage();
        List<String> carNames = reader.readCarNames();

        // 경주 라운드 입력 받기
        printer.printInputRoundMessage();
        int roundCount = reader.readCount();

        // 게임 초기화
        raceState.initGame(carNames);

        // 라운드 실행
        printer.printRaceStartMessage();
        for (int i = 0; i < roundCount; i++) {
            raceState.playRound();
            printer.printRoundResult(raceState.getCars());
        }

        // 우승자 출력
        printer.printWinners(raceState.getWinners());
    }

}