package racingcar;

public class Validator {
    public void isValidNumberOfRounds(String input){
        if(input.isEmpty()){
            throw new IllegalArgumentException("시도할 횟수를 입력해주세요");
        }
        try{
            int numberOfRounds = Integer.parseInt(input);
            if(numberOfRounds<=0){
                throw new IllegalArgumentException("시도 할 횟수는 1 이상이어야 합니다");
            }
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("시도 할 횟수는 정수이어야 합니다");
        }
    }
}
