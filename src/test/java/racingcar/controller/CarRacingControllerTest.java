package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.global.Exception.CarNameException.DuplicatedCarNameException;
import racingcar.global.Exception.CarNameException.EmptyCarNameException;
import racingcar.global.Exception.CarNameException.InsufficientCarNamesException;
import racingcar.global.Exception.CarNameException.LongCarNameException;
import racingcar.global.Exception.TotalRoundException.EmptyTotalRoundException;
import racingcar.global.Exception.TotalRoundException.InvalidTotalRoundFormatException;
import racingcar.global.Exception.TotalRoundException.NonPositiveRoundException;

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
        String carNameInput1 = " ";
        String carNameInput2 = " ";
        CarRacingController carRacingController = new CarRacingController();

        // when, then
        assertThatThrownBy(() -> carRacingController.validateCarNameInput(carNameInput1))
                .isInstanceOf(EmptyCarNameException.class);
        assertThatThrownBy(() -> carRacingController.validateCarNameInput(carNameInput2))
                .isInstanceOf(EmptyCarNameException.class);
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
                .isInstanceOf(InsufficientCarNamesException.class);
        assertThatThrownBy(() -> carRacingController.validateCarNameInput(carNameInput2))
                .isInstanceOf(InsufficientCarNamesException.class);
        assertThatThrownBy(() -> carRacingController.validateCarNameInput(carNameInput3))
                .isInstanceOf(InsufficientCarNamesException.class);
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
                .isInstanceOf(InsufficientCarNamesException.class);
        assertThatThrownBy(() -> carRacingController.validateCarNameInput(carNameInput2))
                .isInstanceOf(InsufficientCarNamesException.class);
        assertThatThrownBy(() -> carRacingController.validateCarNameInput(carNameInput3))
                .isInstanceOf(InsufficientCarNamesException.class);
    }

    @Test
    void 공백제외한_자동차이름이_5자초과_예외처리() {
        // given
        String carNameInput1 = "pobi, ohmygod";
        String carNameInput2 = " pobi , w o n i, o h m y god";
        CarRacingController carRacingController = new CarRacingController();

        // when, then
        assertThatThrownBy(() -> carRacingController.validateCarNameInput(carNameInput1))
                .isInstanceOf(LongCarNameException.class);
        assertThatThrownBy(() -> carRacingController.validateCarNameInput(carNameInput2))
                .isInstanceOf(LongCarNameException.class);
    }

    @Test
    void 자동차이름_중복되면_예외처리() {
        // given
        String carNameInput1 = "pobi, pobi";
        String carNameInput2 = "po bi, p o b i";
        CarRacingController carRacingController = new CarRacingController();

        // when, then
        assertThatThrownBy(() -> carRacingController.validateCarNameInput(carNameInput1))
                .isInstanceOf(DuplicatedCarNameException.class);
        assertThatThrownBy(() -> carRacingController.validateCarNameInput(carNameInput2))
                .isInstanceOf(DuplicatedCarNameException.class);
    }

    @Test
    void 시도횟수_입력이_공백이면_예외처리() {
        // given
        String roundInput1 = " ";
        String roundInput2 = "";
        System.out.println(String.join("\n", "pobi,jun", " "));
        System.out.println("-----------------------------------");
        System.out.println(String.join("\n", "pobi,jun", ""));
        System.out.println("-----------------------------------");
        System.out.println(String.join("\n", "pobi,jun", null));

        byte[] bytes1 = String.join("\n", "pobi,jun", "").getBytes();
        byte[] bytes2 = String.join("\n", "pobi,jun", null).getBytes();

        System.out.println(bytes1.length);
        System.out.println(bytes2.length);

        boolean areEqual = Arrays.equals(bytes1, bytes2);
        System.out.println("bytes1과 bytes2는 같습니까? " + areEqual);
        System.out.println();
        System.out.println("-----------------------------------");

        CarRacingController carRacingController = new CarRacingController();

        // when, then
        assertThatThrownBy(() -> carRacingController.validateTotalRoundInput(roundInput1))
                .isInstanceOf(EmptyTotalRoundException.class);
        assertThatThrownBy(() -> carRacingController.validateTotalRoundInput(roundInput2))
                .isInstanceOf(EmptyTotalRoundException.class);
    }

    @Test
    void 시도횟수가_정수로_변환불가능한_형태이면_예외처리() {
        // given
        String roundInput1 = "1 0 5";
        String roundInput2 = "88&*7";
        CarRacingController carRacingController = new CarRacingController();

        // when
        assertThatThrownBy(() -> carRacingController.validateTotalRoundInput(roundInput1))
                .isInstanceOf(InvalidTotalRoundFormatException.class);
        assertThatThrownBy(() -> carRacingController.validateTotalRoundInput(roundInput2))
                .isInstanceOf(InvalidTotalRoundFormatException.class);
    }

    @Test
    void 시도횟수가_0이거나_음수이면_예외처리() {
        // given
        String roundInput1 = "0";
        String roundInput2 = "-2";
        CarRacingController carRacingController = new CarRacingController();

        // when, then
        assertThatThrownBy(() -> carRacingController.validateTotalRoundInput(roundInput1))
                .isInstanceOf(NonPositiveRoundException.class);
        assertThatThrownBy(() -> carRacingController.validateTotalRoundInput(roundInput2))
                .isInstanceOf(NonPositiveRoundException.class);
    }
}