package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceTest {

    @AfterEach
    void afterEach() {
        Console.close();
    }

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

    @Test
    void parseCarNames_5글자_초과_자동차이름_예외처리() {
        // given
        System.setIn(new ByteArrayInputStream("sixsix,a\n5".getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Race race = new Race();

        // when then
        assertThatThrownBy(() -> race.init()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void parseCarNames_공백_자동차이름_예외처리() {
        // given
        System.setIn(new ByteArrayInputStream(" \n5".getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Race race = new Race();

        // when then
        assertThatThrownBy(() -> race.init()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void parseTotalRound_음수_예외처리() {
        // given
        System.setIn(new ByteArrayInputStream("a,b\n-1".getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Race race = new Race();

        // when then
        assertThatThrownBy(() -> race.init()).isInstanceOf(IllegalArgumentException.class);
    }

}