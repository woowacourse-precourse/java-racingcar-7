package racingcar.model;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RaceStadium {

    private List<RacingCar> racingCars = new ArrayList<>();

    public void addRacingCars(List<RacingCar> racingCars){
        this.racingCars.addAll(racingCars);
    }

    public void moveRacingCars(){
        racingCars.forEach(this::moveRacingCarWithRandom);
    }

    private void moveRacingCarWithRandom(RacingCar racingCar){
        boolean canMove = getRandomBoolean();
        if(canMove){
            racingCar.moveForward();
        }
    }

    private boolean getRandomBoolean(){
        if (Randoms.pickNumberInRange(0,9) < 4) return false;
        return true;
    }

    public List<String> getWinnerList() {
        // 가장 많이 움직인 RacingCar 객체들의 이름 가져오기
        int maxLocation = racingCars.stream()
                .mapToInt(RacingCar::getMovedDistance)
                .max()
                .orElseThrow(IllegalArgumentException::new);

        List<String> maxLocationCars = racingCars.stream()
                .filter(car -> car.getMovedDistance() == maxLocation)
                .map(car -> car.name)
                .toList();

        return maxLocationCars;
    }
}