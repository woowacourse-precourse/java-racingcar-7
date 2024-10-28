package racingcar;

import java.util.ArrayList;

public class Race {
    private final ArrayList<Car> cars = new ArrayList<>();
    private final int tryCount;

    public Race(String carNames, String tryCount) {
        setCars(carNames);
        this.tryCount = changeNum(tryCount);
    }

    private void setCars(String carNamesString) {
        String[] carNames = splitString(carNamesString);
        for (String carName : carNames) {
            cars.add(new Car(carName.trim()));
        }
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

    private int changeNum(String numString) {
        int num = 0;
        try {
            num = Integer.parseInt(numString);
        } catch (Exception exception) {
            throw new IllegalArgumentException();
        }
        return num;
    }
}
