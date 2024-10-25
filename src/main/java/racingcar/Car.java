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
        String[] splitInput = input.split(",");
        checkCount(splitInput.length);
        for (String s : splitInput) {
            checkBlank(s);
            checkDuplication(s);
            putCarMap(s);
        }
    }

    private void checkCount(int n){
        if (n > 5){
            throwArgumentException("자동차는 최대 5대까지 출전 가능합니다.");
        }
    }

    private void checkDuplication(String name){

    }

    private void checkBlank(String name){

    }

    private void putCarMap(String name){

    }

    private void throwArgumentException(String errorContext){
        throw new IllegalArgumentException(errorContext);
    }
}
