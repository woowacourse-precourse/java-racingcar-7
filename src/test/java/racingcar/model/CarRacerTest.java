package racingcar.model;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;

public class CarRacerTest extends NsTest {

    @ParameterizedTest
    @DisplayName("불가능한 레이서 이름을 확인합니다.")
    @ValueSource(strings = {"", " ", "김수한무와거북이", "반갑습니다람쥐", "하하하하하하"})
    void carRacer_테스트(String input) {
        Assertions.assertThatThrownBy(() -> new CarRacer(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
