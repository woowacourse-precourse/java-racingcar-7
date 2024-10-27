package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.view.OutputView;


public class Race {
    private static final String CAR_NAME_EMPTY_EXCEPTION_MSG = "자동차 이름을 설정해주세요.";
    private static final String CAR_NAME_LENGTH_OVER_EXCEPTION_MSG = "자동차 이름은 5자 이하만 가능합니다.";
    private static final String NUMBER_FORMAT_EXCEPTION_MSG = "정수를 입력해주세요.";
    private static final String SAME_CAR_EXCEPTION_MSG = "중복된 자동차 이름이 존재합니다.";
    private static final int NAME_LENGTH_LIMIT = 5;
    private static final String STRING_DELIMITER = ",";

    private List<Car> racingCars = new ArrayList<>();
    private int round;

    public Race(String racingCarNames, String roundInput) {
        validateRacingCarNames(racingCarNames);
        validateRoundInput(roundInput);
        setRacingCars(racingCarNames);
        setRound(roundInput);
    }


    private void validateRacingCarNames(String racingCarNames) {
        String[] racingCarNameTokens = racingCarNames.split(STRING_DELIMITER);
        validateNoEmptyName(racingCarNames);
        validateNoNameOver5Characters(racingCarNameTokens);
        validateNoSameName(racingCarNameTokens);
    }

    private void validateNoEmptyName(String racingCarNames) {
        if (racingCarNames.startsWith(STRING_DELIMITER) || racingCarNames.endsWith(STRING_DELIMITER)
                || racingCarNames.contains(STRING_DELIMITER.repeat(2))) {
            throw new IllegalArgumentException(CAR_NAME_EMPTY_EXCEPTION_MSG);
        }
        String[] racingCarNameTokens = racingCarNames.split(STRING_DELIMITER);

        Arrays.stream(racingCarNameTokens).forEach(carName -> {
            if (carName.isEmpty()) {
                throw new IllegalArgumentException(CAR_NAME_EMPTY_EXCEPTION_MSG);
            }
        });
    }

    private void validateNoNameOver5Characters(String[] racingCarNameTokens) {
        Arrays.stream(racingCarNameTokens).forEach(carName -> {
            if (carName.length() > NAME_LENGTH_LIMIT) {
                throw new IllegalArgumentException(CAR_NAME_LENGTH_OVER_EXCEPTION_MSG);
            }
        });
    }

    private void validateNoSameName(String[] racingCarNameTokens) {
        Set<String> racingCarNameSet = new HashSet<>(List.of(racingCarNameTokens));
        if (racingCarNameSet.size() != List.of(racingCarNameTokens).size()) {
            throw new IllegalArgumentException(SAME_CAR_EXCEPTION_MSG);
        }
    }

    private void validateRoundInput(String roundInput) {
        int round;
        try {
            round = Integer.parseInt(roundInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION_MSG);
        }
        if (round <= 0) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION_MSG);
        }
    }

    private void setRacingCars(String racingCarNames) {
        racingCars = Arrays.stream(racingCarNames.split(STRING_DELIMITER)).map(Car::new).toList();
    }

    private void setRound(String roundInput) {
        this.round = Integer.parseInt(roundInput);
    }

    public void runRace() {
        OutputView.printRoundResultHeader();
        for (int i = 0; i < round; i++) {
            runOneRound();
        }
    }

    private void runOneRound() {
        racingCars.forEach(Car::decideProgressByRandomNumber);
        OutputView.printRoundResult(racingCars);

    }

    public List<String> getWinnerNames() {
        int maxScore = racingCars.stream().mapToInt(Car::getProgressCount).max()
                .orElseThrow(IllegalArgumentException::new);
        return racingCars.stream().filter(racingCar -> racingCar.getProgressCount() == maxScore).map(Car::getName)
                .toList();

    }

    public List<Car> getRacingCars() {
        return racingCars;
    }

    public int getRound() {
        return round;
    }

}
