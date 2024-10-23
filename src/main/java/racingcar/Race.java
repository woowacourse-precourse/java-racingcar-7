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
            play();
            System.out.println();
        }
    }
    private void play() {
        for (Car car : cars) {
            move(car);
            print(car);
        }
    }
    private void move(Car car) {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            String result = car.getResult();
            result += "-";
            car.setResult(result);
        }
    }
    private void print(Car car) {
        System.out.println(car.getName() + " : " + car.getResult());
    }
}