package racingcar.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public void isValidInput(String input){
        if(input.isEmpty()) throw new IllegalArgumentException("값을 입력해 주세요.");
    }

    public void isValidName(List<String> names){
        Set<String> uniqueNames = new HashSet<>();
        for(String name : names) {
            if (name.contains(" ")) {throw new IllegalArgumentException("자동차 이름에는 공백이 포함될 수 없습니다.");}
            if(name.length() > 5) {throw new IllegalArgumentException("자동차 이름은 5글자 이하로 입력해 주세요.");}
            if(!uniqueNames.add(name)) {throw new IllegalArgumentException("중복되는 이름을 가진 자동차가 있습니다.");}
        }
    }

    public Integer isValidCount(String count){
        try {
            int countValue = Integer.parseInt(count);
            if (countValue <= 0) {throw new IllegalArgumentException("시도할 횟수는 양의 정수여야 합니다.");}
            return countValue;
        } catch (NumberFormatException e) {throw new IllegalArgumentException("시도할 횟수는 양의 정수여야 합니다.", e);}
    }
}
