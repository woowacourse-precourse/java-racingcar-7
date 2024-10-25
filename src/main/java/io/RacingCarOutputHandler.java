package io;

import car.Car;

import java.util.List;

public class RacingCarOutputHandler {

    public void displayRaceResultsByRound(List<Car> carList) {
        System.out.println();
        System.out.println("실행 결과");
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + moveCount(car.getPosition()));
        }
    }

    private String moveCount(int position) {
        StringBuilder stringPosition = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringPosition.append("-");
        }
        return stringPosition.toString();
    }
}
