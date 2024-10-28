package VO;

public class CarVO {

    private String carName;
    private int position;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }


    @Override
    public String toString() {
        String resultText = carName + " : ";
        if (position > 0) {
            for (int i = 0; i < position; i++) {
                resultText += "-";
            }
        }
        return resultText;
    }
}
