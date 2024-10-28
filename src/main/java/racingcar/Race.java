package racingcar;

public class Race {
    private String[] carNames;
    private final String tryCount;

    public Race(String carNames, String tryCount) {
        this.carNames = splitString(carNames);
        this.tryCount = tryCount;
    }

    private String[] splitString(String string) {
        String[] carNames = string.split(",");
        return carNamesVaild(carNames);
    }

    private String[] carNamesVaild(String[] carNames) {
        for (String carName : carNames) {
            if (carName.trim().length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        return carNames;
    }
}
