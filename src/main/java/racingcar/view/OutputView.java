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

    public void printFinalWinner(ArrayList<Car> cars){
        StringBuilder output = new StringBuilder();
        output.append("최종 우승자 : ");
        for (int i = 0; i < cars.size(); i++){
            if(i!=0){
                output.append(", ");
            }
            output.append(cars.get(i).getName());

        }
        output.append("\n");
        System.out.println(output);
    }
}
