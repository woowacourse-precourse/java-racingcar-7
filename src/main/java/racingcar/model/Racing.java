package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputView;

public class Racing {
    private Car[] cars;
    private int attempts;

    public Racing(String[] cars, int attempts) {
        this.cars = new Car[cars.length];
        for (int i = 0; i < cars.length; i++) {
            this.cars[i] = new Car(cars[i]);
        }
        this.attempts = attempts;
    }

    public void start() {
        for (int i = 0; i < attempts; i++) {
            moveCars();
            OutputView.printCarsPostions(cars);
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.move();
            }
        }
    }

    public String getWinners() {
        int max = 0;
        StringBuilder winners = new StringBuilder();

        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        for (Car car : cars) {
            if (car.getPosition() == max) {
                winners.append(car.getName()).append(",");
            }
        }

        return winners.substring(0, winners.length()-1);
    }
}