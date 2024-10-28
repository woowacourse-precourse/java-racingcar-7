package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    private static final String DELIMITER = ",";
    private static final String GO_STRING = "-";
    private static final String WINNER_PREFIX = "최종 우승자 : ";
    private static final String WINNER_DELIMITER = ", ";
    private static final int CAR_NAME_LENGTH_LIMIT = 5;
    private final GoMethod method;

    Racing(GoMethod goMethod) {
        this.method = goMethod;
    }

    private int max(int obj1, int obj2) {
        if (obj1 < obj2) {
            return obj2;
        }
        return obj1;
    }

    private void checkValidation(String[] carNames) {
        for (String name: carNames) {
            if (name.length() > CAR_NAME_LENGTH_LIMIT || name.isBlank()) {
                throw new IllegalArgumentException("자동차 이름이 제한 길이를 넘어갑니다 carName : " + name);
            }
        }
    }

    private List<Car> makeCars(String plainCarNames) {
        String[] carNames = plainCarNames.split(DELIMITER);
        checkValidation(carNames);

        List<Car> cars = new ArrayList<>();

        for(String name : carNames) {
            Car car = new Car(name);
            cars.add(car);
        }

        return cars;
    }

    private void tryRacing(Car car) {
        if (method.canIGo()) {
            car.getStringBuilder().append(GO_STRING);
            car.increaseWinCount();
        }
    }

    private void tryRacingCars(List<Car> cars) {
        for(Car car : cars) {
            tryRacing(car);
            System.out.println(car.getStringBuilder());
        }
    }

    private void printWinner(List<Car> cars) {
        int maxWinCount = 0;
        StringBuilder builder = new StringBuilder(WINNER_PREFIX);

        for (Car car : cars) {
            maxWinCount = max(maxWinCount, car.getWinCount());
        }

        for (Car currentCar : cars) {
            if (currentCar.getWinCount() == maxWinCount) {
                builder.append(currentCar.getName());
                builder.append(WINNER_DELIMITER);
            }
        }

        //Winner 가 없는 경우는 없기 때문에 반드시 마지막 콤마가 생기게 된다 마지막 콤마 부분 제거
        builder.delete(builder.length() - WINNER_DELIMITER.length(), builder.length());

        System.out.println(builder);
    }

    public void doRacing(String plainCarNames, int round) {
        List<Car> cars = makeCars(plainCarNames);

        while (round > 0) {
            tryRacingCars(cars);
            round--;
            System.out.println();
        }

        printWinner(cars);
    }
}
