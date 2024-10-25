package racingcar;

import racingcar.domain.Input;
import racingcar.domain.RacingCar;
import racingcar.service.Race;
import racingcar.util.InputUtil;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Input input = InputUtil.getInput();

        List<RacingCar> racingCars = InputUtil.getRacingCars(input);

        List<String> result = Race.startRace(racingCars, input.getTryNumber());
        System.out.println("최종 우승자 : "+ String.join(", ", result) );
    }
}
