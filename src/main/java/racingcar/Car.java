package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public int move;
    public String name;

    public Car(String name){
        this.name = name;
        move = 0;
    }

    public void moveCar(){
        if(Randoms.pickNumberInRange(0,9)>=4)
            move += 1;

    }

    public void printCar(){
        System.out.println(String.join(" : ",name,"-".repeat(move)));
    }
}
