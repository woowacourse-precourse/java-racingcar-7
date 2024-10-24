package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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

    @DisplayName("각 회차 경기 정상 작동")
    @Test
    void start_success(){
        assertRandomNumberInRangeTest(() -> {
                    //given
                    List<Car> testCars = cars;
                    race = new Race(testCars);
                    //when
                    race.start();
                    Queue<Integer> expectedPosition = new LinkedList<>();
                    expectedPosition.addAll(Arrays.asList(1,0,1));
                    //then
                    List<CarStatus> roundResult = race.getRoundResult();
                    roundResult.stream().forEach(carStatus -> {
                        Assertions.assertThat(carStatus.getCurrentPosition()).isEqualTo(expectedPosition.poll());
                    });
                }
                , 4,3,4);
    }
}