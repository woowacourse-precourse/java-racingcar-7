package racingcar;

public class Car {
    private String name;
    private int position;

    public Car(String name){
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name){
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
        if(name.length() > 5){
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void move(int num){
        if(num >= 4){
            position++;
        }

        print();
    }

    private void print() {
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(" : ");
        builder.append("-".repeat(Math.max(0, position)));
        builder.append('\n');
        System.out.print(builder.toString());
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
