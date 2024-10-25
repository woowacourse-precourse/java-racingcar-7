package racingcar.validator;

public class TrialValidator implements Validator<String>{

    private int trial;
    private static final int ZERO = 0;
    private static final String REGEX = "[^0-9]";

    @Override
    public void validate(String input){
        setTrial(input);
        checkIfTrialIsNegative();
    }
    private void setTrial(String trialString){
        checkIfTrialIsInt(trialString);
        this.trial = Integer.parseInt(trialString);
    }

    private void checkIfTrialIsInt(String trialString){
        if(trialString.matches(REGEX)){
            throw new IllegalArgumentException();
        }
    }

    private void checkIfTrialIsNegative(){
        if(trial <= ZERO){
            throw new IllegalArgumentException();
        }
    }

}
