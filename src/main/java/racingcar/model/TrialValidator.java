package racingcar.model;

public class TrialValidator {
    public static int validateTrial(String input){
        int trial;

        if(input == null || input.isEmpty()){
            throw new IllegalArgumentException();
        }

        try{
            trial = Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }

        if(trial <= 0){
            throw new IllegalArgumentException();
        }

        return trial;
    }
}
