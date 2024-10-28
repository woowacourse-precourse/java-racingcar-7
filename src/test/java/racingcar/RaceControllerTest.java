package racingcar;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

public class RaceControllerTest {

    @Test
    void 자동차_이름_유효성_검증_테스트() {
        RaceController controller = new RaceController();

        List<String> validNames = controller.parseAndValidateCarNames("pobi,crong,honux");
        assertEquals(List.of("pobi", "crong", "honux"), validNames);

        assertThrows(IllegalArgumentException.class, () -> {
            controller.parseAndValidateCarNames("pobi,tooLongName,honux");
        });
    }
}
