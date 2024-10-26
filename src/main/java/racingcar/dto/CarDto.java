package racingcar.dto;

import static racingcar.message.SystemMessage.CURRENT_RESULT;
import static racingcar.message.SystemMessage.DISTANCE;
import static racingcar.message.SystemMessage.GAME_WINNER;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.car.Car;

public record CarDto(Map<String, Integer> carDto) {

    public static CarDto of(List<Car> cars) {
        Map<String, Integer> carDto = new LinkedHashMap<>();
        cars.forEach(car -> carDto.put(car.getCarName(), car.getCarDistance()));
        return new CarDto(carDto);
    }

    public String toCurrantDistance() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String name : carDto.keySet()) {
            stringBuilder.append(
                    CURRENT_RESULT.getMessage().formatted(name, DISTANCE.getMessage().repeat(carDto.get(name))));
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    public String toWinners() {
        return GAME_WINNER.getMessage().formatted(String.join(", ", carDto.keySet()));
    }
}
