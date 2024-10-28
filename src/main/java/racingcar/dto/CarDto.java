package racingcar.dto;

import static racingcar.message.SystemMessage.CURRENT_RESULT;
import static racingcar.message.SystemMessage.DISTANCE;
import static racingcar.message.SystemMessage.GAME_WINNER;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;

public record CarDto(Map<String, Integer> carDto) {

    public static CarDto of(List<Car> cars) {
        Map<String, Integer> carDto = new LinkedHashMap<>();
        cars.forEach(car -> carDto.put(car.getCarName(), car.getCarDistance()));
        return new CarDto(carDto);
    }

    public String toCurrantDistance() {
        return carDto.entrySet().stream()
                .map(entry -> formatDistance(entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String formatDistance(String name, int distance) {
        String repeatedDistance = DISTANCE.getMessage().repeat(distance);
        return CURRENT_RESULT.getMessage().formatted(name, repeatedDistance);
    }

    public String toWinners() {
        return GAME_WINNER.getMessage().formatted(String.join(", ", carDto.keySet()));
    }
}
