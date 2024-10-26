package racingcar.model.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final String PROCESS_DELIMITER = " : ";
    private static final String RESULT_DELIMITER = ", ";
    private static final String LINE_BREAK = "\n";

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public String race() {
        StringBuilder result = new StringBuilder();
        for (Car car : cars) {
            car.tryForward();
            makeResult(result, car);
        }
        return result.toString();
    }

    public String winners() {
        List<String> winners = new ArrayList<>();
        int max = 0;
        for (Car car : cars) {
            int position = car.positionToString().length();
            if (max < position) {
                max = position;
            }
        }

        for (Car car : cars) {
            int position = car.positionToString().length();
            if (max == position) {
                winners.add(car.getName());
            }
        }
        return String.join(RESULT_DELIMITER, winners);
    }

    private void makeResult(final StringBuilder result, final Car car) {
        result.append(car.getName());
        result.append(PROCESS_DELIMITER);
        result.append(car.positionToString());
        result.append(LINE_BREAK);
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Cars target = (Cars) object;

        for (int i = 0; i < target.cars.size(); i++) {
            String thisName = this.cars.get(i).getName();
            String targetName = target.cars.get(i).getName();
            if (thisName.equals(targetName)) {
                continue;
            }
            return false;
        }
        return true;
    }
}