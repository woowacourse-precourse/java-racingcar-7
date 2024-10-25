package racingcar.user;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    public String[] readNamesOfCars() {
        String[] namesOfCars = Console.readLine().split(",");

        for (String carName : namesOfCars) {
            if (!isValidCarName(carName)) {
                throw new IllegalArgumentException("자동차 이름(\"" + carName + "\")에 대한 형식이 잘못되었습니다.");
            }
        }

        return namesOfCars;
    }

    public int readNumberOfAttempts() {
        String numberOfAttemptsInput = Console.readLine();

        if (!isValidNumberOfAttempts(numberOfAttemptsInput)) {
            throw new IllegalArgumentException("시도할 횟수(\"" + numberOfAttemptsInput + "\")에 대한 형식이 잘못되었습니다.");
        }
        return Integer.parseInt(Console.readLine());
    }

    private boolean isValidCarName(String carName) {
        return carName.length() > 5;
    }

    private boolean isValidNumberOfAttempts(String numberOfAttemptsInput) {
        try {
            int numberOfAttempts = Integer.parseInt(numberOfAttemptsInput);
            return numberOfAttempts > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
