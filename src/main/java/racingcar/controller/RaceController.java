package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.InputValidator;
import racingcar.model.CarRace;
import racingcar.view.ConsoleView;

public class RaceController {

    private CarRace carRace;
    private final ConsoleView view;

    // 의존성 주입
    public RaceController(ConsoleView view) {
        this.view = view;
    }

    /**
     * 경주 게임을 시작하는 메서드.
     * 입력 처리, 검증, 경주 실행, 결과 출력의 전체 흐름을 관리함.
     */
    public void startRace() {
        // 입력
        List<String> carNames = getCarNamesFromUser();
        String numberOfAttempts = getNumberOfAttemptsFromUser();

        // 경주를 위한 객체 생성
        carRace = new CarRace(carNames);

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

        InputValidator.validateEmptyInput(carNamesInput);
        InputValidator.validateCommaSeparator(carNamesInput);
        InputValidator.validateSameCarName(carNames);

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
        int repeat = Integer.parseInt(numberOfAttempts);
        for (int i = 0; i < repeat; i++) {
            carRace.race();
            view.displayRaceStatus(carRace.getCars());
        }
    }

    /**
     * 경주 종료 후 우승자를 출력하는 메서드.
     */
    public void displayWinners() {
        List<String> winners = carRace.findWinners();
        view.displayRaceResult(winners);
    }
}
