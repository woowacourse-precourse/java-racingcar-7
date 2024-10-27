package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RacingCarTest {
    @Test
    void 이름이_모두_영어일때_정상() {
        RacingCar racingCar = new RacingCar("abc");

        assertEquals("abc", racingCar.name());
    }

    @Test
    void 이름이_같을때_같은_객체() {
        RacingCar racingCar = new RacingCar("abc");
        RacingCar racingCar2 = new RacingCar("abc");

        assertEquals(racingCar.hashCode(), racingCar2.hashCode());
        assertEquals(racingCar, racingCar2);
    }

    @Test
    void 이름_길이가_5_이상일때_오류발생() {
        assertThatThrownBy(() -> new RacingCar("abcbcddds")).hasMessage("이름은 5자 이하만 가능합니다.");
        assertThatThrownBy(() -> new RacingCar("1231232132131")).hasMessage("이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 이름에_공백이_포함될때_오류발생() {
        assertThatThrownBy(() -> new RacingCar("ab c")).hasMessage("이름은 문자만 가능합니다.");
    }

    @Test
    void 이름이_공백으로_들어올때_오류발생() {
        assertThatThrownBy(() -> new RacingCar(" ")).hasMessage("이름은 문자만 가능합니다.");
    }

    @Test
    void 이름이_모두_숫자일때_오류발생() {
        assertThatThrownBy(() -> new RacingCar("123")).hasMessage("이름은 문자만 가능합니다.");
    }

    @Test
    void 이름에_숫자가_포함될때_오류발생() {
        assertThatThrownBy(() -> new RacingCar("ab3")).hasMessage("이름은 문자만 가능합니다.");
    }

    @Test
    void 이름이_모두_특수문자일때_오류발생() {
        assertThatThrownBy(() -> new RacingCar(",,,")).hasMessage("이름은 문자만 가능합니다.");
        assertThatThrownBy(() -> new RacingCar("\n")).hasMessage("이름은 문자만 가능합니다.");
    }

    @Test
    void 이름에_특수문자가_포함되어있을때_오류발생() {
        assertThatThrownBy(() -> new RacingCar(",ab")).hasMessage("이름은 문자만 가능합니다.");
        assertThatThrownBy(() -> new RacingCar(":ab")).hasMessage("이름은 문자만 가능합니다.");
        assertThatThrownBy(() -> new RacingCar("a::b")).hasMessage("이름은 문자만 가능합니다.");
        assertThatThrownBy(() -> new RacingCar("a[]b")).hasMessage("이름은 문자만 가능합니다.");
        assertThatThrownBy(() -> new RacingCar("a\nb")).hasMessage("이름은 문자만 가능합니다.");
    }
}
