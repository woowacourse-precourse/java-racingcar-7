package racingcar.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.CarGame;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarServiceTest {

    private CarService carService;
    private CarGame carGame;

    @BeforeEach
    void setUp() {
        carService = new CarService();
        carGame = new CarGame();
    }

    @Test
    @DisplayName("자동차 경주 게임에 참가자를 추가할 수 있다.")
    void 자동차_경주_게임에_참가자_추가() throws Exception{
        // Given
        String carName = "Car1";

        // when
        carService.addParticipant(carName);

        // Then
        List<Car> participants = carService.getParticipants();
        assertEquals(participants.size(), 1);
        assertEquals(carName, participants.get(0).getCarName());
    }

}
