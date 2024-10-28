package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParticipantTest {
    @DisplayName("정상적인 객체를 생성할경우 주어진 이름과 0의 이동기록을 가지고있는 객체가 생성된다.")
    @Test
    void test_11() {
        String givenName = "choi";
        Participant participant = new Participant(givenName);
        int expectedMoveCount = 0;
        String expectedName = "choi";

        assertEquals(expectedMoveCount, participant.getMoveCount());
        assertEquals(expectedName, participant.getName());
    }

    @Test
    @DisplayName("문자열을 분리 할때 특정 이름이 5글자 이상이면 IllegalArguementException을 발생시킨다")
    void test_21() {
        String given = "morethanfive";

        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Participant(given));
        assertEquals("자동차 이름은 5글자 이상으로 작성할수 없습니다.", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("문자열을 분리 할때 특정 이름이 공백이면 IllegalArguementException을 발생시킨다")
    void test_22() {
        String given = "";

        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Participant(given));
        assertEquals("자동차 이름은 공백이 될수 없습니다.", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("문자열을 분리 할때 특정 이름이 null이면 IllegalArguementException을 발생시킨다")
    void test_23() {
        String given = null;

        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Participant(given));
        assertEquals("자동차 이름은 null 이 될수 없습니다.", illegalArgumentException.getMessage());
    }

    @DisplayName("4이상의 값을 전달 받으면 1 만큼 이동한다")
    @Test
    void test_31() {
        Participant participant = new Participant("choi");
        int givenMoveCount = 4;
        int expected = 1;

        participant.race(givenMoveCount);

        assertEquals(expected, participant.getMoveCount());
    }

    @DisplayName("4미만의 값을 전달 받으면 이동하지 못한다")
    @Test
    void test_32() {
        Participant participant = new Participant("choi");
        int givenMoveCount = 3;
        int expected = 0;

        participant.race(givenMoveCount);

        assertEquals(expected, participant.getMoveCount());
    }

    @DisplayName("printStatus 함수를 이용할경우, 이름과 이동횟수를 표시한다.")
    @Test
    void test_41() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        PrintStream standardOut = System.out;
        System.setOut(new PrintStream(outputStreamCaptor));

        Participant participant = new Participant("choi");
        String expected = "choi : ---";
        participant.race(5);
        participant.race(5);
        participant.race(5);

        participant.printStatus();

        assertEquals(expected, outputStreamCaptor.toString().trim());

        System.setOut(standardOut);
    }

}
