package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int RANDOM_MIN_NUMBER = 0;
    private static final int RANDOM_MAX_NUMBER = 9;
    private static final int FORWARD_MIN_NUMBER = 4;

    private String name;
    private String bar;

    public Car(String name){
        this.name = name;
        this.bar = "";
    }

    //4이상이면 전진
    public String forwardBar(){
        if(randomNumber()){
            bar += "-";
        }
        return name + " : " + bar;
    }

    //전진하는 조건
    private boolean randomNumber(){
       return Randoms.pickNumberInRange(RANDOM_MIN_NUMBER,RANDOM_MAX_NUMBER)>=FORWARD_MIN_NUMBER;
    }

    public int getBarLength(){
        return this.bar.length();
    }
    public String getNmae(){
        return this.name;
    }




}
