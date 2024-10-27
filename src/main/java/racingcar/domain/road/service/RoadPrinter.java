package racingcar.domain.road.service;

import racingcar.domain.car.entity.Car;

public class RoadPrinter {

    public static void printRoad(Car car) {
        int road= car.getRoad().getLength();
        System.out.print(car.getName()+" : ");
        for(int i=0; i<road; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
