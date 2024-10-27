package racingcar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTested {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    // 테스트 전에 출력 스트림을 가로챔
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    // 테스트 후에 원래 출력 스트림으로 복원
    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("자동차 이름을 ,로 구분하여 입력받아 배열로 변환하는 기능 테스트")
    void testDataTrans() {
        RaceDto data = new RaceDto();
        data.carName = "pobi,woni,jun";
        Application.DataTrans(data);

        assertThat(data.racers).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과할 때 IllegalArgumentException을 발생시키는지 테스트")
    void testDataTransInvalidName() {
        RaceDto data = new RaceDto();
        data.carName = "pobi,woniiii";

        assertThatThrownBy(() -> Application.DataTrans(data))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차가 랜덤 값에 따라 전진하는 기능 테스트")
    void testStartRace() {
        RaceDto data = new RaceDto();
        data.carName = "pobi,woni";
        Application.DataTrans(data);
        data.num = 3;

        Application.StartRace(data);

        assertThat(data.forwardNum[0]).isGreaterThanOrEqualTo(0);
        assertThat(data.forwardNum[1]).isGreaterThanOrEqualTo(0);
    }

    @Test
    @DisplayName("최종 우승자 계산 테스트")
    void testWinner() {
        RaceDto data = new RaceDto();
        data.carName = "pobi,woni";
        Application.DataTrans(data);

        // 전진 수동 설정
        data.forwardNum[0] = 5;  // pobi가 5번 전진
        data.forwardNum[1] = 3;  // woni가 3번 전진

        Application.Winner(data);

        // 우승자가 제대로 출력되는지 확인
        assertThat(outputStreamCaptor.toString().trim()).contains("최종 우승자 : pobi");
    }

    @Test
    @DisplayName("사용자가 콘솔에서 입력을 받는 기능 테스트")
    void testInput() {
        RaceDto data = new RaceDto();

        // 가상의 입력 설정
        ConsoleMock.setInput("pobi,woni\n1\n");
        Application.getInput(data);

        assertThat(data.carName).isEqualTo("pobi,woni");
        assertThat(data.num).isEqualTo(1);
    }

    // Mock 콘솔 입력을 위한 클래스
    static class ConsoleMock {
        static void setInput(String input) {
            System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        }
    }
}