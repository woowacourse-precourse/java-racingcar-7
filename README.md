# java-racingcar-precourse

## 기능구현 목록

### Car 객체 구현
 - Car 객체는 각 자동차의 이름, 위치, 실행결과를 관리한다.
 - Car 내부의 move 메서드를 이용하여 위치와 실행결과에 반영한다.

### Race 구현
 - Race 내부에 list를 이용하여 자동차 객체들을 관리한다.
 - inputCheck 메서드 내부에서 자바 정규식을 이용하여 입력값을 확인한다.
 - moveCars 메서드를 이용하여 주어진 횟수동안 경주 게임을 실시한다.
 - findWinners 메서드로 list 순회하여 최종우승자를 찾는다.
 - StringBuilder를 이용하여 실행결과를 한꺼번에 출력한다.