package racingcar.dto.response;

import racingcar.domain.Car;

import java.util.List;

public record WinnerResponse(
        List<String> winners
) {
    public static WinnerResponse from(List<Car> winners) {
        List<String> nameOfWinner = winners.stream()
                .map(car -> car.getName().name())
                .toList();
        return new WinnerResponse(nameOfWinner);
    }

    @Override
    public String toString() {
        return String.join(", ", winners);
    }
}
