package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.gameuserdata.RacingUserData;

public class FindManyMovingRacingcar {
    public int FindManyMovingLength(List<RacingUserData> racingUserDataList) {
        return racingUserDataList.stream()
                .mapToInt(RacingUserData::getForwardPosition)
                .max().orElse(0);
    }

    public ArrayList<String> FindManyMovingCars(List<RacingUserData> racingUserDataList, int forwardPosition) {
        ArrayList<String> movingCars = new ArrayList<>();
        for (RacingUserData racingUserData : racingUserDataList) {
            if (FinalRacingUserPosition(racingUserData, forwardPosition)) {
                movingCars.add(racingUserData.getRacingUserName());
            }
        }
        return movingCars;
    }

    public boolean FinalRacingUserPosition(RacingUserData racingUserData, int forwardPosition) {
        return racingUserData.getForwardPosition() == forwardPosition;
    }
}
