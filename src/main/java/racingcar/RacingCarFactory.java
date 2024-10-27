package racingcar;

import java.util.ArrayList;

public class RacingCarFactory {

    public static ArrayList<RacingCar> createRacingCarGroup(ArrayList<String> playerGroup){
        ArrayList<RacingCar> racingCarGroup = new ArrayList<>();

        for(String name : playerGroup){
            racingCarGroup.add(new RacingCar(name));
        }

        return racingCarGroup;
    }

}
