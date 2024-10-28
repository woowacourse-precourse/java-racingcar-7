package racingcar;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {

    @Test
    void Race는_자동차_경주_게임의_흐름을_제어한다() {
        // given
        System.setIn(new ByteArrayInputStream("a,b,c\n5".getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Race race = new Race();

        // when
        race.init();
        race.start();

        // then
        assertThat(out.toString()).contains("실행 결과", "a : ", "b : ", "c : ", "최종 우승자 : ");
    }
}