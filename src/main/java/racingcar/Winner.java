package racingcar;

import java.util.List;

public class Winner {

    public static String printWinner(List<Car> carList) {
        String winner = "";
        int maxPosition = getMaxPosition(carList);
        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                winner += car.getCarName() + ", ";
            }
        }
        return winner.replaceAll(", $", "");
    }

    public static int getMaxPosition(List<Car> carList) {
        int maxPosition = 0;
        for (Car car : carList) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }
}
