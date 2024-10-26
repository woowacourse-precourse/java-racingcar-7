package racingcar.utils;

import java.util.List;

public class Validator {

    public void isValidName(List<String> names){
        for(String name: names) {
            if(name.length()>5) throw new IllegalArgumentException("잘못된 입력 형식입니다.(이름은 5자 이하만 가능)");
        }
    }
}
