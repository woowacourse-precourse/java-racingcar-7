package racingcar.repositoryTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.domain.Round;
import racingcar.repository.CarRepository;
import racingcar.repository.RoundRepository;

public class RoundRepositoryTest {

    private CarRepository carRepository = CarRepository.getInstance();
    private RoundRepository roundRepository = RoundRepository.getInstance(carRepository);

    @Test
    public void testRoundSaveAndReferToCar() {

        //given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");

        Game exGame = new Game.Builder().build();

        Round exRound1 = new Round.Builder()
                .thisRound(1)
                .belongTo(exGame)
                .build();

        //when
        exRound1.addCar(car1);
        exRound1.addCar(car2);

        carRepository.save(car1);
        carRepository.save(car2);

        roundRepository.save(exRound1);

        //then
        Car car = carRepository.findByCarName("car1");
        Round round = roundRepository.findByRoundId(car.getRoundIdList().get(0));

        assertEquals(round.getThisRound(), exRound1.getThisRound());
        assertEquals(round.getBelongTo(), exRound1.getBelongTo());
    }
}
