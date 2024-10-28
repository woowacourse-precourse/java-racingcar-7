package racingcar;

public class Pair {
    private int x;
    private String y;
    Pair(int x, String y) {
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public void goForward(){
        this.x++;
    }
    public String getY(){
        return y;
    }
}
