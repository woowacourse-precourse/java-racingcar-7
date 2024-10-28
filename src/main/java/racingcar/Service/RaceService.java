package racingcar.Service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Model.Car;
import racingcar.View.OutputView;

import java.util.ArrayList;

public class RaceService {

    public void raceCar(ArrayList<Car> cars, int count) {

        for (int i = 0; i < count; i++) {
            move(cars);
            OutputView.PrintResult(cars);
        }
        OutputView.PrintWinner(getWinner(cars));
    }

    private void move(ArrayList<Car> cars) {

        for (Car car : cars) {
            int randomPosition = Randoms.pickNumberInRange(0, 9);
            car.move(randomPosition);
        }
    }

    public ArrayList<Car> getWinner(ArrayList<Car> cars) {
        ArrayList<Car> winners = new ArrayList<>();
        int maxPosition = 0;

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

}
