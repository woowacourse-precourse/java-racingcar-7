package racingcar.model;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.dto.FinalResultDto;
import racingcar.model.dto.RoundResultDto;

class RaceGameTest {
    @Test
    @DisplayName("RaceGame 객체를 생성할 수 있다.")
    void createRaceGame() {
        // given
        Name name1 = new Name("우테코");
        Name name2 = new Name("박재연");
        Car car = new Car(name1);
        Car car2 = new Car(name2);
        RaceCars raceCars = new RaceCars(Arrays.asList(car, car2));
        // when
        RaceGame raceGame = new RaceGame(raceCars, new RandomMovement());
        // then
        Assertions.assertThat(raceGame).isNotNull();
    }

    @Test
    @DisplayName("매 라운드마다 자동차를 이동시킬 수 있다.")
    void moveAllCars() {
        // given
        Name name1 = new Name("우테코");
        Name name2 = new Name("박재연");
        Car car = new Car(name1);
        Car car2 = new Car(name2);
        List<Car> cars = Arrays.asList(car, car2);
        RaceCars raceCars = new RaceCars(cars);
        List<Car> beforeMovement = raceCars.getCars();
        Movement alwaysTrueMovement = () -> true;
        RaceGame raceGame = new RaceGame(raceCars, alwaysTrueMovement);

        //when
        raceGame.moveAllCars();
        List<Car> afterMovement = raceGame.getRaceCars().getCars();

        //then
        for (int i = 0; i < cars.size(); i++) {
            Assertions.assertThat(afterMovement.get(i).hasBiggerPositionThan(beforeMovement.get(i))).isTrue();
        }
    }

    @Test
    @DisplayName("매 라운드 마다 결과를 반환할 수 있다.")
    void getRoundResult() {
        // given
        Name name1 = new Name("우테코");
        Name name2 = new Name("박재연");
        Car car1 = new Car(name1);
        Car car2 = new Car(name2);
        car1.move(true);
        car1.move(true);
        car2.move(true);
        List<Car> cars = Arrays.asList(car1, car2);
        RaceCars raceCars = new RaceCars(cars);
        RaceGame raceGame = new RaceGame(raceCars, new RandomMovement());

        //when
        RoundResultDto roundResult = raceGame.getRoundResult();
        List<String> convertedResult = roundResult.result();

        //then
        Assertions.assertThat(convertedResult).containsExactly("우테코 : --", "박재연 : -");
    }

    @Test
    @DisplayName("우승자를 반환할 수 있다.")
    void getWinner() {
        // given
        Name name1 = new Name("우테코");
        Name name2 = new Name("박재연");
        Car car1 = new Car(name1);
        Car car2 = new Car(name2);
        car1.move(true);
        car1.move(true);
        car2.move(true);
        car2.move(true);
        List<Car> cars = Arrays.asList(car1, car2);
        RaceCars raceCars = new RaceCars(cars);
        RaceGame raceGame = new RaceGame(raceCars, new RandomMovement());

        //when
        FinalResultDto winner = raceGame.getWinner();

        //then
        Assertions.assertThat(winner.winners()).containsExactly("우테코", "박재연");
    }
}