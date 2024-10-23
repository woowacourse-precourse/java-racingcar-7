package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    @DisplayName("[정상] 자동차 정보 출력")
    @Test
    void printCar() {
        // given
        String carName = "goo";
        // when
        RacingCar car = new RacingCar(carName);
        // then
        assertEquals("goo", car.getId());
        assertEquals("goo : \n", car.toString());
    }

    @DisplayName("[예외] 객체 생성 (이름 5자 초과)")
    @Test
    void idLengthOverException() {
        // given
        String carName = "abcdef";
        // when & then
        assertThrows(IllegalArgumentException.class, () -> new RacingCar(carName));
    }

    @DisplayName("[예외] 객체 생성 (이름 빈 문자열)")
    @Test
    void emptyIdException() {
        // given
        String carName = "";
        // when & then
        assertThrows(IllegalArgumentException.class, () -> new RacingCar(carName));
    }

    @DisplayName("[예외] 객체 생성 (이름 null)")
    @Test
    void nullIdException() {
        // given
        String carName = null;
        // when & then
        assertThrows(IllegalArgumentException.class, () -> new RacingCar(carName));
    }

    @DisplayName("[정상] 한 칸 전진")
    @Test
    void moveForward() {
        // given
        RacingCar car = new RacingCar("goo");
        // when & then
        assertEquals(1, car.moveForward());
        assertEquals("goo : -\n", car.toString());
    }

    @DisplayName("[정상] 우승자 인지 확인")
    @Test
    void isWinner() {
        // given
        RacingCar loser = new RacingCar("loser");
        RacingCar winner = new RacingCar("goo2");
        winner.moveForward();
        // when & then
        assertFalse(loser.isWinner());
        assertTrue(winner.isWinner());
    }
}