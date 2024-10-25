# java-racingcar-precourse
 - - -
## 기능 구현 목록

### 1. 자동차 이름 입력 구현
 - 각 자동차에 이름을 부여하고 쉼표(,)를 기준으로 구분
 - 이름은 5자 이하만 가능
 - 잘못된 값 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션 종료
 - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console 의 readLine()을 활용

### 2. 이동 횟수 입력 구현
 - 사용자는 몇 번의 이동을 할 것인지 입력
 - 입력 메서드와 예외처리는 1번과 동일

### 3. 전진 메서드 구현
 - 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우
 - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용

### 4. 전진 결과 출력 메서드 구현
 - 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력

### 5. 우승자 출력 메서드 구현
 - 자동차 경주 게임을 완료한 후 누가 우승했는지 출력
 - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분하여 출력