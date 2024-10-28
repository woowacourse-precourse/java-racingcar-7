package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.Utility;

class ValidatorTest {

    @Test
    @DisplayName("이름을 1개만 입력한 경우")
    void 이름_예외_테스트_1() {
        //given
        String inputCarNames = "qwert";

        //when & then
        assertThatThrownBy(() -> Validator.validateInputCarNamesContainComma(inputCarNames))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @ParameterizedTest
    @ValueSource(strings = {"qwerty", ""})
    @DisplayName("이름이 5자 초과이거나 쉼표 사이에 이름이 입력되지 않은 경우")
    void 이름_예외_테스트_2(String carName) {
        assertThatThrownBy(() -> Validator.validateAllCarNames(carName))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "101"})
    @DisplayName("시도할 횟수가 범위에서 벗어난 경우")
    void 시도_횟수_예외_테스트(int tryCount) {
        assertThatThrownBy(() -> Validator.validateInputCountRange(tryCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("경주 가능한 최대 차 개수를 초과한 경우")
    void 최대_차_개수_초과_테스트() {
        //given
        String inputCarNames = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z";

        //when
        AssertionsForClassTypes.assertThatThrownBy(() -> Utility.getSplitCarNames(inputCarNames))
                .isInstanceOf(IllegalArgumentException.class);

        //then
    }

    @Test
    @DisplayName("이름에 중복이 존재하는 경우")
    void 이름_중복_테스트() {
        //given
        String inputCarNames = "a,a,b";

        //when & then
        AssertionsForClassTypes.assertThatThrownBy(() -> Utility.getSplitCarNames(inputCarNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

}