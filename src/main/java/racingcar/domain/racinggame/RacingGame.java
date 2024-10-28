package racingcar.domain.racinggame;

import java.util.LinkedHashMap;
import java.util.Map;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

public class RacingGame {
    private Map<String, Integer> distances = new LinkedHashMap<>();

    public RacingGame(Cars cars){
        for(Car car : cars.getCars()){
            car.move();
            distances.put(car.getCarName(), car.getCurrentDistance());
        }
    }

    public Map<String, Integer> getDistances() {
        return distances;
    }

    public String getFormattedGameResult(){
        StringBuilder result = new StringBuilder();
        for(String carName : distances.keySet()){
            result.append(carName).append(" : ");
            result.append(formatCarResult(distances.get(carName))).append("\n");
        }
        result.append("\n");
        return result.toString();
    }

    private String formatCarResult(int advance) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < advance; i++) {
            result.append("-");
        }
        return result.toString();
    }
}
