package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    public static void printResult(){
        System.out.println();
        System.out.println("실행 결과");
    }
    // 경주 결과 출력
    public static void printNow(List<Car> cars){
        for(Car car : cars){
            System.out.println(car.getName()+" : "+car.getMoveTo().toString().replace("[", "").replace("]", ""));
        }
        System.out.println();
    }

    // 경주 우승자 출력
    public static void printRaceResult(List<String> winners){
        System.out.println("최종 우승자 : " + winners.toString().replace("[","").replace("]",""));
    }
}
