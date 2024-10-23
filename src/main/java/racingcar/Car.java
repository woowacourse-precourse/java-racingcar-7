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





}
