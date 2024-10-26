package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @Test
    void TDD_자동차_이름_5자_이하_성공() {
        //given
        String input = "java";

        //when
        RacingCar racingCar = new RacingCar(input);

        //then
        assertThat(racingCar.getName()).isEqualTo(input);
    }

    @Test
    void TDD_자동차_이름_공백포함_5자_이하_성공() {
        //given
        String input = "java    ";

        //when
        RacingCar racingCar = new RacingCar(input);

        //then
        assertThat(racingCar.getName()).isEqualTo("java");
    }

    @Test
    void TDD_자동차_이름_5자_초과_실패() {
        //given
        String input = "discphy";

        //when
        assertThatThrownBy(() -> new RacingCar(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void TDD_자동차_이름_빈_문자열_실패() {
        //given
        String input = " ";

        //when
        assertThatThrownBy(() -> new RacingCar(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void TDD_자동차_전진_성공() {
        //given
        RacingCar pobi = new RacingCar("pobi");
        int input = 5;

        //when
        pobi.move(input);

        //then
        assertThat(pobi.getPosition()).isEqualTo(1);
    }

    @Test
    void TDD_자동차_멈춤_성공() {
        //given
        RacingCar pobi = new RacingCar("pobi");
        int input = 3;

        //when
        pobi.move(input);

        //then
        assertThat(pobi.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차_전진_실패() {
        //given
        RacingCar pobi = new RacingCar("pobi");
        int input = 10;

        //when
        assertThatThrownBy(() -> pobi.move(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
