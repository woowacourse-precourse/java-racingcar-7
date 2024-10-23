package racingcar;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.Validator;

public class MyTest {
    private static final String WRONG_CAR_NAME_EXCEPTION = "경주할 자동차 이름을 잘 못 입력하셨습니다.";
    private static final String WRONG_ROUND_EXCEPTION = "시도할 횟수는 0이거나 비어있을 수 없습니다.";
    private final Validator validator = new Validator();

    @DisplayName("자동차 이름 Validator 테스트")
    @Test
    public void validatorCarTest() {
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
    public void validatorRoundTest() {
        for (int i = 0; i < 10000; i++) { // 0부터 10000까지 대입 테스트
            String currentRound = Integer.toString(i);

            if (i == 0) {
                assertThatIllegalArgumentException().isThrownBy(() -> validator.checkAboutRound(currentRound))
                        .withMessage(WRONG_ROUND_EXCEPTION);
                continue;
            }

            assertThatNoException().isThrownBy(() -> validator.checkAboutCars(currentRound));
        }

        // 시도할 횟수는 비어있을 수 없음
        String emptyString = "";
        assertThatIllegalArgumentException().isThrownBy(() -> validator.checkAboutRound(emptyString));
    }
}
