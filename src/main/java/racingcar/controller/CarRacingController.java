package racingcar.controller;

import racingcar.model.Car;
import racingcar.utils.Parser;
import racingcar.utils.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class CarRacingController {

    private final OutputView outputView;
    private final InputView inputView;

    private final Parser parser;
    private final Validator validator;

    private final List<Car> carList;

    private Integer count;

    public CarRacingController(){
        this.outputView = new OutputView();
        this.inputView = new InputView();

        this.parser = new Parser();
        this.validator = new Validator();

        this.carList = new ArrayList<>();
        this.count = 0;
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
        String countString  = inputView.inputCount();
        count = validator.isValidCount(countString);
    }

    public void racingStart(){
        System.out.println();
        System.out.println("실행 결과");

        for(int i=0; i<count; i++){
            moveOrStop();
            printResult();
        }
    }

    public void moveOrStop(){
        for(Car car: carList){
            if(pickNumberInRange(0, 9)>=4) car.distance++;
        }
    }

    public void printResult(){
        outputView.printResult(carList);
    }

    public void printWinner(){
        outputView.printWinner(carList);
    }

}
