package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.component.RacingCar;
import racingcar.factory.RacingCarFactory;
import racingcar.race.RacingPlayer;

import java.util.List;

public class ConsoleCarRacingStadium {

    public ConsoleCarRacingStadium() {
        List<RacingPlayer<RacingCar>> racingCars = setUpRacingCars();
        Console.close();
    }

    private List<RacingPlayer<RacingCar>> setUpRacingCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        RacingCarFactory racingCarFactory = new RacingCarFactory(carNamesInput);

        return racingCarFactory.createRacingCars()
                .stream()
                .map((racingCar) -> (RacingPlayer<RacingCar>) racingCar)
                .toList();
    }

}
