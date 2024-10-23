package racingcar.runner;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;

class OutputTest {

    @DisplayName("[정상] 개행")
    @Test
    void newLine() {
        // given
        Output out = new Output();
        // when
        out.newLine();
        // then
        assertEquals("\n", out.get());
    }

    @DisplayName("[정상] 자동차 경주 상황 더하기")
    @Test
    void addCar() {
        // given
        Output out = new Output();
        // when
        out.add(new RacingCar("id"));
        // then
        assertEquals("id : \n", out.get());
    }

    @DisplayName("[정상] 최종 우승 자동차 이름 더하기")
    @Test
    void addWinner() {
        // given
        Output out = new Output();
        // when
        out.addWinner(new RacingCar("goo"));
        out.addWinner(new RacingCar("jin"));
        // then
        assertEquals("goo, jin, ", out.get());
    }

    @DisplayName("[정상] 최종 우승 자동차 문자열")
    @Test
    void winnerCars() {
        // given
        Output out = new Output();
        out.addWinner(new RacingCar("goo"));
        out.addWinner(new RacingCar("jin"));
        // when
        out.deleteLastDelimiters();
        // then
        assertEquals("goo, jin", out.get());
    }
}