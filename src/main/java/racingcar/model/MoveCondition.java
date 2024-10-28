package racingcar.model;

public class MoveCondition {
    private final int minNumber;
    private NumberGenerator numberGenerator;

    public MoveCondition(int minNumber){
        this.minNumber = minNumber;
        this.numberGenerator = new NumberGenerator(0, 9);
    }

    public Boolean isSatisfied(){
        int randomNumber = this.numberGenerator.getRandomNumber();
        return randomNumber >= this.minNumber;
    }
}
