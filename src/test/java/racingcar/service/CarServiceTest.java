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

    @BeforeEach
    void setUp() {
        carService = new CarService(){
            @Override
            public boolean isAdvance(){
                return true;
            }
        };
        carService.addParticipant("Car1");
        carService.addParticipant("Car2");
    }

    @Test
    @DisplayName("자동차 경주 게임에 참가자를 추가할 수 있다.")
    void 자동차_경주_게임에_참가자_추가_테스트() throws Exception{
        // given
        String carName = "Car3";

        // when
        carService.addParticipant(carName);

        // Then
        List<Car> participants = carService.getParticipants();
        assertEquals(participants.size(), 3);
        assertEquals(carName, participants.get(2).getCarName());
    }

    @Test
    @DisplayName("차수별로 전진하는 조건 만족 시에 자동차는 전진할 수 있다.")
    void 자동차_전진_테스트() throws Exception{
        // given
        List<Car> participants = carService.getParticipants();
        int initialPosition = participants.get(0).getDistance();

        // when
        carService.advanceCars();

        // then
        for (Car car : carService.getParticipants()) {
            assertTrue(car.getDistance() > initialPosition);
        }
    }

    @Test
    @DisplayName("우승자를 선정하는 로직")
    void 우승자를_선정할_수_있다() throws Exception{
        // given
        carService.advanceCars();
        carService.advanceCars();

        // when
        carService.updateWinners();

        // then
        List<String> winners = carService.getWinners();
        assertTrue(winners.size() == 2);
    }

}
