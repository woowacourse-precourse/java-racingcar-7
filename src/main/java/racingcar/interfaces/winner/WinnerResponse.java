package racingcar.interfaces.winner;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;

public record WinnerResponse(
        String winnerList
) {
    private static final String description = "최종 우승자 : ";
    private static final String winnerSeparator = ", ";

    public static WinnerResponse from(List<Car> winnerCars) {

        String winnerList = winnerCars.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(winnerSeparator));
        return new WinnerResponse(
                description + winnerList
        );
    }
}
