package racingcar.domain;

public class Position {

    private String position = "";

    public void forward() {
        position += "-";
    }

    public int positionDistance(){
        return position.length();
    }

    public String getPosition() {
        return position;
    }
}
