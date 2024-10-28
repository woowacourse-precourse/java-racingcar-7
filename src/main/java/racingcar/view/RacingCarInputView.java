package racingcar.view;

import racingcar.util.InputUtils;

public class RacingCarInputView {
    private static final String INPUT_RACING_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_RACING_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public String[] readRacingCarNameInput() {
        System.out.println(INPUT_RACING_CAR_NAME_MESSAGE);
        String carNameInput = InputUtils.readInput();
        return InputUtils.parseCarNameInput(carNameInput);
    }

    public int readRacingCountInput() {
        System.out.println(INPUT_RACING_COUNT_MESSAGE);
        String raceCountInput = InputUtils.readInput();
        return InputUtils.parseRaceCountInput(raceCountInput);
    }
}
