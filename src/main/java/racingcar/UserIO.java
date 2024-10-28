package racingcar;

public interface UserIO {
    public void setUserName(String readline);
    public void initStatus(String userName);

    public String getUserName();
    public int getMoveCount();

    public void move();

}
