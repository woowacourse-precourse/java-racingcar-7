package racingcar.valid;

public class Valid {

    public void valid(String s){
        if (s.length()>5){
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
    }
    
    public void numValid(String s){

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9') {
                throw new IllegalArgumentException("숫자가 아닙니다");
            }
        }
        }
        

}
