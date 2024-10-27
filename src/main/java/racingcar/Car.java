package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void drive() {
        if (Randoms.pickNumberInRange(0, 9) >= 4){
            this.distance += 1;
        }
    }

    public void printDistance() {
        System.out.print(name + " : ");
        for(int i = 0; i < this.distance; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }
    
}
