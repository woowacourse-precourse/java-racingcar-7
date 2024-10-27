package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.view.OutputView;


public class Race {
    private static final String CAR_NAME_LENGTH_EXP_MSG = "자동차 이름은 5자 이하만 가능합니다.";
    private static final String NUMBER_FORMAT_EXCEPTION_MSG = "정수를 입력해주세요.";
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
        String[] racingCarNameTokens = racingCarNames.split(",");

        try {
            validateNoEmptyName(racingCarNameTokens);
            validateNoNameOver5Characters(racingCarNameTokens);
            validateNoSameName(racingCarNameTokens);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNoEmptyName(String[] racingCarNameTokens) {
        Arrays.stream(racingCarNameTokens).forEach(carName -> {
            if (carName.isEmpty()) {
                throw new IllegalArgumentException();
            }
        });
    }

    private void validateNoNameOver5Characters(String[] racingCarNameTokens) {
        Arrays.stream(racingCarNameTokens).forEach(carName -> {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        });
    }

    private void validateNoSameName(String[] racingCarNameTokens) {
        Set<String> racingCarNameSet = new HashSet<>(List.of(racingCarNameTokens));
        if (racingCarNameSet.size() != List.of(racingCarNameTokens).size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRoundInput(String roundInput) {
        int round;
        try {
            round = Integer.valueOf(roundInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if (round <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private void setRacingCars(String racingCarNames) {
        racingCars = Arrays.stream(racingCarNames.split(STRING_DELIMITER))
                .map(Car::new).toList();
    }

    private void setRound(String roundInput) {
        this.round = Integer.valueOf(roundInput);
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
        return racingCars.stream().filter(
                        racingCar -> racingCar.getProgressCount() == maxScore)
                .map(Car::getName).toList();

    }

    public List<Car> getRacingCars() {
        return racingCars;
    }

    public int getRound() {
        return round;
    }

}
