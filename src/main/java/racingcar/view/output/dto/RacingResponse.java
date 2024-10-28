package racingcar.view.output.dto;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.input.dto.RacingRequest;

/**
 * @author : jiffyin7@gmail.com
 * @since : 24. 10. 27.
 */
public record RacingResponse(
    List<String> winners
) {
  public static RacingResponse from(List<Car> winners) {
    List<String> carNames = winners.stream()
        .map(Car::getName)
        .toList();
    return new RacingResponse(carNames);
  }
}
