package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class RacingCars {

    private final ArrayList<Car> racingCars;

    public RacingCars(ArrayList<String> carNames) {
        racingCars = new ArrayList<Car>();
        for (String carName : carNames) {
            racingCars.add(new Car(carName));
        }
    }

    public String getWinner() {
        int maxPosition = getMaxPosition();
        StringBuilder winner = new StringBuilder();
        racingCars.stream().filter(car -> car.getPosition() == maxPosition)
                .forEach(car -> winner.append(car.getName()).append(","));
        return winner.substring(0, winner.length() - 1);
    }

    private int getMaxPosition() {
        return racingCars.stream().mapToInt(Car::getPosition).max().orElseThrow(IllegalStateException::new);
    }

    public void moveEachCarsIfPossible() {
        for (Car car : racingCars) {
            car.moveIfPossible(Randoms.pickNumberInRange(0, 9));
        }
    }

    public void printEachCarsStatus() {
        for (Car car : racingCars) {
            System.out.println(car.getStatus());
        }
        System.out.println();
    }

}
