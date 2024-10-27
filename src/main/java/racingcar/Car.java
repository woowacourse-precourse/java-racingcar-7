package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    String name;
    int distance;

    public Car(String name){
        this.name = name;
        distance = 0;
    }

    public void move(){
        if(canMove())
            distance++;
    }

    private boolean canMove(){
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public void printCurrentDistance(){
        System.out.print(name + " : ");
        for(int i = 0; i < distance; i++){
            System.out.print('-');
        }
        System.out.println();
    }
}
