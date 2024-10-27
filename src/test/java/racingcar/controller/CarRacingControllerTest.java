package racingcar.controller;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarRacingControllerTest {

    @Test
    void 자동차이름_정상_입력_성공() {
        // given
        String carNameInput1 = "pobi, woni, jun";
        String carNameInput2 = " pobi, w o n i, jun. ";
        CarRacingController carRacingController = new CarRacingController();

        // when
        List<String> carNames1 = carRacingController.validateCarNameInput(carNameInput1);
        List<String> carNames2 = carRacingController.validateCarNameInput(carNameInput2);

        // then
        assertThat(carNames1.size()).isEqualTo(3);
        assertThat(carNames1).contains("pobi", "woni", "jun");
        assertThat(carNames2.size()).isEqualTo(3);
        assertThat(carNames2).contains("pobi", "woni", "jun.");

    }

    @Test
    void 자동차이름_공백만_입력하면_예외처리() {
        // given
        String carNameInput = " ";
        CarRacingController carRacingController = new CarRacingController();

        // when, then
        assertThatThrownBy(() -> carRacingController.validateCarNameInput(carNameInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름으로 공백은 불가능합니다.");
    }

    @Test
    void 자동차이름_입력값에_콤마_없으면_예외처리() {
        // given
        String carNameInput1 = "pobi woni jun";
        String carNameInput2 = " pobi woni jun ";
        String carNameInput3 = "pobi.woni.jun";
        CarRacingController carRacingController = new CarRacingController();

        // when, then
        assertThatThrownBy(() -> carRacingController.validateCarNameInput(carNameInput1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 쉼표로 구분합니다. 쉼표를 입력해주세요.");
        assertThatThrownBy(() -> carRacingController.validateCarNameInput(carNameInput2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 쉼표로 구분합니다. 쉼표를 입력해주세요.");
        assertThatThrownBy(() -> carRacingController.validateCarNameInput(carNameInput3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 쉼표로 구분합니다. 쉼표를 입력해주세요.");
    }

    @Test
    void 콤마기준으로_이름이_1개이면_예외처리() {
        // given
        String carNameInput1 = "pobi, ";
        String carNameInput2 = " pobi , ";
        String carNameInput3 = " , pobi ";
        CarRacingController carRacingController = new CarRacingController();

        // when, then
        assertThatThrownBy(() -> carRacingController.validateCarNameInput(carNameInput1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 2개 이상 입력해야합니다.");
        assertThatThrownBy(() -> carRacingController.validateCarNameInput(carNameInput2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 2개 이상 입력해야합니다.");
        assertThatThrownBy(() -> carRacingController.validateCarNameInput(carNameInput3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 2개 이상 입력해야합니다.");
    }

    @Test
    void 공백제외한_자동차이름이_5자초과_예외처리() {
        // given
        String carNameInput1 = "pobi, ohmygod";
        String carNameInput2 = " pobi , w o n i, o h m y god";
        CarRacingController carRacingController = new CarRacingController();

        // when, then
        assertThatThrownBy(() -> carRacingController.validateCarNameInput(carNameInput1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하이어야 합니다: ohmygod");

        assertThatThrownBy(() -> carRacingController.validateCarNameInput(carNameInput2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하이어야 합니다: ohmygod")
                .hasMessageNotContaining("woni");

    }

}