package racingcar.feature;

import racingcar.obj.Car;

public class Winner {

    StringBuilder sb;
    int max;

    public Winner() {
        sb = new StringBuilder();
    }

    public void getWinner(Car[] cars) {
        sb.append(cars[0].getName());
        max = cars[0].getDistance();

        for (int i = 1; i < cars.length; i++) {
            if (cars[i].getDistance() > max) {
                sb.setLength(0);
                sb.append(cars[i].getName());
                max = cars[i].getDistance();
            } else if (cars[i].getDistance() == max) {
                sb.append(",").append(cars[i].getName());
            }
        }

        System.out.println("최종 우승자 : " + sb.toString());
    }

}
