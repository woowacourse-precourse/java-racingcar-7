package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {

    public boolean moveOrStop(int randomNumber) {
        if (randomNumber >= 4 && randomNumber < 10) {
            return true;
        }
        if (randomNumber >= 0 && randomNumber < 4) {
            return false;
        }
        throw new IllegalArgumentException("무작위 값 설정에서 오류가 발생하였습니다");
    }

    public int randomNumberCreate() {
        return camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);
    }

    public List<RacingCar> getCarListFromInput(String input) {
        return convertRacingCarListFromNameList(getCarNameList(input));
    }

    public List<String> getCarNameList(String input){
        return List.of(input.split(","));
    }

    private List<RacingCar> convertRacingCarListFromNameList(List<String> carNameList){
        List<RacingCar> carList = new ArrayList<>();

        for (String s : carNameList) {
            carList.add(new RacingCar(s,""));
        }
        return carList;
    }


    public void increasingCurrentMovingPoint(RacingCar racingCar, int randomNum) {
        if (moveOrStop(randomNum)) {
            racingCar.currentMovingPoint += "-";
        }
    }
}
