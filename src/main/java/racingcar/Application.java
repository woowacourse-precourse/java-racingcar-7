package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<String> carNameList; // 자동차 이름을 입력 받는 List
        int tryCount;

        List<Car> carList = new ArrayList<>(); // Car 객체를 입력 받는 List
        InputView inputView = new InputView();

        carNameList = inputView.createCar();

        for (String s: carNameList) {
            carList.add(new Car(s));
        }
        tryCount = inputView.tryCount();


        System.out.println("시도할 횟수는 몇 회인가요?");
        n = Integer.parseInt(Console.readLine());
    }
}
