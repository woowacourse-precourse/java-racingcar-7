package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    public void racingView(List<Car> cars){
        for(Car car : cars){
            StringBuilder positionMark = new StringBuilder();
            for(int i=0; i<car.getPosition(); i++){
                positionMark.append("-");
            }
            System.out.println(car.getName() + " : " + positionMark);
        }
        System.out.println();
    }

    public void resultView(List<String> cars){
        String winnerCars = String.join(",", cars);
        System.out.println("최종 우승자 : " + winnerCars);
    }

}
