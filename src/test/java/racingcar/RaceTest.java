package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;
import racingcar.domain.Race;
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

    @DisplayName("각 회차 경기 결과 정상 반환")
    @Test
    void getRoundResult_return_success() {
        //given
        List<Car> testCars = cars;
        race = new Race(testCars);

        //when
        List<CarDto> roundResult = race.getRoundResult().getCarDtoList();

        //then
        roundResult.stream().forEach(carDto -> {
            Assertions.assertThat(carDto.getCurrentPosition()).isEqualTo(0);
        });
        Assertions.assertThat(roundResult.size()).isEqualTo(3);
    }

    @DisplayName("각 회차 경기 정상 작동")
    @Test
    void start_success() {
        assertRandomNumberInRangeTest(() -> {
                    //given
                    List<Car> testCars = cars;
                    race = new Race(testCars);
                    //when
                    race.start();
                    Queue<Integer> expectedPosition = new LinkedList<>();
                    expectedPosition.addAll(Arrays.asList(1, 0, 1));
                    //then
                    RoundResult roundResult = race.getRoundResult();
                    roundResult.getCarDtoList().stream().forEach(carDto -> {
                        Assertions.assertThat(carDto.getCurrentPosition()).isEqualTo(expectedPosition.poll());
                    });
                }
                , 4, 3, 4);
    }

    static Stream<Arguments> provideAdditionData() {
        return Stream.of(
                arguments(new int[]{4, 1, 7, 8}, new int[]{1, 2, 9, 4}, new int[]{5, 2, 8, 7})
        );
    }

    @DisplayName("최종 우승자 출력")
    @ParameterizedTest
    @MethodSource("provideAdditionData")
    void getWinners_test(int[] car1Numbers, int[] car2Numbers, int[] car3Numbers) {
        //given
        List<Car> testCars = cars;
        race = new Race(testCars);

        //when
        List<String> expectedWinners = Arrays.asList("car1", "car3");

        // 각 차의 번호를 각 반복마다 변경하며 레이스 실행
        for (int i = 0; i < 4; i++) {
            assertRandomNumberInRangeTest(() -> {
                race.start();
            }, car1Numbers[i], car2Numbers[i], car3Numbers[i]);
        }

        // then
        List<String> finalWinners = race.getFinalWinners().getWinnerNames();
        Assertions.assertThat(finalWinners).isEqualTo(expectedWinners);
    }

}

