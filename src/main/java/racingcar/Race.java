package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import camp.nextstep.edu.missionutils.Randoms;

public class Race {
    private static final int FORWARD_CRITERION = 4;
    private IO io = new IO();
    private CarFactory carFactory = new CarFactory();
    List<Car> cars;

    public void init(String carNames) {
        StringTokenizer carName = new StringTokenizer(carNames, ",");
        cars = carFactory.createCars(carName);
    }

    public void start(int number) {
        System.out.println("실행 결과");
        for (int i = 0; i < number; i++) {
            randomMovement();
            carPosition();
            System.out.println();
        }
    }

    public void result() {
        cars.sort(Comparator.reverseOrder());
        String winners = String.join(",", findWinner());
        io.printWinner(winners);
    }

    public void randomMovement() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= FORWARD_CRITERION) car.moveForward();
        }
    }

    public void carPosition() {
        for (Car car : cars) {
            car.printPosition();
            System.out.println();
        }
    }

    public List<String> findWinner() {
        List<String> winners = new ArrayList<>();
        int max = cars.get(0).getPosition();
        for (Car car : cars) {
            int position = car.getPosition();
            if (position == max) winners.add(car.getName());
            else break;
        }
        return winners;
    }
}
