package racingcar.feature;

import racingcar.obj.Car;

import java.util.List;

public class Winner {

    StringBuilder sb;
    int max;

    public Winner() {
        sb = new StringBuilder();
    }

    public void getWinner(List<Car> cars) {
        sb.append(cars.get(0).getName());
        max = cars.get(0).getDistance();

        for (int i = 1; i < cars.size(); i++) {
            if (cars.get(i).getDistance() > max) {
                sb.setLength(0);
                sb.append(cars.get(i).getName());
                max = cars.get(i).getDistance();
            } else if (cars.get(i).getDistance() == max) {
                sb.append(",").append(cars.get(i).getName());
            }
        }

        System.out.println("최종 우승자 : " + sb.toString());
    }

}
