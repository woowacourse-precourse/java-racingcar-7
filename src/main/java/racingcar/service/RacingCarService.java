package racingcar.service;

import racingcar.model.RacingCar;
import racingcar.validator.Validator;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {
    private final InputView inputView;

    public RacingCarService(InputView inputView) {
        this.inputView = inputView;
    }

    public List<RacingCar> init(){
        String names = inputView.readNames();
        String[] nameList=names.split(",");
        Validator validator = new Validator();
        List<RacingCar> racingCars = new ArrayList<>();

        for (String name : nameList) {
            validator.nameValidate(name);
            racingCars.add(new RacingCar(name));
        }

        return racingCars;
    }

}
