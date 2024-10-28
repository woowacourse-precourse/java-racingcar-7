package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> CAR_LIST;
    private static final String CAR_NAME_DELIMITER = ",";

    public Cars(String inputCarName) {
        List<String> carNameList = parseCarName(inputCarName);
        this.CAR_LIST = generateCarList(carNameList);
    }

    private List<Car> generateCarList(List<String> carNameList) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
        return carList;
    }

    private List<String> parseCarName(final String carName) {
        return List.of(carName.split(CAR_NAME_DELIMITER));
    }

    public void move() {
        for (Car car : CAR_LIST) {
            car.move();
        }
    }

    private int getWinnerDistance() {
        int winnerDistance = 0;
        for (Car car : CAR_LIST) {
            winnerDistance = car.maxDistanceAndOtherDistance(winnerDistance);
        }
        return winnerDistance;
    }

    public String getWinnersCarName() {
        int winnerDistance = getWinnerDistance();
        List<String> winnersCarName = new ArrayList<>();
        for (Car car : CAR_LIST) {
            if (car.isEqualToWinnerDistance(winnerDistance)) {
                winnersCarName.add(car.getCAR_NAME());
            }
        }
        return String.join(",", winnersCarName);
    }

    public void printCarsStatus() {
        for (Car car : CAR_LIST) {
            car.visualizeDistance();
        }
        printNewLine();
    }

    private void printNewLine() {
        System.out.println();
    }
}
