package racingcar.valid;

public class Valid {

    public void valid(String s){
        if (s.length()>5){
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
    }




}
