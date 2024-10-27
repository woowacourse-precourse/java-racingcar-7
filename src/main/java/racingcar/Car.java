package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    String name;
    int count;

    public Car(String name) {
        this.name = name;
        this.count = 0;
    }

    public void move() {
        if(RandomNumberGenerator.pickRandomNumber() >= 4) {
            count ++;
        }
    }

    public void printCount() {
        System.out.print(name + " : ");
        for(int j=0;j<count;j++){
            System.out.print("-");
        }
    }
}
