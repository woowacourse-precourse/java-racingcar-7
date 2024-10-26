package racingcar.domain;

public class Race {
    private final static String NOT_VALIDATE_NUMBER = "유효하지 않은 숫자 형식입니다.";
    private static final String IS_NOT_TRY_COUNT = "유효한 시도횟수가 아닙니다.";
    private final int tryCount;
    private final Cars cars;
    private int maxDistance;
    private WinnerCars winnerCars;

    public Race(String inputTryCount, Cars cars) {
        this.tryCount = convertToInt(inputTryCount);
        this.cars = cars;
        this.maxDistance = 0;
    }

    private static void validateTryCount(int num) {
        if (num < 1) {
            throw new IllegalArgumentException(IS_NOT_TRY_COUNT);
        }
    }

    private int convertToInt(String input) {
        try {
            int number = Integer.parseInt(input.trim());
            validateTryCount(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_VALIDATE_NUMBER);
        }
    }

    public void startRace() {
        for (int i = 0; i < tryCount; i++) {
            cars.moveCars();
        }
    }

    public void getMaxDistance() {
        this.maxDistance = cars.getMaxDistance();
    }

    public void getWinnerCars() {
        this.winnerCars = cars.getWinnerCars(this.maxDistance);
    }

}
