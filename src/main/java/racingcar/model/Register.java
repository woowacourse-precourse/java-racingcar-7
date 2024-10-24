package racingcar.model;

import java.util.ArrayList;

public class Register {
    // 경주 할 자동차들 리스트 등록 기능
    // 자동차들의 전진 횟수 조회 기능
    // 우승자 조회 기능

    ArrayList<Car> carList;

    public Register() {
        this.carList = new ArrayList<>();
    }

    public void carListUp(ArrayList<String> participateCars) {
        for (String name : participateCars) {
            carList.add(new Car(name));
        }
    }
}
