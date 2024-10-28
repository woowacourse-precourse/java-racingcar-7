package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

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

        return result.toString();
    }

    private String formatCarResult(Car car) {
        StringBuilder result = new StringBuilder();
        result.append(car.getCarName()).append(" : ");

        for (int i = 0; i < car.getCurrentProgress(); i++) {
            result.append("-");
        }

        return result.toString();
    }
}
