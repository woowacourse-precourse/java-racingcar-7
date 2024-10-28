package racingcar;

import java.util.ArrayList;
import java.util.Collections;

public class Race {
    private final ArrayList<Car> cars = new ArrayList<>();
    private final int tryCount;
    private ArrayList<Integer> result = new ArrayList<>();
    private String winner = "";

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
        return naturalNumberVaild(num);
    }

    private int naturalNumberVaild(int num) {
        if (num < 1) {
            throw new IllegalArgumentException();
        }

        return num;
    }

    public void start() {
        System.out.println("실행 결과");
        for (int progressCount = 1; progressCount <= tryCount; progressCount++) {
            cars.forEach(Car::move);
            System.out.println();
        }
        finish();
    }

    private void finish() {
        cars.forEach((car -> {
            result.add(car.getForwardProgressLength());
        }));
        int max = Collections.max(result);
        cars.forEach((car -> {
            winner += car.isWinner(max);
        }));
        System.out.println("최종 우승자 : " + winner);
    }
}
