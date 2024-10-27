package racingcar.dto;

// 몇 라운드에 어느 위치 였는지 로그 기록
public class PlayerStat {
    private int round;
    private String carName;
    private int position;

    public PlayerStat(int round, String carName, int position) {
        this.round = round;
        this.carName = carName;
        this.position = position;
    }

    public int getRound() {
        return round;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
