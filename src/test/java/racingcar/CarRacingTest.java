package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRacingTest {

    CarRacing carRacing;

    @DisplayName("정상 동작 경우")
    @ParameterizedTest
    @CsvSource(value = {"pobi,woni:1", "a:5", "a,b,c:3"}, delimiter = ':')
    void 정상_입력_동작_경우(String inputName, String inputCount) {
        carRacing = new CarRacing(inputName, inputCount);
        carRacing.startRacing();
        assertThat(carRacing.getRecords().size()).isEqualTo(Integer.parseInt(inputCount));
        assertThat(carRacing.getResult().isEmpty()).isEqualTo(false);
        assertThat(carRacing.getResult().matches("최종 우승자 : [^,]{1,5}(,[^,]{1,5})*")).isEqualTo(true);
    }

    @DisplayName("입력 예외인 경우 - 자동차 이름이 올바르지 않은 경우")
    @ParameterizedTest
    @CsvSource(value = {"pobi2222,woni:1", ":1", "java,javaji:3", "a,b,c,:1", "a,,b,c:1"}, delimiter = ':')
    void 예외_이름_입력_동작_경우(String inputName, String inputCount) {
        String name = "";
        if(inputName == null) {
            name = "";
        } else {
            name = inputName;
        }
        carRacing = new CarRacing(name, inputCount);

        assertThatThrownBy(() -> carRacing.startRacing())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 입력이 잘못되었습니다.");
    }

    @DisplayName("입력 예외인 경우 - 올바른 횟수를 입력하지 않은 경우")
    @ParameterizedTest
    @CsvSource(value = {"pobi,woni:", "pobi:1a", "java,pobi:aacv", "a,b,c:-123"}, delimiter = ':')
    void 예외_횟수_입력_동작_경우(String inputName, String inputCount) {
        String count = "";
        if(inputCount == null) {
            count = "";
        } else {
            count = inputCount;
        }
        carRacing = new CarRacing(inputName, count);

        assertThatThrownBy(() -> carRacing.startRacing())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 횟수를 입력했습니다.");
    }
}
