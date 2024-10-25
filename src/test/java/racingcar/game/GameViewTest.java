package racingcar.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameViewTest {
    private GameView gameView;
    RankService rankService;
    private final ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        rankService = new RankService();
        gameView = new GameView(rankService);

        System.setOut(new PrintStream(outputBuffer));
    }

    @DisplayName("각 자동차의 전진 횟수만큼 이름 : - 형태로 출력한다.")
    @Test
    void printExecutionResultOfCars() {
        Car car1 = new Car("car1", 5);
        Car car2 = new Car("car2", 3);
        Car car3 = new Car("car3", 0);

        gameView.printExecutionResultOfCars(List.of(car1, car2, car3));

        String[] outputLines = outputBuffer.toString().split("\n");
        assertEquals("car1 : -----", outputLines[0]);
        assertEquals("car2 : ---", outputLines[1]);
        assertEquals("car3 : ", outputLines[2]);
    }

    @DisplayName("최종 우승자가 한 명일 경우 단독 우승자를 출력한다.")
    @Test
    void printWinner_singleWinner() {
        Car car1 = new Car("car1", 5); // 이동 횟수 5로 설정
        Car car2 = new Car("car2", 3);
        Car car3 = new Car("car3", 2);

        gameView.printWinner(List.of(car1, car2, car3));

        String[] outputLines = outputBuffer.toString().split("\n");
        assertEquals("최종 우승자 : car1", outputLines[outputLines.length - 1]);
    }

    @DisplayName("최종 우승자가 여러 명일 경우 쉼표로 구분하여 공동 우승자를 출력한다.")
    @Test
    void printWinner_multipleWinners() {
        Car car1 = new Car("car1", 5);
        Car car2 = new Car("car2", 5); // car1과 car2의 이동 횟수가 동일
        Car car3 = new Car("car3", 2);

        gameView.printWinner(List.of(car1, car2, car3));

        String[] outputLines = outputBuffer.toString().split("\n");
        assertEquals("최종 우승자 : car1, car2", outputLines[outputLines.length - 1]);
    }
}
