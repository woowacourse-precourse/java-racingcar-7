package racingcar.domain;

import static racingcar.message.ErrorMessage.INVALID_NATURAL_NUMBER;

public class TryCount {
    private final int count;
    private static final int MIN_COUNT_NUMBER = 1;
    public TryCount(String count){
        try{
            this.count = Integer.parseInt(count);
        }catch (NumberFormatException e) {
            throw new IllegalAccessError(INVALID_NATURAL_NUMBER.getMessage());
        }
        validateCount(this.count);
    }
    private static void validateCount(int count){
        if(count < MIN_COUNT_NUMBER){
            throw new IllegalArgumentException(INVALID_NATURAL_NUMBER.getMessage());
        }
    }
    public int getTryCount(){
        return count;
    }
}
