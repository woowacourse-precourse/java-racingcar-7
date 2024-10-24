# java-racingcar-precourse

### 구현할 기능 목록
1. 자동차 이름 입력받기 (잘못된 값이 입력된 경우, IllegalArgumentException 발생)
2. 진행할 횟수 입력받기 (잘못된 값이 입력된 경우, IllegalArgumentException 발생)
3. 입력받은 이름의 개수만큼 자동차 객체 생성
4. 입력받은 횟수만큼 게임 진행
5. 우승자 선별하고 출력하기

### 구현할 클래스 정의
- RacingCarGame 클래스 : 프로그램의 대문역할을 할 클래스
- InputNames 클래스 : 이름을 입력받고 리스트로 저장할 클래스
- InputTry 클래스 : 시도 횟수를 입력받는 클래스
- RacingCarService 클래스 : 게임의 주요로직을 캡슐화할 클래스
- Car 클래스 : 생성할 차의 클래스
- CreateCar 클래스 : 차 객체를 생성할 클래스
- PlayGame 클래스 : 시도 횟수만큼 게임을 진행할 클래스
- PrintWinner 클래스 : 우승자를 선별하고 출력할 클래스