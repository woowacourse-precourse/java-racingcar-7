package racingcar;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Result {
    int maxAdvance = 0;
    List<Car> winnerList = new ArrayList<>();

    public void isWinner(List<Car> cars) {
        findResult(cars);
        for (Car car : cars){
            if (car.currentPosition() == maxAdvance) {
                winnerList.add(car);
            }
        }
        List<String> winnerNames = getWinnerNames();
        String result = String.join(", ", winnerNames);
        System.out.println("최종 우승자: " + result);
    }

    private List<String> getWinnerNames() {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : winnerList) {
            winnerNames.add(car.carName());
        }
        return winnerNames;
    }

    private void findResult(List<Car> cars) {
        for (Car car : cars) {
            maxAdvance = Math.max(maxAdvance, car.currentPosition());
        }
    }
}
