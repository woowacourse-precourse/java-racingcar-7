package racingcar;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RaceControllerTest {
    private RaceController raceController;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        raceController = new RaceController();
        raceController.parseAndValidateCarNames("pobi,crong,honux");

        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void 자동차_이름_유효성_검증_테스트() {
        List<String> validNames = raceController.parseAndValidateCarNames("pobi,crong,honux");
        assertThat(validNames).containsExactly("pobi", "crong", "honux");

        assertThrows(IllegalArgumentException.class,
                () -> raceController.parseAndValidateCarNames("pobi,tooLongName,honux"),
                "5자 이상 이름이 입력되면 예외가 발생해야 합니다.");
    }


    @Test
    void 각_라운드에서_자동차_전진_여부_결정_및_위치_업데이트() {
        raceController.playRound();

        List<Car> cars = raceController.getCars();

        cars.forEach(car ->
                System.out.println(car.getName() + " 위치: " + car.getPosition())
        );

        cars.forEach(car ->
                assertThat(car.getPosition()).isGreaterThanOrEqualTo(0)
        );
    }

    @Test
    void 경주_시도_횟수에_따라_자동차_상태와_출력_형식_확인() {
        int attempts = 5;
        raceController.startRace(attempts);

        String output = outputStream.toString();
        assertThat(output).contains("실행 결과");

        List<Car> cars = raceController.getCars();
        cars.forEach(car -> assertThat(output).contains(car.getName() + " : "));

        int resultCount = output.split("pobi : ").length - 1;
        assertThat(resultCount).isEqualTo(attempts);
    }

    @Test
    void 우승자_결정_및_출력_테스트() {
        raceController.startRace(5);
        String output = outputStream.toString();

        assertThat(output).contains("최종 우승자 : ");

        List<Car> cars = raceController.getCars();
        boolean hasWinner = cars.stream()
                .map(Car::getName)
                .anyMatch(output::contains);
        assertThat(hasWinner).isTrue();
    }
}
