package racingcar.dto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.mock.model.dependency.validator.MockedRacingCarValidator;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RacingResult 테스트")
public class RacingResultTest {

    private static final MockedRacingCarValidator racingCarValidator = new MockedRacingCarValidator();

    private static RacingCars racingCars;


    @BeforeAll
    static void setUp() {
        racingCarValidator.clear();
        racingCarValidator.setIsValidateNameWillPass(true);

        List<RacingCar> cars = List.of(
                new RacingCar("a", racingCarValidator),
                new RacingCar("b", racingCarValidator),
                new RacingCar("c", racingCarValidator)
        );

        racingCars = new RacingCars(cars);
    }

    /*
        매 테스트마다 초기화
        MockedRacingCarValidator 의 상태를 초기화한 후, validateName() 의 결과를 true 로 설정
     */
    @BeforeEach
    void clear() {
        racingCarValidator.clear();
        racingCarValidator.setIsValidateNameWillPass(true);
    }

    @Test
    @DisplayName("winners() : 승리자_객체를_복사해_반환한다")
    void 승리자_객체를_복사해_반환한다() {

        // given
        int expected = System.identityHashCode(racingCars);
        RacingResult racingResult = new RacingResult(List.of(), racingCars);

        // when
        int actual = System.identityHashCode(racingResult.winners());

        // then
        assertThat(actual).isNotEqualTo(expected);
    }
}
