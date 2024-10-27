package racingcar.valid;

public class Valid {
    public Valid(String s) {
        if (s.length()>5){
            throw new IllegalArgumentException("자동차의 이름은 5글자를 초과할 수 없습니다.");
        }
    }
}
