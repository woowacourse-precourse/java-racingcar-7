package model;

public class Car {
    private final String name; // 이름을 변경할 일은 없음.
    private int positon;


    public Car(String name) {
        this.name = name;
        this.positon = 0;
    }

    public void move(boolean con) {
        if(con) positon++;
    }

    // Object 클래스의 toString함수를 오버라이드
    @Override
    public String toString() {
        return name + " : " + "-".repeat(Math.max(0, positon));
    }
}

/*
    JAVA에서의 문자열 더하기에 관하여.
         str +=  "-";   java에서는 문자열이 불변이기에 매번 새로운 문자열 객체를 만들게 됨. (비효율적)
         StringBuffer 멀티스레드 환경에서 안전한 방식으로 동기화가 추가되어 있음.
         String.join() 배열이나 리스트를 특정 구분자로 연결해 문자열로 만들 때 사용
         Collectors.joining() 리스트의 요소들을 문자열로 합칠 때 사용
         단일 스레드, 문자열을 많이 이어붙이는 상황에서 사용.
         더 하는 문자열이 많은 경우에는 StringBuilder를 사용하는 방식 권장.
         여기서는 그 양이 적기에 String에 직접적으로 사용
 */
