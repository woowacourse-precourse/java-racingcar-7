package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    String name;
    int moves = 0; // 전진 횟수
    StringBuilder skidMark = new StringBuilder();

    public Car(String name) {
        this.name = name;
        skidMark.append(name).append(" : ");
    }

    public void forward() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            moves++;
            skidMark.append("-");
        }
        printSkidMark();
    }

    public void printSkidMark() {
        System.out.println(skidMark);
    }
}
