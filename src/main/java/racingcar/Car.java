package racingcar;

public class Car {
    // 필드
    public String name;
    public int dashCount;

    // 생성자
    public Car(String name) {
        this.name = name;
        this.dashCount = 0;     // "-" 개수 0으로 초기화
    }

    // 이름 반환 메소드
    public String getName() {
        return name;
    }

    // 자동차 전진 메소드
    public void move() {
        moveDashCount();
        printDash(dashCount);
    }

    // 자동차 정지 메소드
    public void stop() {
        stopDashCount();
        printDash(dashCount);
    }

    // 전진 시 "-" 개수 반환 메소드
    public int moveDashCount() {
        dashCount++;
        return dashCount;   // 증가된 "-" 개수 반환
    }

    // 정지 시 "-" 개수 반환 메소드
    public int stopDashCount() {
        return dashCount;   // 변화 없음 (현재 "-" 개수 반환)
    }

    // 개수만큼 "-" 출력 메소드
    public void printDash(int dashCount) {
        for (int i = 0; i < dashCount; i++) {
            System.out.print("-");      // dashCount 개수만큼 "-" 출력
        }
    }
}