package racingcar;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRaceViewTest extends SimpleNsTest {

    @Test
    void diplayUserInput() {
        run("pobi, woni, jun", "2");
        UserRaceSettingDto userInput = CarRaceView.receiveRaceInfoFromUser();
        Assertions.assertThat(userInput.carNames()).isEqualTo("pobi, woni, jun");
        Assertions.assertThat(userInput.tryRace()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차 경주 상태 출력을 성공한다.")
    void displayRaceStatus() {
        final Map<String, Integer> raceStatus1 = new LinkedHashMap<>();
        raceStatus1.put("pobi", 5);
        raceStatus1.put("woni", 5);
        raceStatus1.put("jun", 4);

        CarRaceView.displayRaceStatus(raceStatus1);
        Assertions.assertThat(output()).contains("pobi : -----\n", "woni : -----\n", "jun : ----");
    }

    @Test
    void displayWinningCar() {
        CarRaceView.displayWinningCar(List.of("pobi", "woni"));
        Assertions.assertThat(output()).contains("최종 우승자 : pobi, woni");
    }

    @Override
    public void runMain() {
    }
}