package racingcar;

public class Car {
    // 자동차의 이름과 위치를 저장

    private String name;  // 자동차 이름 저장
    private int position; // 현재 위치 저장(전진 횟수)

    // 생성자 : 이름을 받아서 자동차를 생성, 이름이 5자 이상시 예외발생
    public Car(String name){
        if (name.length() > 5){
            throw new IllegalArgumentException(" 자동차 이름은 5자 이하 입니다 ");
        }
        this.name = name;
        this.position = 0;  // 시작위치 0 으로 초기화
        
    }

    // 전진 여부를 결정하는 메서드 ,  무작위 값으로 4이상 일때만 전진
    public void move(){
        int randomValue = (int) (Math.random() * 10); // 0~9 사이의 값을 랜덤으로 생성
        if(randomValue >= 4 ){  // 4 이상이면 전진
            position++;
        }

    }

    // 현재 자동차의 위치를 "-"  로 표현한다
    public String getPosition(){
        return "-".repeat(position); // position 값만큼 "-" 를 출력한다
    }

    // 자동차의 이름을 반환하는 메서드
    public String getName(){
        return name;
    }

    // 자동차의 위치 값을 반환하는 메서드
    public int getPositionValue(){
        return position;
    }

}
