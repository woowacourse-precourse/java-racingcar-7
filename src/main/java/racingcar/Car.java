package racingcar;

public class Car {
    private final CarName name;
    private final MoveStrategy moveStrategy;
    private int position;

    public Car(String name, MoveStrategy moveStrategy) {
        this.name = new CarName(name); // 자동자는 자동차 이름을 저장할 뿐 내부에서 어떤 일이 일어나는지 관심 없음.
        this.position = 0;
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        if (moveStrategy.isMovable()) {
            position++;
        }
    } // 메서드 네이밍은 길어도 상관없지만 무엇을 하는지 알려줘야한다. 한번더 생각해보면 누구 입장에서?
    // 카 입장에서 무엇을 하는지 알려줘야할까요?
    // 쓰는 입장에서 알려줘야 할까요?
    //car.check***(); // 캡슐화 위반
    // 바깥에 사용하는 주체가 내부에 움직이는 전략이 있다는 사실을 알게됨.


    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position;
    }
}
