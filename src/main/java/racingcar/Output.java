package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Output {
    private int max = 0;
    List<Car> carList;

    public Output(List<Car> carList) {
        this.carList = carList;
    }

    public void printOutput() {
        List<String> resultList = new ArrayList<>();

        setMax();
        addList(resultList);
        printWinner(resultList);
    }

    private void printWinner(List<String> resultList) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < resultList.size(); i++) {
            System.out.print(resultList.get(i));
            if (i != resultList.size() - 1) {
                System.out.print(", ");
            }
        }
    }

    private void setMax() {
        for(Car car : carList) {
            if(car.getPosition() > max) {
                max = car.getPosition();
            }
        }
    }

    private void addList(List<String> resultList) {
        for(Car car : carList) {
            if(car.getPosition() == max) {
                resultList.add(car.getName());
            }
        }
    }
}
