package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

public class CarsTest extends NsTest {
    static Cars testCars;
    static List<CarName> answerWinner;

    @BeforeAll
    static void beforeAll() {
        CarName turtle = new CarName("거북이");
        CarName rabbit = new CarName("토끼");
        CarName seaKing = new CarName("용왕");
        CarName zara = new CarName("자라");

        Car car1 = new Car(turtle);
        Car car2 = new Car(rabbit);
        Car car3 = new Car(seaKing);
        Car car4 = new Car(zara);

        testCars = new Cars(List.of(car1, car2, car3, car4));
        answerWinner = new ArrayList<>(List.of(turtle, rabbit, seaKing, zara));
    }

    @Test
    @DisplayName("우승자를 제대로 반환하는지 확인합니다.")
    void cars_우승자_테스트() {
        List<CarName> testWinners = testCars.getFinalWinners();
        List<String> testWinnersName = testWinners.stream().map(CarName::getName).toList();
        List<String> answerWinnerName = answerWinner.stream().map(CarName::getName).toList();
        assertThat(testWinnersName).isEqualTo(answerWinnerName);
    }

    @Test
    @DisplayName("자동차 컬렉션이 비어있지 않은지 확인합니다.")
    void carsEmpty_테스트() {
        Assertions.assertThatThrownBy(() -> new Cars(new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 컬렉션의 중복을 확인합니다.")
    void cars_중복_테스트() {
        CarName turtle = new CarName("거북이");
        CarName rabbit = new CarName("토끼");
        CarName seaKing = new CarName("용왕");
        CarName rabbit2 = new CarName("토끼");

        Car car5 = new Car(turtle);
        Car car6 = new Car(rabbit);
        Car car7 = new Car(seaKing);
        Car car8 = new Car(rabbit2);

        Assertions.assertThatThrownBy(() -> new Cars(new ArrayList<>(List.of(car5, car6, car7, car8))))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
