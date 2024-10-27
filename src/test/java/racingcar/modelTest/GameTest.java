package racingcar.modelTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.component.Car;
import racingcar.model.Game;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game(3);
    }

    @Test
    @DisplayName("자동차 추가 테스트")
    void addCar() {
        game.addCar("pobi");
        Assertions.assertEquals(1, game.getCars().size());
        Assertions.assertEquals("pobi", game.getCars().get(0).getName());
    }

    @Test
    @DisplayName("시도 횟수 반환 테스트")
    void getTryTimes() {
        Assertions.assertEquals(3, game.getTryTimes());
    }

    @Test
    @DisplayName("자동차 이동 후 최대 위치 업데이트 테스트")
    void moveCars() {
        game.addCar("pobi");
        game.addCar("woni");

        game.moveCars();

        int maxPosition = game.getWinners().get(0).getPosition();
        Assertions.assertEquals(maxPosition,
                game.getCars().stream()
                        .mapToInt(Car::getPosition)
                        .max()
                        .getAsInt());
    }

    @Test
    @DisplayName("우승자 선정 테스트 - 단독 우승")
    void getWinnerSingle() {
        game.addCar("pobi");
        game.addCar("woni");

        game.getCars().get(0).setPosition(3);
        game.getCars().get(1).setPosition(2);
        game.setMaxPosition(3);

        List<Car> winners = game.getWinners();


        Assertions.assertEquals(1, winners.size());
        Assertions.assertEquals("pobi", winners.get(0).getName());
    }

    @Test
    @DisplayName("우승자 선정 테스트 - 공동 우승")
    void getWinnerMultiple() {
        game.addCar("pobi");
        game.addCar("woni");

        game.getCars().get(0).setPosition(3);
        game.getCars().get(1).setPosition(3);
        game.setMaxPosition(3);

        List<Car> winners = game.getWinners();

        Assertions.assertEquals(2, winners.size());
        Assertions.assertTrue(winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList())
                .containsAll(Arrays.asList("pobi", "woni")));
    }
}