package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Race;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameServiceTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private GameService gameService;
    private Race race;


    @BeforeEach
    public void setUp() {
        gameService = new GameService();
        race = new Race();

        // 테스트용 자동차 추가
        race.addCar(new Car("car1"));
        race.addCar(new Car("car2"));
    }

    @Test
    void 경곗값_4_이상일_때만_이동() {
        // when
        gameService.move(race.getCarList().getFirst(), MOVING_FORWARD);
        gameService.move(race.getCarList().getLast(), STOP);

        // then
        assertThat(race.getCarList().getFirst().getCurrentLocation()).isEqualTo(1);
        assertThat(race.getCarList().getLast().getCurrentLocation()).isEqualTo(0);
    }

    @Test
    void 우승자가_한_명() {
        // given
        gameService.move(race.getCarList().getFirst(), MOVING_FORWARD);
        gameService.move(race.getCarList().getLast(), STOP);

        // when
        List<Car> finalWinners = gameService.getFinalWinners(race);

        // then
        assertThat(finalWinners).extracting(Car::getName)
                .containsExactly("car1");
    }

    @Test
    void 우승자가_여러_명() {
        // given
        gameService.move(race.getCarList().getFirst(), MOVING_FORWARD);
        gameService.move(race.getCarList().getLast(), MOVING_FORWARD);

        // when
        List<Car> finalWinners = gameService.getFinalWinners(race);

        // then
        assertThat(finalWinners).extracting(Car::getName)
                .containsExactly("car1", "car2");
    }
}