package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    public static void printResult(){
        System.out.println();
        System.out.println("실행 결과");
    }
    public static void printCurrentPositions(List<Car> cars){
        for(Car car : cars){
            System.out.println(car.getName()+" : "+car.getPath().toString().replace("[", "").replace("]", ""));
        }
        System.out.println();
    }

    public static void printFinalWinners(List<String> winingCars){
        System.out.println("최종 우승자 : " + winingCars.toString().replace("[","").replace("]",""));
    }
}
