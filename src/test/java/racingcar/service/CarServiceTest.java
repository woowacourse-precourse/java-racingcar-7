package racingcar.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.repository.CarRepositoryImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class CarServiceTest {
    private CarService carService;
    private CarRepository carRepository;
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @BeforeEach
    void setup(){
        carRepository = new CarRepositoryImpl(new ArrayList<>());
        carService = new CarService(carRepository);
    }

    @Test
    void 자동차_생성_테스트(){
        // given
        List<String> nameList = Arrays.asList("hi", "me", "ya");
        // when
        carService.initCars(nameList);
        //then
        assertThat(carRepository.findAll())
                .hasSize(3)
                .extracting(Car::getName) // 객체에서 특정 속성을 추출할 때 사용!
                .containsExactly("hi", "me", "ya");
    }

    @Test
    void 게임_한_턴_진행_테스트(){

        //given
        carService.initCars(Arrays.asList("seuk", "hi"));

        assertRandomNumberInRangeTest(
                () -> {
                    // when
                    List<Car> cars = carService.playRound();

                    // then
                    assertThat(cars)
                            .extracting(Car::getName, Car::getMoveCount)
                            .contains(
                                    tuple("seuk", 1),
                                    tuple("hi", 0)
                            );
                    },
                MOVING_FORWARD, STOP
        );

    }

    @Test
    void 게임_종료_우승자_선정_테스트(){
        //given
        carService.initCars(Arrays.asList("seuk", "hi"));

        assertRandomNumberInRangeTest(
                () -> {
                    // when
                    carService.playRound();
                    List<String> cars = carService.getWinners();
                    // then
                    assertThat(cars)
                            .hasSize(1)
                            .containsExactly("seuk");
                },
                MOVING_FORWARD, STOP
        );

    }

    @Test
    void 게임_종료_공동_우승자_선정_테스트(){
        //given
        carService.initCars(Arrays.asList("seuk", "hi"));

        assertRandomNumberInRangeTest(
                () -> {
                    // when
                    carService.playRound();
                    List<String> cars = carService.getWinners();
                    // then
                    assertThat(cars)
                            .hasSize(2)
                            .containsExactly("seuk", "hi");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }



}
