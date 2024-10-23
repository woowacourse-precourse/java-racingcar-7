package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static int max = 0;
    String name;
    int value;

    public Car(String name){
        this.name = name;
        value = 0; // default value = 0
    }

    public int update(int updateValue){
        if(Randoms.pickNumberInRange(0,9) >= 4){
            value += updateValue;
            if(max < value)
                max = value;
        }
        return value;
    }

    public boolean isMax(){
        return value == max;
    }
}
