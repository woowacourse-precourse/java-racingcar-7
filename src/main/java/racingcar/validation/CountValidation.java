package racingcar.validation;

public class CountValidation {

    public int convertToNaturalNum(String stringCount){
        try {
            int count = Integer.parseInt(stringCount);
            if(count <= 0){
                throw new IllegalArgumentException("입력한 횟수가 자연수가 아닙니다.");
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력한 횟수가 자연수가 아닙니다.");
        }
    }

}
