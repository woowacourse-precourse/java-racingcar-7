package racingcar.modle.rule;

public class GameRule implements Rulable {

    @Override
    public Boolean isMove(int movingStandard){
        if(movingStandard >= 4){
            return true;
        }
        return false;
    }


}
