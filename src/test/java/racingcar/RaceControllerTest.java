package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RaceControllerTest {
    private RaceController raceController;

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
    }

    @Test
    void 각_라운드에서_자동차_전진_여부_결정_및_위치_업데이트() {
        raceController.playRound();

        List<Car> cars = raceController.getCars();

        for (Car car : cars) {
            int position = car.getPosition();
            System.out.println(car.getName() + " 위치: " + position); // 위치를 콘솔로 출력해 확인
        }
    }
}
