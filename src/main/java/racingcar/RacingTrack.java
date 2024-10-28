package racingcar;

public class RacingTrack {
    String[] track;
    int carNumber;

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    public String[] getTrack() {
        return track;
    }

    public void startRacing(){
        track = new String[carNumber];
        for(int i = 0; i < carNumber; i++) {
            track[i] = "";
        }
    }

    public void moveCar(int movingCarNumber,String movingCar){
        track[movingCarNumber] += movingCar;
    }
}
