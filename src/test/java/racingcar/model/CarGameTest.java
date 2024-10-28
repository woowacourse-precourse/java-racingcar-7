package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarGameTest {

    private CarGame carGame;

    @BeforeEach
    void setUp() {
        carGame = new CarGame();
    }

    @Test
    @DisplayName("참가자를 추가할 수 있다.")
    void 참가자_추가_테스트() {
        // given
        Car car = new Car("TestCar", 0);
        carGame.addParticipant(car);

        // when
        List<Car> participants = carGame.getParticipants();

        // then
        assertEquals(1, participants.size());
        assertEquals("TestCar", participants.get(0).getCarName());
    }

    @Test
    @DisplayName("CarGame 객체에서 가장 MaxDistance를 수정할 수 있다.")
    void 최대거리_수정_테스트() {
        // given & when
        carGame.updateMaxDistance(10);

        // then
        assertEquals(10, carGame.getMaxDistance());
    }

    @Test
    @DisplayName("우승자를 추가할 수 있다.")
    void 우승자_추가_테스트() {
        // given
        Car car = new Car("WinnerCar", 5);

        // when
        carGame.addWinner(car);

        // then
        List<Car> winners = carGame.getWinners();
        assertEquals(1, winners.size());
        assertEquals("WinnerCar", winners.get(0).getCarName());
    }
}
