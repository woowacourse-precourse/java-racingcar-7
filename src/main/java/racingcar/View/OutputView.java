package racingcar.View;

import racingcar.Model.Car;

import java.util.ArrayList;

public class OutputView {
    private static final String printRace="실행 결과";
    private static final String printWinner="최종 우승자 : ";
    public static void Print_Race(ArrayList<Car> cars) {
        System.out.println(printRace);
        for(Car car : cars) {
            System.out.println(car.getCarName()+" : "+car.getPosition());
        }
        System.out.println();
    }
    public static void Print_Winners(ArrayList<Car> cars) {
        System.out.println(printWinner);
        for(Car car : cars) {

        }
    }
}
