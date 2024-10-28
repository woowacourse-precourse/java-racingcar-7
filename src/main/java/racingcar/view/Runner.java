package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.CarController;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public Runner(){
    }
    public void run(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        List<Car>carList = new ArrayList<>();
        for(String carName : carNames){
            if(carName.length() > 5){
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");       //FIXME
            }
            carList.add(new Car(carName));
        }


        System.out.println("시도할 횟수는 몇 회인가요?");
        String N = Console.readLine();

        CarController carController = new CarController(carList);
        ResultView resultView = new ResultView();
        ResultWinner resultWinner = new ResultWinner();
        //TODO N 예외처리 - 숫자 아닌 경우
        for(int i =0 ; i<Integer.parseInt(N); i++){
            carController.raceStart();
            resultView.showResult(carController.getCarList());
        }
        resultWinner.showWinner(carController.getCarList());
    }
}
