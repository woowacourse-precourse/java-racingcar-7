package racingcar.controller;

import racingcar.model.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class RaceController {
    private final InputView inputView;
    private final OutputView outputView;

    public RaceController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        try {
            Race race = initializeRace();
            int rounds = getRounds();
            playGame(race, rounds);
            announceWinners(race);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private Race initializeRace() {
        String namesInput = inputView.inputCarNames();
        List<String> carNames = parseCarNames(namesInput);
        return new Race(carNames);
    }

    private List<String> parseCarNames(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 입력되지 않았습니다.");
        }
        return Arrays.asList(input.split(","));
    }

    private int getRounds() {
        String roundsInput = inputView.inputRounds();
        try {
            int rounds = Integer.parseInt(roundsInput);
            if (rounds <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return rounds;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
        }
    }

    private void playGame(Race race, int rounds) {
        outputView.printGameStart();
        for (int i = 0; i < rounds; i++) {
            playRound(race);
        }
    }

    private void playRound(Race race) {
        race.playRound();
        printRoundResult(race);
        outputView.printRoundEnd();
    }

    private void printRoundResult(Race race) {
        for (var car : race.getCars()) {
            outputView.printCarStatus(car.getName(), car.getPosition());
        }
    }

    private void announceWinners(Race race) {
        List<String> winners = race.getWinners();
        outputView.printWinners(winners);
    }
}