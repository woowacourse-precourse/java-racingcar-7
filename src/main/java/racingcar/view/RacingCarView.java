package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

import java.util.List;

public class RacingCarView {

    public String[] readInput(){
        return Console.readLine().split(",");
    }

    public void printStarting(){
        System.out.println("실행 결과");
    }
    public void printEachGame(List<Car> cars){
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + printPosition(car.getPosition()));
        }
    }

    private String printPosition(int position){
        return "-".repeat(position);
    }
}
