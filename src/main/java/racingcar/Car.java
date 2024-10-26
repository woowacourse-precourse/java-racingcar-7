package racingcar;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Car {
    HashMap<String, Integer> carMap;

    public void set(){
        String inputString = UserView.readCarName();
        carMap = new HashMap<>();
        separateName(inputString);
    }

    public Map<String, Integer> get(){
        return this.carMap;
    }

    private void separateName(String input){
        checkDoubleSeparator(input);
        checkLastBlank(input);
        checkBlank(input);
        String[] splitInput = input.split(",");
        checkCount(splitInput.length);
        for (String s : splitInput) {
            checkNameLen(s);
            checkDuplication(s);
            putCarMap(s);
        }
    }

    private void checkCount(int countName){
        if (countName > 5){
            throwArgumentException("자동차는 최대 5대까지 출전 가능합니다.");
        }
    }

    // "a,b,c,,"이면 3개까지만 저장.
    // "a,b,,c"이면 공백 포함 4개로 저장되므로 이러한 오류 방지.
    private void checkDoubleSeparator(String input){
        if (input.contains(",,")){
            throwArgumentException("구분자는 한 개씩만 사용할 수 있습니다.");
        }
    }

    // "a,b,"이면 2개만 저장되는 오류 방지.
    private void checkLastBlank(String input){
        if (input.lastIndexOf(",") == input.length()-1){
            throwArgumentException("구분자 뒤에는 자동차 이름이 지정되어야 합니다.");
        }
    }

    private void checkBlank(String input){
        if (!Objects.equals(input, input.replaceAll("\\s", ""))){
            throwArgumentException("공백은 자동차의 이름에 포함될 수 없습니다.");
        }
    }

    private void checkNameLen(String input){
        if (input.length() > 5){
            throwArgumentException("자동차의 이름은 최대 5자입니다.");
        }
    }

    private void checkDuplication(String name){
        if (carMap.containsKey(name)){
            throwArgumentException("자동차의 이름은 중복될 수 없습니다.");
        }
    }

    private void putCarMap(String name){
        carMap.put(name, 0);
    }

    private void throwArgumentException(String errorContext){
        throw new IllegalArgumentException(errorContext);
    }
}