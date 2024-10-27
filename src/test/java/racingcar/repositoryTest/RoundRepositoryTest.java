package racingcar.repositoryTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Round;
import racingcar.repository.CarRepository;
import racingcar.repository.RoundRepository;

public class RoundRepositoryTest {

    private CarRepository carRepository = CarRepository.getInstance();
    private RoundRepository roundRepository = RoundRepository.getInstance();

    @Test
    @DisplayName("Round 저장 및 Car 참조관계 테스트")
    public void testRoundSaveAndReferToCar() {

        //given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");

        Round exRound1 = new Round.Builder()
                .thisRound(1)
                .build();

        //when
        exRound1.addCar(car1);
        exRound1.addCar(car2);

        carRepository.save(car1);
        carRepository.save(car2);

        roundRepository.save(exRound1);

        //then
        Car car = carRepository.findByCarName("car1");

    }
}
