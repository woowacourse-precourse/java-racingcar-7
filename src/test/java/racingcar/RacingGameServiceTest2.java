package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.service.RacingGameService;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameServiceTest2 {
    private RacingGameService racingGameService;

    @BeforeEach
    void setUp() {
        racingGameService = new RacingGameService();
        // 자동차 이름을 추가하고, 기본 포지션을 0으로 초기화
        racingGameService.createCars("cara,carb,carc");
        racingGameService.setRounds("10"); // 10라운드 설정
    }

    @Test
    void startRace_printsCurrentPositions_correctly() {
        // 출력 캡처를 위한 ByteArrayOutputStream 생성
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        racingGameService.startRace();

        System.setOut(originalOut);

        String output = outputStream.toString();

        // 예상 출력 형식: 각 자동차 이름 뒤에 '-'가 반복됨
        // 자동차의 포지션은 0으로 시작하며, 각 라운드에서 무작위로 증가함
        List<Car> cars = racingGameService.getCars();
        for (Car car : cars) {
            // 최소 0부터 최대 10라운드 사이의 '-' 문자가 반복되며 출력되어야 함
            int position = car.getPosition();
            String expectedOutput = car.getName() + " : " + "-".repeat(position);
            assertThat(output).contains(expectedOutput);
        }
    }
}
