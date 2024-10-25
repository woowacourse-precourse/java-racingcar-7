package racingcar;

public class DataInfo implements UserIO{
    private String readData;

    @Override
    public String getReadline() {
        return this.readData;
    }

    @Override
    public void setReadline(String readline) {
        this.readData = readline;
    }

}
