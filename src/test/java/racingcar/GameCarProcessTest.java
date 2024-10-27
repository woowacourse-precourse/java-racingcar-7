package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameCarProcessTest {
    @DisplayName("랜덤한 숫자가 0에서 3 사이의 숫자라면 자동차는 움직이지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 전진_하지않는_경우_테스트(int number) {
        String name = "pobi";
        GameCar gameCar = new GameCar(name);
        gameCar.move(number);
        assertThat(gameCar.getForwardMarksSize()).isEqualTo(1);
    }

    @DisplayName("랜덤한 숫자가 4에서 9 사이의 숫자라면 자동차는 1만큼 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 전진_하는경우_테스트(int number) {
        String name = "java";
        GameCar gameCar = new GameCar(name);
        gameCar.move(number);
        assertThat(gameCar.getForwardMarksSize()).isEqualTo(2);
    }

    @DisplayName("생성자는 이름으로 구성된 gameCar를 반환한다.")
    @Test
    void 생성자는_이름으로_구성된_gameCar_반환_테스트() {
        String name = "yi";
        GameCar gameCar = new GameCar(name);
        Assertions.assertThat(gameCar.getCarName())
                .isEqualTo(name);
    }

    @DisplayName("정상적인 문자열 리스트가 들어올 경우 이름 수에 맞는 자동차 인스턴스를 가진 리스트를 생성한다.")
    @Test
    void 자동차_인스턴스_가진_리스트_반환_테스트() {
        List<String> names = List.of("pobi", "java", "yi");
        List<GameCar> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new GameCar(name));
        }
        assertThat(cars.size()).isEqualTo(names.size());
    }

    @DisplayName("자동차 인스턴스의 차수별 과정이 올바르게 출력되는지 확인한다.")
    @Test
    void 자동차_인스턴스_과정출력_확인_테스트() {
        GameCar car = new GameCar("pobi");

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        car.move(4);
        car.displayPrint();
        String firstOutput = outputStreamCaptor.toString().trim();
        assertThat(firstOutput).isEqualTo("pobi : -");

        outputStreamCaptor.reset();

        car.move(4);
        car.displayPrint();
        String secondOutput = outputStreamCaptor.toString().trim();
        assertThat(secondOutput).isEqualTo("pobi : --");

        System.setOut(System.out);
    }
}