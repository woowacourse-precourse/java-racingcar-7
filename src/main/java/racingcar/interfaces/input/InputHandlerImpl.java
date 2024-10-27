package racingcar.interfaces.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;
import racingcar.common.exception.InvalidCarNamesException;
import racingcar.common.exception.InvalidRaceCountException;

public class InputHandlerImpl implements InputHandler {

    private static final String CAR_NAMES_SEPARATOR = ",";
    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACE_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    @Override
    public List<String> getCarNames() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
        String carNamesInput = readLine();
        validateCarNamesInput(carNamesInput);
        return Stream.of(carNamesInput.split(CAR_NAMES_SEPARATOR))
                .filter(carName -> !carName.isBlank())
                .map(String::trim)
                .toList();
    }

    @Override
    public int getRaceCount() {
        System.out.println(RACE_COUNT_INPUT_MESSAGE);
        String raceCountInput = readLine();
        return validateRaceCountInput(raceCountInput);
    }

    @Override
    public String readLine() {
        return Console.readLine().trim();
    }

    private void validateCarNamesInput(String carNamesInput) {
        if (carNamesInput.isBlank()) {
            throw new InvalidCarNamesException();
        }
    }

    private int validateRaceCountInput(String raceCountInput) {
        int raceCount;
        try {
            raceCount = Integer.parseInt(raceCountInput);
        } catch (NumberFormatException e) {
            throw new InvalidRaceCountException(raceCountInput);
        }
        return raceCount;
    }
}
