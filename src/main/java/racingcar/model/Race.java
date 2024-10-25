package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import racingcar.view.OutputView;


public class Race {
    private static final String CAR_NAME_LENGTH_EXP_MSG = "자동차 이름은 5자 이하만 가능합니다.";
    private static final String NUMBER_FORMAT_EXCEPTION_MSG = "정수를 입력해주세요.";
    private static final int NAME_LENGTH_LIMIT = 5;
    private static final String STRING_DELIMITER = ",";

    private List<Car> racingCars = new ArrayList<>();
    private int round;

    public Race(String racingCarNames, String roundInput) {
        setRacingCars(racingCarNames);
        setRound(roundInput);
    }

    private void setRacingCars(String racingCarNames) {
        racingCars = Arrays.stream(racingCarNames.split(STRING_DELIMITER))
                .peek(name -> {
                    if (name.length() > NAME_LENGTH_LIMIT) {
                        throw new IllegalArgumentException(CAR_NAME_LENGTH_EXP_MSG);
                    }
                }).map(Car::new).toList();
    }

    private void setRound(String roundInput) {
        try {
            this.round = Integer.valueOf(roundInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION_MSG);
        }
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
        OptionalInt maxScore = racingCars.stream().mapToInt(Car::getProgressCount).max();
        return racingCars.stream().filter(
                        racingCar -> racingCar.getProgressCount() == maxScore.getAsInt())
                .map(Car::getName).toList();

        // TODO. OptionalInt empty check. empty일 때 예외처리.
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }

    public int getRound() {
        return round;
    }

}
