package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.strategy.MoveStrategy;
import racingcar.car.strategy.RandomMoveStrategy;
import racingcar.util.TestNumberGenerator;
import racingcar.util.Validator;

public class MyTest {
    private static final String WRONG_CAR_NAME_EXCEPTION = "경주할 자동차 이름을 잘 못 입력하셨습니다.";
    private static final String WRONG_ROUND_EXCEPTION = "시도할 횟수는 0이거나 비어있을 수 없습니다.";
    private static final int RANDOM_VALUE_THAT_MOVE = 4;
    private static final int RANDOM_VALUE_THAT_STOP = 3;
    private static final int MOVE_ONCE = 1;
    private static final int STOP = 0;

    @DisplayName("자동차 이름 Validator 테스트")
    @Test
    public void 자동차_이름_예외_테스트() {
        String[] validCars = {
                "John,Doe",
                "abc, def, ghi",
                "A, B, C, D",
                "car1, car2, car3",
                "car1 , car2",
                "abc,def",
                "one,two,three,four",
                "123, 456, 789",
                "hyun, oh, yeeun, genre, pobi,abc,def,acdc,11123,aaddd"
        };

        String[] invalidCars = {
                "abcdef,GHI",
                "abc, def,",
                " ,abc",
                "abc,,def",
                ", ",
                "abc def",
                "abc,def,ghi,jklmnb",
                "  , ",
                "abc,,",
                " , ",
                "test0 , test2, korean "
        };

        final Validator validator = new Validator();
        for (String cars : validCars) {
            assertThatNoException().isThrownBy(() -> validator.checkAboutCars(cars));
        }
        for (String cars : invalidCars) {
            assertThatIllegalArgumentException().isThrownBy(() -> validator.checkAboutCars(cars))
                    .withMessage(WRONG_CAR_NAME_EXCEPTION);
        }
    }

    @DisplayName("시도할 횟수 Validator 테스트")
    @Test
    public void 게임_시도횟수_예외_테스트() {
        final Validator validator = new Validator();

        for (int i = -1; i < 10; i++) { // -1부터 10까지 대입 테스트
            String currentRound = Integer.toString(i);

            if (i <= 0) {
                assertThatIllegalArgumentException().
                        isThrownBy(() -> validator.checkAboutRound(currentRound))
                        .withMessage(WRONG_ROUND_EXCEPTION);

                continue;
            }
            assertThatNoException().isThrownBy(() -> validator.checkAboutRound(currentRound));
        }

        // 빈 값 대입 테스트
        String emptyString = "";
        assertThatIllegalArgumentException().isThrownBy(() -> validator.checkAboutRound(emptyString));
    }

    @DisplayName("무작위 값에 따른 정지")
    @Test
    void 무작위_값_정지_테스트() {
        // given - 테스트 값 준비
        MoveStrategy moveStrategy = new RandomMoveStrategy(new TestNumberGenerator(RANDOM_VALUE_THAT_STOP));

        // when - 실제 테스트
        int actualResult = moveStrategy.getPossibleMoveAmount();

        // then - 검증
        assertThat(actualResult).isEqualTo(STOP);
    }

    @DisplayName("무작위 값에 따른 전진")
    @Test
    void 무작위_값_전진_테스트() {
        // given
        MoveStrategy moveStrategy = new RandomMoveStrategy(new TestNumberGenerator(RANDOM_VALUE_THAT_MOVE));

        // when
        int actualResult = moveStrategy.getPossibleMoveAmount();

        // then
        assertThat(actualResult).isEqualTo(MOVE_ONCE);
    }

    @DisplayName("자동차 위치 정지")
    @Test
    void 자동차_정지_테스트() {

    }

    @DisplayName("자동차 위치 전진")
    @Test
    void 자동차_전진_테스트() {

    }

    @DisplayName("자동차 현황 출력")
    @Test
    void 자동차_현황_출력_테스트() {

    }

    @DisplayName("레이싱 단독 우승자 출력")
    @Test
    void 레이싱_단독_우승자_출력_테스트() {

    }

    @DisplayName("레이싱 공동 우승자 출력")
    @Test
    void 레이싱_공동_우승자_출력_테스트() {

    }
}
