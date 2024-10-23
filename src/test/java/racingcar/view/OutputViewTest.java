package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.CarMovementResults;

public class OutputViewTest {

    private OutputView outputView;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputView = OutputView.getInstance();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("실행 결과 출력 시 의도한 형식대로 출력되도록 해라")
    void shouldDisplayResultInExpectedFormat() {
        // given
        List<CarMovementResults> carMovementResults = List.of(
                CarMovementResults.from(new LinkedHashMap<>() {{
                    put("pobi", 3);
                    put("juni", 2);
                }}),
                CarMovementResults.from(new LinkedHashMap<>() {{
                    put("pobi", 4);
                    put("juni", 3);
                }})
        );

        // when
        outputView.displayMovementResults(carMovementResults);

        // then
        assertThat(outputStream.toString()).isEqualTo(
                "실행 결과\npobi : ---\njuni : --\n\npobi : ----\njuni : ---\n\n");
    }
}
