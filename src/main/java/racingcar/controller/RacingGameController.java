package racingcar.controller;

import static racingcar.Constatns.MOVE_FORAWRD_CONDITION;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.validator.CarNameValidator;
import racingcar.view.RacingGameView;

public class RacingGameController {

    RacingGameView view = new RacingGameView();
    List<Car> cars = new ArrayList<>();
    int trialCount = 0;

    public void run(){
        view.carNameInputMessage();
        createCarInstances();
        view.trialCountInputMessage();
        trialCount = view.getTrialCount();
        startRace(cars, trialCount);
        view.showFinalWinner(cars);
    }

    private void createCarInstances(){
        List<String> carNames = new ArrayList<>(List.of(view.getCarNames().split(",")));
        for(String name:carNames){
            CarNameValidator.carNameValidator(name);
            cars.add(new Car(name));
        }
    }

    private void startRace(List<Car> cars, int trialCount){
        view.showTrialResultsMessage();
        for(int i=0;i<trialCount;i++) {
            executeOneRound(cars);
        }
    }

    private void executeOneRound(List<Car> cars) {
        for (Car car : cars) {
            checkWhetherCarMove(car);
        }
        view.showRoundResult(cars);
    }

    private static void checkWhetherCarMove(Car car) {
        if(Randoms.pickNumberInRange(0, 9)>=MOVE_FORAWRD_CONDITION){
            car.go();
        }
    }

}
