package racingcar.service;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.race.Race;
import racingcar.service.factory.CarFactory;
import racingcar.util.random.RaceRandomGenerator;
import racingcar.util.random.RaceRandomGeneratorImpl;

class RaceEngineTest {

    private Race race;
    private RaceRandomGenerator randomGenerator;

    @BeforeEach
    void setUp() {
        CarFactory carFactory = new CarFactory();
        List<Car> carList = carFactory.getCarList(List.of("name1", "name2", "name3", "name4"));
        race = new Race(carList);

        randomGenerator = RaceRandomGeneratorImpl.getInstance();
    }

    @Test
    @DisplayName("raceRandomGenerator를 field로 하는 raceEngine을 생성한다.")
    void raceEngine_객체_생성_테스트() {
        RaceEngine raceEngine = new RaceEngine(randomGenerator);
        Assertions.assertThat(raceEngine).isInstanceOf(raceEngine.getClass());
    }


    @Test
    @DisplayName("race 로직을 수행하면 1회 레이스 로직이 수행된 race객체를 반환한다.")
    void race_로직_수행_테스트() {
        RaceEngine raceEngine = new RaceEngine(randomGenerator);
        Race performedRace = raceEngine.performRace(race);
        performedRace.getCars().forEach(car -> {
            Assertions.assertThat(car.getRacingDistance()).isGreaterThanOrEqualTo(0);
        });
    }

}