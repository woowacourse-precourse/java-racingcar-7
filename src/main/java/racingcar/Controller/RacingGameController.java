package racingcar.Controller;

import racingcar.Entity.Car;
import racingcar.Service.RacingGameService;

import java.util.List;

public class RacingGameController {
    public void RacingGame(List<String> carsname, int attemptCount){

        RacingGameService racingGameService = new RacingGameService(carsname, attemptCount);

        for(int i = 0; i < attemptCount; i++){
            racingGameService.playRound();
            List<Car> cars = racingGameService.getCars();

            for (Car car : cars) {
                System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
            }
            System.out.println();
        }


    }
}
