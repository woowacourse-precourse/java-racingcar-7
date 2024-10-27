package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.mock.model.dependency.validator.MockedRacingCarValidator;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RacingCar 테스트")
public class RacingCarTest {

    // Mock
    private final MockedRacingCarValidator mockedRacingCarValidator = new MockedRacingCarValidator();

    // Variables
    private final String name = "abc";

    /*
        매 테스트마다 초기화
        RacingCarValidator 의 상태를 초기화한 후, validateName() 의 결과를 true 로 설정
     */
    @BeforeEach
    void clear() {
        mockedRacingCarValidator.clear();
        mockedRacingCarValidator.setIsValidateNameWillPass(true);
    }

    @Test
    void 생성_시_검증이_수행된다() {

        // when
        new RacingCar(name, mockedRacingCarValidator);

        // then
        assertThat(mockedRacingCarValidator.isValidateCalled()).isTrue();
    }

    @Test
    void 복사생성자_호출_시_검증이_수행된다() {

        // given
        RacingCar racingCar = new RacingCar(name, mockedRacingCarValidator);

        // when
        new RacingCar(racingCar);

        // then
        assertThat(mockedRacingCarValidator.isValidateCalled()).isTrue();
    }

    @Test
    void 생성_시_위치가_기본_위치로_설정된다() {

        // when
        RacingCar racingCar = new RacingCar(name, mockedRacingCarValidator);

        // then
        assertThat(racingCar.getPosition()).isEqualTo(racingCar.DEFAULT_POSITION);
    }

    @Test
    void 움직일_수_있다면_움직인다() {

        // given
        RacingCar racingCar = new RacingCar(name, mockedRacingCarValidator);
        int beforePosition = racingCar.getPosition();

        // when
        racingCar.move(racingCar.MIN_MOVEABLE_NUMBER + 1);

        // then
        assertThat(racingCar.getPosition()).isNotEqualTo(beforePosition);
    }

    @Test
    void 움직일_수_없다면_움직이지_않는다() {

        // given
        RacingCar racingCar = new RacingCar(name, mockedRacingCarValidator);
        int beforePosition = racingCar.getPosition();

        // when
        racingCar.move(racingCar.MIN_MOVEABLE_NUMBER - 1);

        // then
        assertThat(racingCar.getPosition()).isEqualTo(beforePosition);
    }

    @Test
    void 이름과_위치가_같다면_같은_객체이다() {

        // when
        RacingCar racingCar1 = new RacingCar(name, mockedRacingCarValidator);
        RacingCar racingCar2 = new RacingCar(name, mockedRacingCarValidator);

        // then
        assertThat(racingCar1.getName()).isEqualTo(racingCar2.getName());
        assertThat(racingCar1.getPosition()).isEqualTo(racingCar2.getPosition());
    }
}
