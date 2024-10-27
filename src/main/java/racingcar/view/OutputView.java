package racingcar.view;

import java.util.ArrayList;
import racingcar.model.Car;

public class OutputView {
    public void printResult(){
        System.out.println("실행 결과");
    }

    public void printCarStatus(ArrayList<Car> cars){
        StringBuilder output = new StringBuilder();

        for (Car car : cars){
            output.append(car.getName()).append(" : ");

            for (int i = 0; i < car.getDistance(); i++) {
                output.append("-");
            }
            output.append("\n");
        }

        System.out.println(output);
    }

    public void printFinalWinner(String s){
        System.out.println("최종 우승자 : "+ s);
    }
}
