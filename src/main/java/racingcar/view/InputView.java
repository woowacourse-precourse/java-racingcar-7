package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class InputView {
    public List<Car> inputCarList () {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        return divideCar(carName);
    }

    public int inputRound(){
        System.out.println("시도할 횟수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public List<Car> divideCar(String carName){
        List<Car> carList=new ArrayList<>();
        String[] carNames = carName.split(",");
        for (String name : carNames) {
            carList.add(new Car(name));
        }
        return carList;
    }

}
