package racingcar.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarDto;

public class ProgressViewTest {
    ProgressView progressView;

    @BeforeEach
    void init() {
        progressView = new ProgressView();
    }

    @Test
    void 안내_문구_출력() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        progressView.printFirstProgressMessage();

        assertThat(outputStream.toString().trim())
                .isEqualTo("실행 결과");
    }

    @Test
    void 자동차들의_이동거리_출력() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        List<CarDto> carDtoList = Arrays.asList(
                new CarDto("pobi", 2),
                new CarDto("woni", 4),
                new CarDto("jun", 3)
        );

        progressView.printProgressMessage(carDtoList);

        assertThat(outputStream.toString().trim())
                .contains("pobi : --", "woni : ----", "jun : ---");

    }
}
