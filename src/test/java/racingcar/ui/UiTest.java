package racingcar.ui;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.junit.jupiter.api.Test;

public class UiTest {
    @Test
    void 레이서_입력_테스트(){
        InputStream readLine = new ByteArrayInputStream("pobi,woni,jun".getBytes());
        System.setIn(readLine);

        UI ui = new UI();
        String string = ui.getRacerName();

        assertThat("pobi,woni,jun").isEqualTo(string);
    }

    @Test
    void 레이싱수_입력_테스트(){
        InputStream readLine = new ByteArrayInputStream("5".getBytes());
        System.setIn(readLine);

        UI ui = new UI();
        int times = ui.getRacingTimes();

        assertThat(5).isEqualTo(times);
    }

    @Test
    void 레이싱수_예외_테스트(){
        InputStream readLine = new ByteArrayInputStream("ten".getBytes());
        System.setIn(readLine);
        UI ui = new UI();

        assertThatThrownBy(ui::getRacingTimes)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
