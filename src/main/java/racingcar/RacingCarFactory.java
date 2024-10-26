package racingcar;

public class RacingCarFactory {

    public static RacingCar[] createRacingCarGroup(String[] playerGroup){
        final int GROUP_LENGTH = playerGroup.length;

        RacingCar[] createdRacingCar = new RacingCar[GROUP_LENGTH];
        for(int i = 0; i < GROUP_LENGTH; i++){
            createdRacingCar[i] = new RacingCar(playerGroup[i]);
        }

        return createdRacingCar;
    }

}
