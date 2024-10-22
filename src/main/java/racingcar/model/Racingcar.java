package racingcar.model;

public class Racingcar {

    //TODO 실행 부분 구현
    public String execution(String input){
        if(input == null || input.isEmpty()){
            throw new IllegalArgumentException("입력 값이 이상합니다");
        }
        return "0";
    }
}
