package racingcar;

import racingcar.RacingCar;

public class User {
    String name;
    int totalGo;

    User(String name) {
        this.name = name;
        totalGo = 0;
    }

    @Override
    public String toString() {
        String information = name + " : ";
        for (int i = 0; i < totalGo; i++) {
            information += "-";
        }
        return information;
    }
}
