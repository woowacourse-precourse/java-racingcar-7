# java-racingcar-precourse

## 🔧 구현 기능 목록
- [X]  자동차 이름, 게임 시도 횟수 입력 받음 
    - [X]  자동차 이름이 5자 이내인지 Validate 검증    
         검증 실패 경우 `IllegalArgumentException` 발생시킴

    - [X]  게임 시도 횟수 1 이상인지 검증    
         검증 실패의 경우  `IllegalArgumentException` 발생시킴
- [X]  자동차 공장으로 입력 받은 이름 갯수만큼 자동차를 생성한다.
- [X]  총 자동차 갯수가 1 개 이하인 경우 `IllegalArgumentException` 발생시킴
- [X]  게임을 횟수만큼 진행한다.
    - [X]  Random 값을 생성하고 4이상인 경우 전진 미만인 경우 멈춤 상태를 유지한다.
- [X] 자동차 경주 위치를 출력한다. 
- [X]  우승자를 출력한다.
    - [X]  우승자가 여러 명일 경우 쉼표를 이용하여 구분