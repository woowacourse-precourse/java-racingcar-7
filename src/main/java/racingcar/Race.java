package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Race {
    private List<Car> cars;
    private int trial;
    public Race(List<Car> cars, int trial) {
        this.cars = cars;
        this.trial = trial;
    }
    public void start() {
        for (int i = 0; i < trial; i++) {
            for (Car car : cars) {
                print(car);
            }
            System.out.println();
        }
    }
    private void print(Car car) {
        System.out.println(car.getName() + " : " + car.getResult());
    }
}