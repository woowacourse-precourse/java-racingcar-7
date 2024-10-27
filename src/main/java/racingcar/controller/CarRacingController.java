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

    public void inputNames(){ //자동차 이름 입력
        outputView.printCarNameMessage();
        String input = inputView.inputCarName();

        validator.isValidInput(input);
        List<String> names = parser.parsingCarNames(input);
        validator.isValidName(names);

        for(String name: names) carList.add(new Car(name));
    }

    public void inputCount(){ //시행할 홧수 입력
        outputView.printCountMessage();
        String countString  = inputView.inputCount();
        validator.isValidInput(countString);
        count = validator.isValidCount(countString);
    }

    public void racingStart(){ //경주 시작
        System.out.println();
        System.out.println("실행 결과");

        for(int i=0; i<count; i++){
            moveOrStop();
            printResult();
        }
    }

    public void moveOrStop(){ //무작위 값 구해서 전진 또는 정지 결정
        for(Car car: carList){
            if(pickNumberInRange(0, 9)>=4) car.distance++;
        }
    }

    public void printResult(){
        outputView.printResult(carList);
    } //경주 진행 과정 출력

    public void printWinner(){ //우승자 출력
        outputView.printWinner(carList);
    }

}
