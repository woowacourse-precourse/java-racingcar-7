package racingcar.model;

public class MoveCondition {
    private final int MIN_NUMBER;
    private NumberGenerator numberGenerator;

    public MoveCondition(int minNumber){
        this.MIN_NUMBER = minNumber;
        this.numberGenerator = new NumberGenerator(0, 9);
    }

    public Boolean isSatisfied(){
        int randomNumber = this.numberGenerator.getRandomNumber();
        return randomNumber >= this.MIN_NUMBER;
    }
}
