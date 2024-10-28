package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.Domain.Car;
import racingcar.repository.CarRepository;
import racingcar.service.RacingGameService;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingGameServiceTest {

    @Test
    public void testMultipleWinners() {
        // Given
        Car car1 = new Car("Car1", "------");
        Car car2 = new Car("Car2", "-------");
        Car car3 = new Car("Car3", "-------"); // 동일한 Displacement를 가진 차

        CarRepository.getInstance().save(car1);
        CarRepository.getInstance().save(car2);
        CarRepository.getInstance().save(car3);

        RacingGameService winnerDecider = new RacingGameService();

        // When
        String winners = winnerDecider.decideWinner();

        // Then
        // 여러 우승자가 있는지 확인
        assertEquals("Car2, Car3", winners); // 예상 우승자 목록을 확인합니다.
    }

}