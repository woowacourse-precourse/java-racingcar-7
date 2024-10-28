package racingcar.domain.racinggame;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

public class RacingGame {
    private List<Integer> distances = new ArrayList<>();

    public void startGame(Cars cars) {
        for(int i = 0; i < cars.size(); i++){
            distances.add(cars.findCarByNumber(i).move());
        }
    }

    public List<Integer> getDistances() {
        return distances;
    }

    public String getFormattedGameResult(Cars cars){
        StringBuilder result = new StringBuilder();
        for(Car car : cars.getCars()){
            result.append(formatCarResult(car)).append("\n");
        }
        result.append("\n");
        return result.toString();
    }

    private String formatCarResult(Car car) {
        StringBuilder result = new StringBuilder();
        result.append(car.getCarName()).append(" : ");

        for (int i = 0; i < car.getCurrentDistance(); i++) {
            result.append("-");
        }

        return result.toString();
    }
}
