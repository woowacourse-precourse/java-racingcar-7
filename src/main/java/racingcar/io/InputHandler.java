package racingcar.io;

import racingcar.RaceCars;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputHandler {

    public RaceCars getRaceCars() {
        String userInput = readLine();
        String[] carsNames = splitCarsNames(userInput);

        validateCarsCount(carsNames);
        validateCarsNamesLength(carsNames);

        return RaceCars.addCars(carsNames);
    }

    public int getRaceCount() {
        String userInput = readLine();
        int raceCount = parseIntRaceCount(userInput);

        validateRaceCount(raceCount);

        return raceCount;
    }

    private String[] splitCarsNames(String input) {
        return input.split(",");
    }

    private void validateCarsCount(String[] carNames) {
        checkCarsCountMoreThanTwo(carNames);
    }

    private void checkCarsCountMoreThanTwo(String[] carNames) {
        if (carNames.length < 2) {
            throw new IllegalArgumentException("경주할 자동차는 2개 이상이어야 합니다.");
        }
    }

    private void validateCarsNamesLength(String[] carNames) {
        for (String carName : carNames) {
            checkCarNameLengthWithinFive(carName);
        }
    }

    private void checkCarNameLengthWithinFive(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("경주할 자동차의 이름은 5자 이하여야 합니다.");
        }
    }

    private int parseIntRaceCount(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("경주 횟수는 숫자를 입력해야 합니다.");
        }
    }

    private void validateRaceCount(int raceCount) {
        checkRaceCountIsPositive(raceCount);
    }

    private void checkRaceCountIsPositive(int raceCount) {
        if (raceCount <= 0) {
            throw new IllegalArgumentException("경주 횟수는 0이상을 입력해야 합니다.");
        }
    }
}