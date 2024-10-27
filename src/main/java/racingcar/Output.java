package racingcar;


import java.util.ArrayList;
import java.util.List;

public class Output {
    List<Car> carList;

    public Output(List<Car> carList) {
        this.carList = carList;
    }

    public void printOutput() {
        int max = 0;
        List<String> resultList = new ArrayList<>();

        for(Car car : carList) {
            if(car.getPosition() > max) {
                max = car.getPosition();
            }
        }

        for(Car car : carList) {
            if(car.getPosition() == max) {
                resultList.add(car.getName());
            }
        }

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < resultList.size(); i++) {
            System.out.print(resultList.get(i));
            if (i != resultList.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
