package racingcar.splitter;

import java.util.ArrayList;
import java.util.List;
import racingcar.gameuserdata.RacingUserData;

public class RacingcarSplitter {

    public List<RacingUserData> racingUserDataSplitter(String[] racingCarNameArray) {
        List<RacingUserData> racingUserDataList = new ArrayList<>();
        for (String racingCarName : racingCarNameArray) {
            racingUserDataList.add(RacingUserData.of(racingCarName));
        }
        return racingUserDataList;
    }

}
