package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.assertj.core.api.Assertions.*;

/**
 * @author ddaerae
 * @since 2024-10-23
 * 자동차 관련 기능을 테스트하는 클래스
 */
class CarTest {

    @Test
    @DisplayName("주어진 라이브러리의 함수가 원하는 값을 리턴하는지")
    void 라이브러리_테스트() {
        assertDoesNotThrow(() -> {
            int[] ranNumArray = new int[30];
            for (int i = 0; i < 30; i++) {
                int ranNum = Randoms.pickNumberInRange(0, 9);
                ranNumArray[i] = ranNum;
            }

            for (int i = 0; i < 30; i++) {
                if (ranNumArray[i] > 9 || ranNumArray[i] < 0) {
                    throw new IllegalArgumentException("설정하지마!");
                }
            }
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {0,3,4,5})
    @DisplayName("4 이상이면 - 기호 리턴, 아니면 공백리턴")
    void 전진_기호_리턴(int ranNum) {
        String result;
        if(ranNum >= 4){
            result = "-";
        }else{
            result = "";
        }

        if (ranNum >= 4) {
            assertThat(result).isEqualTo("-");
        }else{
            assertThat(result).isEmpty();
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {9, 8, 7, 6, 5, 4, 3, 2, 1})
    @DisplayName("차량의 전진 OR 정지 판단")
    void 전진_아니면_정지(int number) {

        String result = new String();

        result += Car.goOrStop(number);

        if(number >= 4)
            assertThat(result).isEqualTo("-");
        else
            assertThat(result).isEmpty();
    }

}
