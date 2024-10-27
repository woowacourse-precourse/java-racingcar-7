package gameManager;

import camp.nextstep.edu.missionutils.Randoms;

//랜덤 값 반환, 랜덤 값 판단(4 이상인지), 점수 반환(0, 1)
public class ScoreManager {

    //랜덤 값 반환
    public int getRandomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }

    //랜덤 값 판단과 반환
    public int getScore(int number){
        if(number>=4){
            return 1;
        }else{
            return 0;
        }
    }
}
