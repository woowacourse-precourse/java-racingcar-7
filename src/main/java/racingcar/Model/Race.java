package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Race {

    private List<Car> cars;
    private int minCarPower;

    public Race(List<Car> cars, int minCarPower) {

        this.cars = cars;
        this.minCarPower = minCarPower;
    }

    public void startRace(int numberOfRounds) {

        System.out.println("실행 결과");
        for (int i = 0; i < numberOfRounds; i++) {
            for (Car car : cars) {
                moveOrStop(car);
                System.out.println(car.getName() + " : " + car.getPosition());
            }
            System.out.println();
        }
    }

    public void moveOrStop(Car car) {

        if (Randoms.pickNumberInRange(0, 9) >= minCarPower) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
