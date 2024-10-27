package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }
    public boolean canMove(){
        int number = Randoms.pickNumberInRange(0,9);
        return number>=4;
    }
    public void printPosition() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" : ");
        for(int i = 0; i < position; i++) {
            sb.append("-");
        }
        System.out.println(sb);
    }
    public void move(){
        if(canMove()) {
            position++;
        }
    }
}
