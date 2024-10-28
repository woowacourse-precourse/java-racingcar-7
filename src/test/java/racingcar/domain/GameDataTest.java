package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameDataTest {
    private GameData gameData;

    @BeforeEach
    void setUp() {
        List<Car> cars = List.of(new Car("pobi"), new Car("woni"), new Car("jun"));
        gameData = new GameData(cars, 3);
    }

    @Test
    @DisplayName("게임 데이터에서 우승자 한 명을 추출한다.")
    void getWinnerCar() {
        // Given
        Car pobi = gameData.getCars().get(0);
        Car woni = gameData.getCars().get(1);
        pobi.move(9);
        pobi.move(9);
        woni.move(9);

        // When
        List<Car> winners = gameData.getWinnerCars();

        // Then
        assertEquals(1, winners.size());
        assertEquals("pobi", winners.get(0).getName());
    }

    @Test
    @DisplayName("게임 데이터에서 우승자들을 추출한다.")
    void getWinnerCars() {
        // Given
        Car pobi = gameData.getCars().get(0);
        Car woni = gameData.getCars().get(1);
        Car jun = gameData.getCars().get(2);
        pobi.move(9);
        pobi.move(9);
        woni.move(9);
        jun.move(9);
        jun.move(9);

        // When
        List<Car> winners = gameData.getWinnerCars();

        // Then
        assertEquals(2, winners.size());
        assertEquals("pobi", winners.get(0).getName());
        assertEquals("jun", winners.get(1).getName());
    }
}