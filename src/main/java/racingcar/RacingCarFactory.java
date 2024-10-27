package racingcar;

import java.util.ArrayList;

public class RacingCarFactory {

    public static ArrayList<RacingCar> createRacingCarGroup(ArrayList<String> playerGroup){
        final int GROUP_SIZE = playerGroup.size();

        ArrayList<RacingCar> racingCarGroup = new ArrayList<>();
        for(int i = 0; i < GROUP_SIZE; i++){
            racingCarGroup.add(new RacingCar(playerGroup.get(i)));
        }

        return racingCarGroup;
    }

}
