package racingcar.service;

import racingcar.entity.Car;
import racingcar.entity.Road;

public class RoadPrinter {

    public static void printRoad(Car car) {
        int road= car.getRoad().getRoad();
        System.out.print(car.getName()+" : ");
        for(int i=0; i<road; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
