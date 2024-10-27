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
    public static void Print_Winners(ArrayList<Car> winnercars) {
        System.out.print(printWinner);
        for (int i = 0; i < winnercars.size(); i++) {
            System.out.print(winnercars.get(i).getCarName());
            if (i < winnercars.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
