package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ApplicationTest {

    private Application app;

    @BeforeEach
    public void setUp() {
        app = new Application();
    }

    @Test
    public void initTest() {
        String input = "car1,car2,car3";
        app.init(input);

        HashMap<String, Integer> expectedCarPositions = new HashMap<>();
        expectedCarPositions.put("car1", 0);
        expectedCarPositions.put("car2", 0);
        expectedCarPositions.put("car3", 0);

        assertThat(app.getCarPositions()).containsAllEntriesOf(expectedCarPositions);
    }

    @Test
    public void moveCarTest() {
        String input = "car1";
        app.init(input);

        app.moveCar("car1", 5); // 5를 전달하여 이동이 발생하도록 함
        int positionAfterMove = app.getCarPositions().get("car1");

        assertThat(positionAfterMove).isEqualTo(1);

        app.moveCar("car1", 3); // 3을 전달하여 이동하지 않도록 함
        positionAfterMove = app.getCarPositions().get("car1");

        assertThat(positionAfterMove).isEqualTo(1);
    }

    @Test
    public void checkWinnerTest() {
        String input = "car1,car2";
        app.init(input);

        app.getCarPositions().put("car1", 2);
        app.getCarPositions().put("car2", 1);

        // checkWinner 메서드는 우승자를 출력하는데, 실제 테스트에서는 리팩토링하여
        // 반환값으로 우승자 목록을 리턴하도록 변경하는 것이 좋음
        app.checkWinner();
    }

    @Test
    public void init_withEmptyInput_shouldThrowException() {
        assertThatThrownBy(() -> app.init(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 입력입니다. 자동차 이름을 입력해 주세요.");
    }

    @Test
    public void init_withBlankCarName_shouldThrowException() {
        assertThatThrownBy(() -> app.init("car1,,car3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 공백일 수 없습니다.");
    }

    @Test
    public void init_withNullInput_shouldThrowException() {
        assertThatThrownBy(() -> app.init(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 입력입니다. 자동차 이름을 입력해 주세요.");
    }

    @Test
    public void checkWinner_withMultipleWinners() {
        String input = "pobi,woni,jun";
        app.init(input);

        // 각 자동차의 이동 거리를 설정하여 pobi와 jun이 동점으로 우승
        app.getCarPositions().put("pobi", 5);
        app.getCarPositions().put("woni", 4);
        app.getCarPositions().put("jun", 5);

        // 실제로 checkWinner() 메서드가 출력 대신 우승자를 리턴하도록 리팩터링하면
        // 리턴된 값을 통해 검증이 가능함
        app.checkWinner();

        // 우승자 검증 로직을 통해 pobi와 jun이 우승자로 선택되었는지 확인할 수 있어야 함
    }
}
