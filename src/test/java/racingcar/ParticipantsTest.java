package racingcar;


import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParticipantsTest {
    @Test
    @DisplayName("문자열의 문제가 없을경우 참가자들 객체가 정상적으로 생성된다.")
    void test_2() {
        String given = "pobi,woni,jun";

        assertDoesNotThrow(() -> new Participants(given));
    }

    @Test
    @DisplayName("문자열의 특정 이름이 5글자가 넘을 경우 예외를 던진다")
    void test_21() {
        String given = "pobi,morethanfive,jun";

        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Participants(given));
        assertEquals(illegalArgumentException.getMessage(), "자동차 이름은 5글자 이상으로 작성할수 없습니다.");
    }

    @Test
    @DisplayName("문자열의 특정 이름이 공백일 경우 예외를 던진다")
    void test_22() {
        String given = "pobi,,jun";

        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Participants(given));
        assertEquals(illegalArgumentException.getMessage(), "자동차 이름은 공백이 될수 없습니다.");
    }

    @Test
    @DisplayName("반점을 두개가진 3개의 이름을 가진 문자열을 제공할 경우 참가자는 3명이 된다")
    void test_23() {
        String given = "choi,kim,ryu";
        int expected = 3;

        Participants participants = new Participants(given);
        assertEquals(expected, participants.numberOfParticipants());
    }

    @Test
    @DisplayName("시행이 1번 이상이지 않으면 에외를 던진다. ")
    void raceManyTimes() {
        int givenRaceTimes = 0;
        String givenName = "choi,kim,ryu";
        Participants participants = new Participants(givenName);

        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> participants.raceManyTimes(givenRaceTimes));

        assertEquals(illegalArgumentException.getMessage(), "시행 횟수는 1회 이상이여야 합니다.");
    }

    @Test
    @DisplayName("경기의 결과를 표시한다.")
    void printWinner() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        PrintStream standardOut = System.out;
        System.setOut(new PrintStream(outputStreamCaptor));

        Participants participants = createParticipants();

        participants.printWinner();

        String expected = "최종 우승자 : choi,ryu";

        assertEquals(expected, outputStreamCaptor.toString().trim());

        System.setOut(standardOut);
    }


    private static Participants createParticipants() {
        Participant participant1 = new Participant("choi");
        Participant participant2 = new Participant("ryu");
        Participant participant3 = new Participant("kim");
        Participant participant4 = new Participant("park");

        participant1.race(5);
        participant1.race(5);
        participant1.race(5);

        participant2.race(5);
        participant2.race(5);
        participant2.race(5);

        return new Participants(List.of(participant1, participant2, participant3, participant4));
    }
}
