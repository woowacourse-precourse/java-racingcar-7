package racingcar;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public record RoundHistory(Map<String, Integer> nameAndPosition) {
    public static RoundHistory saveCarPosition(List<Car> carList){
        Map<String, Integer> carNameAndPosition = new LinkedHashMap<>();

        for (Car car : carList) {
            carNameAndPosition.put(car.getName(), car.getPosition());
        }

        return new RoundHistory(carNameAndPosition);
    }
}
