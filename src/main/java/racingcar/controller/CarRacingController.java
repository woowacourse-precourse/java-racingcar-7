package racingcar.controller;

import racingcar.model.Car;
import racingcar.utils.Parser;
import racingcar.utils.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CarRacingController {

    private OutputView outputView;
    private InputView inputView;

    private Parser parser;
    private Validator validator;

    private List<Car> carList;

    public CarRacingController(){
        this.outputView = new OutputView();
        this.inputView = new InputView();

        this.parser = new Parser();
        this.validator = new Validator();

        this.carList = new ArrayList<>();
    }

    public void inputNames(){

        outputView.printCarNameMessage();
        String input = inputView.inputCarName();
        List<String> names = parser.parsingCarNames(input);

        //for(String name: names) System.out.println("name: "+ name);
        validator.isValidName(names);

        for(String name: names) carList.add(new Car(name));

        //for(Car car: carList) car.toString();

    }

    public void inputCount(){
        outputView.printCountMessage();
    }
}
