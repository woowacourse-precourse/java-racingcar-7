package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.dto.CarDto;
import racingcar.dto.RoundResult;

class RaceTest {
    private List<Car> cars = new ArrayList<>();
    private Race race;

    @BeforeEach
    void setUp() {
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));
        cars.add(new Car("car3"));
    }

    @DisplayName("초기 라운드 결과: 각 차의 위치는 0이다")
    @Test
    void getRoundResult_initialPositions_success() {
        //given
        race = new Race(cars,new RandomMovementDecider());

        //when
        List<CarDto> roundResult = race.getRoundResult().getCarDtoList();

        //then
        roundResult.forEach(carDto -> Assertions.assertThat(carDto.getCurrentPosition()).isEqualTo(0));
        Assertions.assertThat(roundResult.size()).isEqualTo(3);
    }

    @DisplayName("경주 실행 후 각 차의 위치가 정상적으로 변경된다")
    @Test
    void startRace_positionsUpdated_success() {
        assertRandomNumberInRangeTest(() -> {
            //given
            race = new Race(cars,new RandomMovementDecider());

            //when
            race.start();

            //then
            Queue<Integer> expectedPosition = new LinkedList<>(Arrays.asList(1, 0, 1));  // 예상 위치
            RoundResult roundResult = race.getRoundResult();
            roundResult.getCarDtoList().forEach(carDto ->
                    Assertions.assertThat(carDto.getCurrentPosition()).isEqualTo(expectedPosition.poll())
            );
        }, 4, 3, 4);  // 무작위 숫자 지정
    }

    @DisplayName("우승자 계산이 정상적으로 동작한다")
    @ParameterizedTest
    @MethodSource("provideRaceData")
    void calculateWinners_success(int[] car1Numbers, int[] car2Numbers, int[] car3Numbers) {
        //given
        race = new Race(cars,new RandomMovementDecider());

        //when
        List<String> expectedWinners = Arrays.asList("car1", "car3");

        // 각 차의 번호에 따라 레이스 반복 실행
        for (int i = 0; i < car1Numbers.length; i++) {
            assertRandomNumberInRangeTest(() -> race.start(), car1Numbers[i], car2Numbers[i], car3Numbers[i]);
        }

        //then
        List<String> finalWinners = race.getFinalWinners().getWinnerNames();
        Assertions.assertThat(finalWinners).isEqualTo(expectedWinners);
    }

    static Stream<Arguments> provideRaceData() {
        return Stream.of(
                arguments(new int[]{4, 1, 7, 8}, new int[]{1, 2, 9, 4}, new int[]{5, 2, 8, 7})
        );
    }
}
