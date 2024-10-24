package racingcar.view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {

    @DisplayName("정상 입력을 받으면 해당 줄을 읽어옴, 자동차 이름 문자열")
    @ParameterizedTest
    @ValueSource(strings = {"ian,delta", "ian, delta, peter", "kevin, ian, peter, rion"})
    void 정상_입력_자동차_이름(String input){
        // Given
        systemIn(input);
        // When
        String result = InputView.readString();
        // then
        Assertions.assertThat(result).isEqualTo(input);
    }

    private void systemIn(final String input){
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}
