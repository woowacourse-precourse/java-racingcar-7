package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CarRacingGameTest {
    private CarRacingGame game;

    @BeforeEach
    public void before() {
        game = new CarRacingGame();
    }

    @ParameterizedTest
    @MethodSource("validInputs")
    @DisplayName("구분자를 기준으로한 자동차 이름 입력 테스트 ")
    public void createCarsFromNames(String carNames,List<String> carNameListInput) {
        List<Car> cars = game.createCarsFromNames(carNames);
        List<String> carNameList = cars.stream().map(Car::getCarName).toList();
        assertTrue(carNameList.containsAll(carNameListInput));
    }

    @MethodSource
    static Stream<Object[]> validInputs() {
        return Stream.of(new Object[]{"poby,win,alex",List.of("poby","win","alex")},
                new Object[]{"jhon,alex,pobby,cat",List.of("jhon","alex","pobby","cat")},
                new Object[]{"jhon,dan,kate,alex,pobby,tom,bob",List.of("jhon","dan","kate","alex","pobby","tom","bob")},
                new Object[]{"jhon,jhon,jhon,jhon,jhon",List.of("jhon","jhon(1)","jhon(2)","jhon(3)","jhon(4)")},
                new Object[]{"jhon1,love2",List.of("jhon1","love2")},
                new Object[]{"변주형","형주변",List.of("변주형","형주변")});
    }
    @MethodSource
    static Stream<Object[]> invalidInputs() {
        return Stream.of(new Object[]{"pobbya","alex",List.of("pobbya","alex")},
                new Object[]{"pobby_,alex",List.of("pobby_","alex")});
    }
}