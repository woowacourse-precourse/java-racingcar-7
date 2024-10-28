package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RaceTest {
    private Race race;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        race = new Race(Arrays.asList(car1, car2), 5);

        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void 경주가_정상적으로_진행되는지_테스트() {
        race.runRace();
        race.showWinners();

        String output = outputStream.toString();
        assertThat(output).contains("실행 결과"); // 경주 시작 메시지 확인
        assertThat(output).contains("pobi : ", "woni : "); // 자동차의 위치 정보가 출력되었는지 확인

        assertThat(output).contains("최종 우승자 : "); // 최종 우승자 메시지 확인
    }
}