package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RaceControllerTest {
    private RaceController raceController;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Test
    void 자동차_이름_유효성_검증_테스트() {
        RaceController controller = new RaceController();

        List<String> validNames = controller.parseAndValidateCarNames("pobi,crong,honux");
        assertEquals(List.of("pobi", "crong", "honux"), validNames);

        assertThrows(IllegalArgumentException.class, () -> {
            controller.parseAndValidateCarNames("pobi,tooLongName,honux");
        });
    }

    @BeforeEach
    void setup() {
        raceController = new RaceController();
        raceController.parseAndValidateCarNames("pobi,crong,honux");

        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void 각_라운드에서_자동차_전진_여부_결정_및_위치_업데이트() {
        raceController.playRound();

        List<Car> cars = raceController.getCars();

        for (Car car : cars) {
            int position = car.getPosition();
            System.out.println(car.getName() + " 위치: " + position);
        }
    }

    @Test
    void 경주_시도_횟수에_따라_자동차_상태와_출력_형식_확인() {
        raceController.startRace(5);

        String output = outputStream.toString();

        assertTrue(output.contains("실행 결과"));

        List<Car> cars = raceController.getCars();
        for (Car car : cars) {
            assertTrue(output.contains(car.getName() + " : "));
        }

        int resultCount = output.split("pobi : ").length - 1;
        assertTrue(resultCount == 5, "시도 횟수만큼의 결과가 출력되어야 합니다.");
    }
}
