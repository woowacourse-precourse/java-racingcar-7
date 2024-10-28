package racingcar.controller;

import racingcar.model.Car;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputView;

import java.util.List;

public class Race {

    private OutputView outputView=new OutputView();

    public void roundResult(List<Car> carList) {
        for(Car car : carList) {
            if(Randoms.pickNumberInRange(0,9)>=4){
                int newPosition =car.getPosition()+1;
                car.setPosition(newPosition);
            }
        }
    }

    public void nRoundGame(int tryNumber,List<Car> carList) {
        System.out.println("실행 결과");
        for(int i=0;i<tryNumber;i++){
            roundResult(carList);
            outputView.printRoundResult(carList);
        }
    }
}
