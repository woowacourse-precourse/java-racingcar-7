package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.RacingCar;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {
    private final InputView inputView;
    private final OutputView outputView;
    Validator validator = new Validator();
    public RacingCarService(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public List<RacingCar> inputCars(){
        String names = inputView.readNames();
        String[] nameList=names.split(",");
        List<RacingCar> racingCars = new ArrayList<>();

        for (String name : nameList) {
            validator.nameValidate(name);
            racingCars.add(new RacingCar(name));
        }

        return racingCars;
    }

    public Integer inputTrial() {
        String trial = inputView.readTrial();
        validator.trialValidate(trial);
        return Integer.parseInt(trial);
    }

    public void racing(List<RacingCar> cars, int trial) {
        int randomNum=0;
        for (int i=0; i<trial; i++){
            carGoAhead(cars);
            outputView.printResult(cars);
        }
    }

    private void carGoAhead(List<RacingCar> cars) {

        for (RacingCar car : cars) {
            car.goAhead(Randoms.pickNumberInRange(0,9));
        }
    }

    public List <String> getResult(List<RacingCar> cars) {
        List<String> result = new ArrayList<>();
        int maxDistance = getMaxDistance(cars);
        for (RacingCar car : cars) {
            if (car.getDistance() == maxDistance) {
                result.add(car.getName());
            }
        }
        return result;
    }

    public void printWinners(List<String> winners) {
        outputView.printWinner(winners);
    }


    private int getMaxDistance(List<RacingCar> cars) {
        int max=0;
        for (RacingCar car : cars) {
            if (car.getDistance() > max) {
                max = car.getDistance();
            }
        }
        return max;
    }
}
