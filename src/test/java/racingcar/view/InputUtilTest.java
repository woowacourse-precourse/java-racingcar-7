package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.InputUtil;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputUtilTest {

    @Test
    @DisplayName("',' 기준으로 이름 파싱 성공")
    void validateSuccess() {
        List<String> names = InputUtil.parseNames("abc,hijk");
        assertThat(names.size()).isEqualTo(2);
        assertThat(names.get(0)).isEqualTo("abc");
        assertThat(names.get(1)).isEqualTo("hijk");
    }

    @Test
    @DisplayName("',' 사이 앞뒤 공백 자른 후 저장")
    void validateBlankSuccess() {
        List<String> names = InputUtil.parseNames(" abc, hijk,lmn");
        assertThat(names.size()).isEqualTo(3);
        assertThat(names.get(0)).isEqualTo("abc");
        assertThat(names.get(1)).isEqualTo("hijk");
        assertThat(names.get(2)).isEqualTo("lmn");
    }
}