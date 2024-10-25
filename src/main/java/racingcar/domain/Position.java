package racingcar.domain;

public class Position {

    private String position;

    private Position() {
        this.position = "";
    }

    public void forward() {
        position += "-";
    }

    public int positionDistance(){
        return position.length();
    }

    public String getPosition() {
        return position;
    }

    public static Position from() {
        return new Position();
    }


}
