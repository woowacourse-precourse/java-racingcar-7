package racingcar.user;

public class UserInput {

    public String[] readNamesOfCars(String namesOfCarsInput) {

        if (isInputNullOrEmpty(namesOfCarsInput)) {
            throw new IllegalArgumentException("입력이 비어있을 수 없습니다.");
        }

        String[] namesOfCars = namesOfCarsInput.split(",");

        for (String carName : namesOfCars) {
            if (!isValidCarName(carName)) {
                throw new IllegalArgumentException("자동차 이름(\"" + carName + "\")에 대한 형식이 잘못되었습니다.");
            }
        }

        return namesOfCars;
    }

    public int readNumberOfAttempts(String numberOfAttemptsInput) {

        if (isInputNullOrEmpty(numberOfAttemptsInput)) {
            throw new IllegalArgumentException("입력이 비어있을 수 없습니다.");
        }

        if (!isValidNumberOfAttempts(numberOfAttemptsInput)) {
            throw new IllegalArgumentException("시도할 횟수(\"" + numberOfAttemptsInput + "\")에 대한 형식이 잘못되었습니다.");
        }

        return Integer.parseInt(numberOfAttemptsInput);
    }

    private boolean isInputNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private boolean isValidCarName(String carName) {
        int carNameLength = carName.length();
        return 0 < carNameLength && carNameLength <= 5;
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
