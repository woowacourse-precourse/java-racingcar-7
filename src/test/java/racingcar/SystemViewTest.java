package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SystemViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;
    private SystemView systemView;

    @BeforeEach
    void setUp() {
        // 출력 스트림을 가로채기 위해 System.out 재설정
        System.setOut(new PrintStream(outContent));
        systemView = new SystemView();


    }

    @AfterEach
    void tearDown() {
        // 테스트가 끝난 후 원래 출력 스트림으로 복원
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    @DisplayName("이름 입력 안내 문구 출력 후 입력")
    void printSystemNameInputMessageTest() {
        //given
        String input = "pobi";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        //when
        String result = systemView.printSystemNameInputMessage();
        //then
        assertThat(outContent.toString()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        assertThat(result).isEqualTo("pobi");
    }


}