package racingcar.service;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCarServiceTest {
    private RacingCarService racingCarService;

    @Test
    @DisplayName("findWinnersName, getLongestPosition 메소드 정상인 경우")
     void findWinnersName_getLongestPosition_Test() {
        //given
        String[] carNames = {"pobi", "woni", "sall"};
        List<String> carNamesList = new ArrayList<> (Arrays.asList(carNames));
        racingCarService = new RacingCarService();
        racingCarService.createCars(carNamesList);

        //then
        List<String> winnersNames = racingCarService.findWinnersName();
        assertThat(winnersNames).containsAll(carNamesList);
        assertThat(winnersNames.get(0)).isEqualTo("pobi");
    }


    @Test
    @DisplayName("createCars 메소드 실행없이 moveCars 메소드를 실행하면 예외가 발생해야 한다.")
    void moveCars_empty() {
        // expect
        assertThatThrownBy(() -> racingCarService.moveCars())
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("createCars 메소드 실행없이 findWinnersName 메소드를 실행하면 예외가 발생해야 한다.")
    void findWinnersName_Test2() {
        // expect
        assertThatThrownBy(() -> racingCarService.findWinnersName())
                .isInstanceOf(NullPointerException.class);
    }
}
