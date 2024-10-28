package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class DataInfo implements UserIO{
    private String userName;
    private int moveCount;

    @Override
    public void initStatus(String userName) {
        this.userName = userName;
        this.moveCount = 0;
    }

    @Override
    public void setUserName(String readline) {
        this.userName = readline;
    }

    @Override
    public String getUserName(){
        return this.userName;
    }

    @Override
    public int getMoveCount(){
        return this.moveCount;
    }

    @Override
    public void move(){
        if(Randoms.pickNumberInRange(0,9) > 4) this.moveCount++;
    }


}
