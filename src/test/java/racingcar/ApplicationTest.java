package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest {

    void clearInputStream() {
        System.setIn(new ByteArrayInputStream(new byte[0])); // 빈 스트림으로 설정
    }

    @Test
    void 올바른_이름_입력() {
        // given
        String input = "car1,car2,car3\n"; // Console 입력을 위해 줄바꿈 추가
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        String result = Application.getName();

        // then
        assertThat(result).isEqualTo(input.trim());
    }

    @Test
    void 올바르지_않은_이름_입력() {
        // given
        String input = ""; // 빈 문자열 입력
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when & then
        assertThatThrownBy(Application::getName)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 공백이거나, 구분자가 없거나, 구분자로만 입력되어 있습니다.");
    }

    @Test
    void 올바른_숫자_입력() {
        // given
        String input = "5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        String result = Application.getNum();

        // then
        assertThat(result).isEqualTo("5");
    }

    @Test
    void 올바르지_않은_숫자_입력() {
        // given
        String input = "0\n"; // 0 입력
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when & then
        assertThatThrownBy(Application::getNum)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수 혹은 0은 입력할 수 없습니다.");
    }

    @Test
    void result_allCarsTied_printsTiedMessage() {
        // given
        String[] nameList = {"car1", "car2", "car3"};
        int num = 3;

        // when
        Application.result(nameList, num);

        //then 결과출력

    }
}
