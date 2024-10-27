package racingcar;

import java.util.List;
import java.util.StringTokenizer;
import camp.nextstep.edu.missionutils.Randoms;

public class Race {
    private static final int FORWARD_CRITERION = 4;
    private CarFactory carFactory = new CarFactory();
    List<Car> cars;

    public void init(String carNames) {
        StringTokenizer carName = new StringTokenizer(carNames, ",");
        cars = carFactory.createCars(carName);
    }

    public void start(long number) {
        System.out.println("실행 결과");
        for (long i = 0; i < number; i++) {
            randomMovement();
            carPosition();
            System.out.println();
        }
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

}
