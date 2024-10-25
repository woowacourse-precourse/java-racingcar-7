package racingcar.validator;

public class TrialValidator implements Validator<String>{

    private int trial;
    private static final int MINIMUM_TRIAL_COUNT = 0;

    @Override
    public void validate(String input){
        parseTrial(input);
        checkIfTrialIsNegative();
    }
    private void parseTrial(String trialString){
        try{
            this.trial = Integer.parseInt(trialString);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private void checkIfTrialIsNegative(){
        if(trial <= MINIMUM_TRIAL_COUNT){
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

}
