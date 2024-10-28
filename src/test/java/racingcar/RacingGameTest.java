package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {
    private RacingGame racingGame;
    private CarNameParser carNameParser;
    private AttemptCountParser attemptCountParser;

    @BeforeEach
    public void RacingGameTest(){
        carNameParser = new CarNameParser();
        attemptCountParser = new AttemptCountParser();
        racingGame = new RacingGame(carNameParser, attemptCountParser);
    }

    @Test
    @DisplayName("입력된 자동차 이름 만큼 자동차 객체가 생성되고 자동차 리스트 필드에 저장되는지 테스트")
    public void 자동차_객체_생성_테스트(){
        //given
        List<String> carNames = Arrays.asList("car1", "car2");
        //when
        racingGame.addCars(carNames);
        List<Car> cars = racingGame.getCars();

        //then
        Assertions.assertThat(cars)
                .extracting(Car::getName)
                .containsExactlyElementsOf(carNames);
    }

    @Test
    @DisplayName("랜덤값이 4 이상이라고 가정했을때 Car 객체의 moveCount값이 증가하는지 테스트")
    public void 랜덤값__4이상_자동차_전진_테스트(){
        //given
        Car car = new Car("car1");
        int randomNumber = 4;
        int expectedMoveCount = 5;

        //when
        for(int i = 0; i < 5; i ++){
            car.move(randomNumber);
        }

        //then
        Assertions.assertThat(car.getMoveCount()).isEqualTo(expectedMoveCount);

    }

    @Test
    @DisplayName("랜덤값이 4 미만이라고 가정했을때 Car 객체의 moveCount값이 증가하는지 테스트")
    public void 랜덤값_4미만_자동차_전진_예외테스트(){
        //given
        Car car = new Car("car1");
        int randomNumber = 3;
        int expectedMoveCount = 0;

        //when
        for(int i = 0; i < 5; i ++){
            car.move(randomNumber);
        }

        //then
        Assertions.assertThat(car.getMoveCount()).isEqualTo(expectedMoveCount);
    }

    @Test
    @DisplayName("AttemptCount 만큼 RacingGame의 Car들이 전진하는지 테스트")
    public void 시도횟수_만큼_모든_자동차_전진_테스트(){
        //given
        List<String> carNames = Arrays.asList("car1", "car2", "car3");
        racingGame.addCars(carNames);
        int attemptCount = 5;   // 반복 시도 횟수
        int randomNumber = 4; // 항상 전진

        //when
        racingGame.raceByAttemptCount(attemptCount, randomNumber);
        List<Car> cars = racingGame.getCars();

        //then
        for(int i = 0; i < 3; i++){
            Assertions.assertThat(cars.get(i).getMoveCount()).isEqualTo(attemptCount);
        }
    }


    @Test
    @DisplayName("moveCount 가 가장 높은 자동차 들이 우승")
    public void 단독_우승_확인_테스트(){
        //given
        List<String> carNames = Arrays.asList("car1", "car2", "car3");
        racingGame.addCars(carNames);
        List<Car> cars = racingGame.getCars();
        List<String> expectedWinners = Arrays.asList("car1");

        cars.get(0).move(4);
        //when
        List<String> actualWinners = racingGame.getWinners();
        //then
        Assertions.assertThat(actualWinners).isEqualTo(expectedWinners);
    }

    @Test
    @DisplayName("moveCount 가 가장 높은 자동차 들이 우승")
    public void 공동_우승_확인_테스트(){
        //given
        List<String> carNames = Arrays.asList("car1", "car2", "car3");
        racingGame.addCars(carNames);
        List<Car> cars = racingGame.getCars();
        List<String> expectedWinners = Arrays.asList("car1", "car2");

        cars.get(0).move(4);
        cars.get(1).move(4);
        //when
        List<String> actualWinners = racingGame.getWinners();
        //then
        Assertions.assertThat(actualWinners).isEqualTo(expectedWinners);
    }
}