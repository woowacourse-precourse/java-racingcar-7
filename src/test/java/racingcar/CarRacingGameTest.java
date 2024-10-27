package racingcar;

import org.assertj.core.api.ThrowableAssert;
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
    @DisplayName("올바른 입력에 대한 테스트")
    public void createCarsFromNames(String carNames,List<String> carNameListInput) {
        List<Car> cars = game.createCarsFromNames(carNames);
        List<String> carNameList = cars.stream().map(Car::getCarName).toList();
        assertTrue(carNameList.containsAll(carNameListInput));
    }
    @ParameterizedTest
    @MethodSource("invalidInputs")
    @DisplayName("예외 테스트")
    public void createCarsFromNames(String carNames) {
        org.assertj.core.api.Assertions.assertThatThrownBy(() -> game.createCarsFromNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @MethodSource
    static Stream<Object[]> validInputs() {
        return Stream.of(new Object[]{"poby,win,alex",List.of("poby","win","alex")},
                new Object[]{"jhon,alex,pobby,cat",List.of("jhon","alex","pobby","cat")},
                new Object[]{"jhon,dan,kate,alex,pobby,tom,bob",List.of("jhon","dan","kate","alex","pobby","tom","bob")},
                new Object[]{"jhon,jhon,jhon,jhon,jhon",List.of("jhon","jhon(1)","jhon(2)","jhon(3)","jhon(4)")},
                new Object[]{"jhon1,love2",List.of("jhon1","love2")},
                new Object[]{"변주형,형주변",List.of("변주형","형주변")});
    }
    @MethodSource
    static Stream<Object[]> invalidInputs() {
        return Stream.of(new Object[]{"pobbya","alex"},//6글자
                new Object[]{"pobby_,alex"},
                new Object[]{"^@&,alex"},
                new Object[]{"alex"},
                new Object[]{"alex^jhon"},
                new Object[]{""},
                new Object[]{" "},
                new Object[]{"alex ,hello"},
                new Object[]{",alex,car"},
                new Object[]{"jhon, alex"},
                new Object[]{",asdf,dsaf,a"});
    }
}