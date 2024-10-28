package racingcar.Model;

import racingcar.Constants;

public class RoundNumValidator {
    public String ROUNDNUM_STRING;

    public RoundNumValidator(String inputString){
        this.ROUNDNUM_STRING = inputString;
        validate();
    }
    private void validate(){
        checkInt();
    }
    private void checkInt(){
        if(!Constants.roundNumStringPattern.matcher(ROUNDNUM_STRING).matches()){
            throw new IllegalArgumentException(Constants.ROUND_NUM_WRONG);
        }
    }
}
