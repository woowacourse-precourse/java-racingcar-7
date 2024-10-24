package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RaceReadyTest {

    @Test
    void 레이싱_준비_객체_생성() {
        //given
        String input = "audi,benz,bmw,kia";
        String n = "5";

        //when
        RaceReady raceReady = new RaceReady(input, n);

        //then
        assertThat(raceReady.getNameInput()).isEqualTo(input);
        assertThat(raceReady.getNumberOfTime()).isEqualTo(5);

    }

    @Test
    void 레이싱_준비_객체_실패_시도횟수0() {
        //given
        String input = "audi,benz,bmw,kia";
        String n = "0";

        //then
        assertThrows(IllegalArgumentException.class, () -> new RaceReady(input, n));
    }

    @Test
    void 레이싱_준비_객체_실패_시도횟수음수() {
        //given
        String input = "audi,benz,bmw,kia";
        String n = "-3";

        //then
        assertThrows(IllegalArgumentException.class, () -> new RaceReady(input, n));
    }

    @Test
    void 레이싱_준비_객체_실패_시도횟수정수아님() {
        //given
        String input = "audi,benz,bmw,kia";
        String n = "times";

        //then
        assertThrows(IllegalArgumentException.class, () -> new RaceReady(input, n));
    }


}