package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.InputValidator;
import racingcar.model.RaceModel;
import racingcar.view.ConsoleView;

public class RaceController {

    private final RaceModel raceModel;
    private final ConsoleView view;

    // 의존성 주입
    public RaceController(ConsoleView view, RaceModel raceModel) {
        this.view = view;
        this.raceModel = raceModel;
    }

    /**
     * 경주 게임을 시작하는 메서드.
     * 입력 처리, 검증, 경주 실행, 결과 출력의 전체 흐름을 관리함.
     */
    public void startRace() {
        // 입력
        List<String> carNames = getCarNamesFromUser();
        String numberOfAttempts = getNumberOfAttemptsFromUser();

        raceModel.initializeCars(carNames);

        //경주 진행 상황 출력
        runRace(numberOfAttempts);

        // 우승자 출력
        displayWinners();
    }

    /**
     * 자동차 이름을 입력받고 검증하는 메서드.
     */
    private List<String> getCarNamesFromUser() {
        String carNamesInput = view.requestCarNames();

        List<String> carNames = Arrays.stream(carNamesInput.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        // 자동차 입력과 관련된 모든 검증 통합
        InputValidator.validateCarNames(carNamesInput, carNames);

        return carNames;
    }

    /**
     * 시도 횟수를 입력받고 검증하는 메서드.
     */
    private String getNumberOfAttemptsFromUser() {
        String numberOfAttempts = view.requestNumberOfAttempts();
        InputValidator.validateNumber(numberOfAttempts);
        return numberOfAttempts;
    }

    /**
     * 경주를 진행하고 상태를 출력하는 메서드.
     */
    public void runRace(String numberOfAttempts) {
        view.displayExecutionResultHeader();
        int repeat = Integer.parseInt(numberOfAttempts);
        for (int i = 0; i < repeat; i++) {
            raceModel.executeRaceRound();
            view.displayRaceStatus(raceModel.getCurrentRaceStatus());
        }
    }

    /**
     * 경주 종료 후 우승자를 출력하는 메서드.
     */
    public void displayWinners() {
        List<String> winners = raceModel.getWinners();
        view.displayRaceResult(winners);
    }
}
