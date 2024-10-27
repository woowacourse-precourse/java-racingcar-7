package racingcar.model;

import java.util.Arrays;

public class ExceptionClass extends Exception {
    private final static ExceptionClass instance = new ExceptionClass();
    private ExceptionClass() {}
    public static ExceptionClass getInstance() {
        return instance;
    }
    public void validateString(String[] string){
        checkStringBlank(string);
        checkStringLength(string);
    }
    public void checkStringLength(String[] string){
        for(String str : string){
            if(str.length() > 5){
                throw new IllegalArgumentException("String length can't be greater than 5");
            }
        }
        //stream은 for문 보다 시간이 오래걸린다는 단점이 있으므로 사용하지 않았습니다.
        //if(Arrays.stream(string).filter((e)->e.length()>5).count()>5){
        //      throw new IllegalArgumentException("String length can't be greater than 5");
        //}
    }
    public void checkStringBlank(String[] string){
        //입력이 공백만 존재하는경우 ( 이름을 공백으로 입력한 경우 테스트 )
        //남은 값은 빈 문자열이므로 그것을 검사
        if(string.length == 0){
            throw new IllegalArgumentException("String can't be empty");
        }
    }
}