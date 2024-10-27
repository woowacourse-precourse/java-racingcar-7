package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingInfoDTO;
import racingcar.model.Car;
import racingcar.service.WinnerService;
import racingcar.view.OutputView;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.List;


class WinnerTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("레이싱 후 최종 우승자를 제대로 찾아내는지 검증, 우승자 수&위치")
    void findWinner() {
        // given
        WinnerService winnerService = new WinnerService();
        List<Car> carList = List.of(new Car("hello"),new Car("my"),new Car("name"), new Car("is"),new Car("car"));
        RacingInfoDTO racingInfoDTO = new RacingInfoDTO(carList, BigInteger.TEN);
        int count = 0;
        BigInteger maxPos = BigInteger.ZERO;

        // when
        List<Car> winner = winnerService.findWinner(racingInfoDTO);

        // then
        for (Car car : carList) {
            if (car.getPosition().compareTo(maxPos) > 0) {
                maxPos = car.getPosition();
                count = 1;
            }
            else if (car.getPosition().compareTo(maxPos) == 0) {
                count++;
            }
        }

        int finalCount = count;
        BigInteger finalMaxPos = maxPos;

        assertAll(
                () -> assertThat(winner.size()).isEqualTo(finalCount),
                () -> assertThat(winner.getFirst().getPosition()).isEqualTo(finalMaxPos)
        );
    }

    @Test
    @DisplayName("단독 우승인 경우 출력 검증")
    void printSoloWinner() {
        // given
        List<Car> winner = List.of(new Car("hello"));
        OutputView outputView = new OutputView();

        // when
        outputView.printWinner(winner);

        // then
        String output = outputStreamCaptor.toString().trim(); // 출력 결과를 문자열로 변환 후 공백 제거
        assertThat(output).isEqualTo("최종 우승자 : hello");
    }

    @Test
    @DisplayName("공동 우승인 경우 출력 검증")
    void printJointWinner() {
        // given
        List<Car> winner = List.of(new Car("hello"), new Car("my"), new Car("car"));
        OutputView outputView = new OutputView();

        // when
        outputView.printWinner(winner);

        // then
        String output = outputStreamCaptor.toString().trim(); // 출력 결과를 문자열로 변환 후 공백 제거
        assertThat(output).isEqualTo("공동 우승자 : hello, my, car");
    }
}