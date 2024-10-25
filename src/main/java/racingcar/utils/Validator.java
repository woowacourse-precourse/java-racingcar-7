package racingcar.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static void isEmpty(String name) {
        if(name == null || name.trim().isBlank()){
            throw new IllegalArgumentException("자동차 이름에 빈칸은 입력할수 없습니다");
        }
    }

    public static void isCarNameRange(String name){
        if(name.length() > 5){
            throw new IllegalArgumentException("자동차의 이름은 5글자 이하만 가능합니다");
        }
    }

    public static void containDuplicate(List<String> names){
        Set<String> uniqueCars = new HashSet<>(names);
        if(uniqueCars.size() != names.size()){
            throw new IllegalArgumentException("자동차 이름은 중복될수 없습니다.");
        }
    }



}
