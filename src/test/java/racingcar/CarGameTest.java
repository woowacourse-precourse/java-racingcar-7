package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarGameTest {

    @Test
    @DisplayName("라운드를 tryCount만큼 진행하면 더이상 진행할 수 없다.")
    void playOneRound() {
        // given
        List<Car> cars = List.of(new Car("pobi"), new Car("crong"), new Car("honux"));
        MoveCondition moveCondition = new TrueMoveCondition();

        CarGame carGame = new CarGame(moveCondition, 5, cars);

        // when
        for (int i = 0; i < 5; i++) {
            carGame.playOneRound();
        }

        // then
        assertFalse(carGame.canPlay());
    }

    @Test
    @DisplayName("tryCount보다 더 많은 라운드를 진행하면 예외가 발생한다.")
    void playOneRoundFail() {
        // given
        List<Car> cars = List.of(new Car("pobi"), new Car("crong"), new Car("honux"));
        MoveCondition moveCondition = new TrueMoveCondition();

        CarGame carGame = new CarGame(moveCondition, 5, cars);

        // when
        for (int i = 0; i < 5; i++) {
            carGame.playOneRound();
        }

        // then
        assertThrows(IllegalStateException.class, carGame::playOneRound);
    }

    @Test
    @DisplayName("게임의 우승자가 여러명일때, 정상적으로 반환한다.")
    void getTopCarNames() {
        // given
        List<Car> cars = List.of(new Car("pobi"), new Car("crong"), new Car("honux"));
        MoveCondition moveCondition = new TrueMoveCondition();

        CarGame carGame = new CarGame(moveCondition, 5, cars);

        // when
        for (int i = 0; i < 5; i++) {
            carGame.playOneRound();
        }
        List<String> topCarNames = carGame.getTopCarNames();

        // then
        assertEquals(List.of("pobi", "crong", "honux"), topCarNames);
    }

    @Test
    @DisplayName("게임의 우승자가 한명일때, 정상적으로 반환한다.")
    void getTopCarNamesOneWinner() {
        // given
        List<Car> cars = List.of(new Car("pobi"), new Car("crong"), new Car("honux"));
        MoveCondition moveCondition = new NameMoveCondition("pobi");

        CarGame carGame = new CarGame(moveCondition, 5, cars);

        // when
        for (int i = 0; i < 5; i++) {
            carGame.playOneRound();
        }
        List<String> topCarNames = carGame.getTopCarNames();

        // then
        assertEquals(List.of("pobi"), topCarNames);
    }



    public static class TrueMoveCondition implements MoveCondition {
        @Override
        public boolean isMovable(RacingCarState racingCarState) {
            return true;
        }
    }

    public static class NameMoveCondition implements MoveCondition {
        private final String name;

        public NameMoveCondition(String name) {
            this.name = name;
        }

        @Override
        public boolean isMovable(RacingCarState racingCarState) {
            return racingCarState.getCarName().equals(name);
        }
    }
}