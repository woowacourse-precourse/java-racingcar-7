package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Randoms;

public class Race {
    private static final int FORWARD_CRITERION = 4;
    private final IO io = new IO();
    private final CarFactory carFactory = new CarFactory();
    List<Car> cars;

    public void init(String carNames) {
        StringTokenizer carNameToken = new StringTokenizer(carNames, ",");
        cars = carFactory.createCar(carNameToken);
    }

    public void start(int attemptsNumber) {
        System.out.println("실행 결과");
        for (int i = 0; i < attemptsNumber; i++) {
            randomMovement();
            carPosition();
        }
    }

    public void result() {
        cars.sort(Comparator.reverseOrder());
        String winners = String.join(", ", findWinners());
        io.printWinners(winners);
    }

    public void randomMovement() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= FORWARD_CRITERION) car.moveForward();
        }
    }

    public void carPosition() {
        cars.forEach(Car::printPosition);
        System.out.println();
    }

    public List<String> findWinners() {
        List<String> winners = new ArrayList<>();
        int max = cars.getFirst().getPosition();
        for (Car car : cars) {
            int position = car.getPosition();
            if (position == max) winners.add(car.getName());
            else break;
        }
        return winners;
    }
}
