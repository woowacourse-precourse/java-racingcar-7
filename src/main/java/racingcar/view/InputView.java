package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.RacingRequestDto;

public class InputView {
    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public RacingRequestDto getRacingRequest() {
        String carNames = getCarNames();
        String roundsToRace = getRoundsToRace();
        return new RacingRequestDto(carNames, roundsToRace);
    }

    private String getCarNames() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
        String carNames = Console.readLine();
        if (isInputEmpty(carNames)) {
            throw new IllegalArgumentException("사용자의 입력이 없습니다");
        }
        return carNames;
    }

    private String getRoundsToRace() {
        System.out.println(ROUND_INPUT_MESSAGE);
        String roundsToRace = Console.readLine();
        if (isInputEmpty(roundsToRace)) {
            throw new IllegalArgumentException("사용자의 입력이 없습니다.");
        }
        return roundsToRace;
    }

    private boolean isInputEmpty(String input) {
        return (input == null || input.isEmpty());
    }
}
