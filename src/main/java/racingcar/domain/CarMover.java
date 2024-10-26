package racingcar.domain;

public class CarMover {
    public void moveCar(Car car) {
        int randomValue = generateRandomNumber();
        car.move(randomValue);
    }

    private int generateRandomNumber() {
        return camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);
    }
}
