package racingcar.service;

public class ValidService {

    public void valid(String s){
        if (s.length()>5){
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
    }




}
