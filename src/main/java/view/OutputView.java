package view;

import model.Car;

import java.util.List;

public class OutputView {
    public static void printRoundResult(List<Car> cars){
        for(Car car: cars){
            System.out.println(car.getName()+ " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners){
        String result = String.join(",",winners.stream().map(Car::getName).toList());
        System.out.println("최종우승자 : " + result);
    }
}
