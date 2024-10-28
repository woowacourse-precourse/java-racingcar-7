package racingcar;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingViewTest {

    @Test
    void getCarNames_쉼표로구분된_자동차이름_리스트반환() {
        // Given
        String input = "pobi,woni,jun\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // When
        List<String> carNames = RacingView.getCarNames();

        // Then
        assertThat(carNames).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 중복된_이름이_있으면_예외_발생() {
        List<String> carNames = Arrays.asList("pobi", "pobi");

        assertThatThrownBy(() -> RacingView.validateDuplication(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름이 존재합니다.");
    }

    @Test
    void 숫자를_입력했을_때_시도_횟수를_정수로_반환() {
        // Given
        String input = "5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // When
        int tryCount = RacingView.getTryCount();

        // Then
        assertThat(tryCount).isEqualTo(5);
    }

    @Test
    void 숫자가_아닌_값을_입력하면_예외_발생() {
        String input = "abc\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(() -> RacingView.getTryCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 숫자여야 합니다.");
    }

    @Test
    void printRoundResultTest() {
        //Given
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");
        List<Car> cars = List.of(car1, car2, car3);

        //When
        car1.move();
        car2.move();
        car3.move();

        String fullOutput = RacingView.printRoundResult(cars);
        String firstStatus = fullOutput.substring(fullOutput.indexOf("jun"));
        String expected = car3.getName() + " : " + "-".repeat(car3.getPosition());

        // Then
        assertThat(firstStatus).isEqualTo(expected);
    }

    @Test
    void printWinnersTest() {
        List<String> winners = List.of("pobi", "jun");

        assertThat(RacingView.printWinners(winners))
                .isEqualTo("최종 우승자 : pobi, jun");
    }
}