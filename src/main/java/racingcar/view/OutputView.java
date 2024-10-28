package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    public static void requestCarsName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
    }

    public static void requestTryNumber(){
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void printEachResult(List<Car> cars){
        for (Car car : cars) {
            String carName=car.getName();
            int carScore=car.getScore();
            System.out.println(carName+" : " + "-".repeat(carScore));

        }
        System.out.println(" ");

    }

}
