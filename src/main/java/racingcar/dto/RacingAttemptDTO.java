package racingcar.dto;

public class RacingAttemptDTO {
    private int racingAttempts;

    public RacingAttemptDTO(String attemptsInput){
        this.racingAttempts = validateIntegerString(attemptsInput);
        validateLessThanOne();
    }

    private int validateIntegerString(String attemptsInput){
        try{
            return Integer.parseInt(attemptsInput);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("시도 횟수에는 정수를 입력해주세요");
        }
    }

    private void validateLessThanOne(){
        if(racingAttempts < 1)
            throw new IllegalArgumentException("시도 횟수는 1 이상이여야 합니다");
    }

    public int getRacingAttempts() {
        return racingAttempts;
    }
}
