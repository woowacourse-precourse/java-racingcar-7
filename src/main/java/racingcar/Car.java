package racingcar;

import java.util.Map;

public class Car {
    Map<String, Integer> carMap;
    public void set(){
        separateName(UserView.readCarName());
    }
    public Map<String, Integer> get(){
        return this.carMap;
    }
    private void separateName(String input){
        checkBlank("");
        checkDuplication("");
        count(0);
    }
    private void checkDuplication(String name){

    }
    private void count(int n){

    }
    private void checkBlank(String name){

    }
}
