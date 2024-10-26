package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static racingcar.utils.InputSplitter.inputSplit;
import static racingcar.utils.InputValidator.*;
import static racingcar.utils.RandomNumberGenerator.generateRandomNumbersForSize;

public class UtilsTest {

    @Test
    @DisplayName("사용자 입력 Splitter 테스트")
    void 사용자_입력_스플리터_TEST(){
        String userInput = "kang,su,min";

        List<String> splitedInputList = inputSplit(userInput);

        Assertions.assertThat(splitedInputList.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"","   "})
    @DisplayName("빈 공백은 자동차 이름이 될 수 없다.")
    void 빈_공백_자동차_이름_불가_TEST(final String carName){
        Assertions.assertThatThrownBy(() -> inputCarsNameValidation(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 공백은 자동차 이름이 될 수 없습니다. 자동차 이름을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1","notNumber", "0"})
    @DisplayName("시도 횟수는 양의 정수여야 한다.")
    void 시도_횟수_양의_정수_TEST(final String carName){
        Assertions.assertThatThrownBy(() -> tryNumberValidation(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 양의 정수입니다. 양의 정수를 입력해 주세요.");
    }

    @ParameterizedTest
    @ValueSource(ints = {3,5,6})
    @DisplayName("특정 개수만큼 난수 생성해 준다.")
    void 특정_개수_난수_생성_TEST(final int size){
        List<Integer> numbers = generateRandomNumbersForSize(size);
        Assertions.assertThat(numbers.size()).isEqualTo(size);
    }
}
