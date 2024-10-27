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

}