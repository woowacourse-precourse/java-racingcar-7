package racingcar.unittest;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.OutputHandler;

class OutputHandlerTest extends NsTest {

    @Test
    @DisplayName("printStartMessage 메서드 테스트")
    void printStartMessage_shouldPrintCorrectMessage() {
        // When
        OutputHandler.printStartMessage();

        // Then
        assertThat(output()).contains("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Test
    @DisplayName("printAttemptsMessage 메서드 테스트")
    void printAttemptsMessage_shouldPrintCorrectMessage() {
        // When
        OutputHandler.printAttemptsMessage();

        // Then
        assertThat(output()).contains("시도할 횟수는 몇 회인가요?");
    }

    @Test
    @DisplayName("printRaceResultHeader 메서드 테스트")
    void printRaceResultHeader_shouldPrintCorrectMessage() {
        // When
        OutputHandler.printRaceResultHeader();

        // Then
        assertThat(output()).contains("실행 결과");
    }

    @Test
    @DisplayName("printCurrentStatus 메서드 테스트")
    void printCurrentStatus_shouldPrintCarPositions() {
        // Given
        Car car1 = new Car("pobi");
        Car car2 = new Car("crong");
        car1.move();
        car1.move();
        car2.move();
        List<Car> cars = Arrays.asList(car1, car2);

        // When
        OutputHandler.printCurrentStatus(cars);

        // Then
        String[] outputs = output().split(System.lineSeparator());
        assertThat(outputs).contains(
                "pobi : --",
                "crong : -"
        );
    }

    @Test
    @DisplayName("printWinners 메서드 테스트")
    void printWinners_shouldPrintWinners() {
        // Given
        List<String> winners = Arrays.asList("pobi", "crong");

        // When
        OutputHandler.printWinners(winners);

        // Then
        assertThat(output()).contains("최종 우승자 : pobi, crong");
    }

    @Override
    public void runMain() {
    }
}
