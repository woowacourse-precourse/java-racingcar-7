package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    //라운드 결과 출력 메서드
    public static void printRaceStatus(List<Car> cars){
        for(Car car: cars){
            System.out.println(car.getName()+" : ");
            printPosition(car.getPosition());
        }
        System.out.println();
    }
    //자동차 위치 '-'로 표시하는 메소드
    private static void printPosition(int position){
        for(int i =0; i<position; i++){
            System.out.println("-");
        }
        System.out.println();
    }
}
