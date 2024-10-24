package racingcar;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceTest {
    private List<Car> cars = new ArrayList<>();
    private Race race;

    @BeforeEach
    void setUp() {
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));
        cars.add(new Car("car3"));
    }

    @DisplayName("각 회차 경기 결과 정상 반환")
    @Test
    void getRoundResult_return_success(){
        //given
        List<Car> testCars = cars;
        race = new Race(testCars);

        //when
        List<CarStatus> roundResult = race.getRoundResult();

        //then
        roundResult.stream().forEach(carStatus -> {
            Assertions.assertThat(carStatus.getCurrentPosition()).isEqualTo(0);
        });
        Assertions.assertThat(roundResult.size()).isEqualTo(3);
    }
}