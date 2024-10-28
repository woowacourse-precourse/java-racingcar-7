package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {
    public ResultView(){
    }
    public void showResult(List<Car>carList){
        StringBuilder ret = new StringBuilder();
        for (Car car : carList){
            ret.append(car.getName()).append(" : ");
            for(int i = 0; i<car.getPosition(); i++){
                ret.append("-");
            }
            ret.append("\n");
        }
        System.out.println(ret);
    }


}
