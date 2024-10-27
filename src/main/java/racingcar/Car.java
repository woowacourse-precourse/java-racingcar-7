package racingcar;

public class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }
    public String getName() {
        return name;
    }
    public int getPosition() {
        return position;
    }
    public boolean canMove(){
        long currentTime = System.currentTimeMillis();
        int number = (int)(currentTime%10);
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
}
