# java-racingcar-precourse
## 파일 구조
```
racingcar
┣ controller
┃ ┗ RacingCarController.java
┣ domain
┃ ┣ Car.java
┃ ┣ Cars.java
┃ ┣ Name.java
┃ ┗ Position.java
┣ exception
┃ ┗ ExceptionMessage.java
┣ service
┃ ┣ RacingCarService.java
┃ ┗ TryCount.java
┣ view
┃ ┣ InputView.java
┃ ┗ OutputView.java
┗ Application.java
```

## 자동차 경주 구현 사항
### 입력 구현 사항
- [X] 경주할 자동차 이름 입력받기
- [X] 시도할 횟수 입력받기

### 입력 예외 구현 사항
- [X] 자동차 이름이 공백이거나 5자 초과면 `IllegalArgumentException` 발생시키기
- [X] 자동차 이름이 중복될 경우 `IllegalArgumentException` 발생시키기
- [X] 시도 횟수가 양의 정수가 아닐 경우 `IllegalArgumentException` 발생시키기

### 비즈니스 로직 구현 사항
- [X] 시도 횟수만큼 로직 진행하기
- [X] 0에서 9사이의 random값을 구한 후 3 이하면 정지, 4 이상이면 전진하기
- [X] 종료 후 가장 많이 전진한 이름 찾기

### 출력 구현 사항
- [X] 자동차의 이름을 입력받는 문구 출력하기
- [X] 시도 횟수를 입력받는 문구 출력하기
- [X] 각 차수별 진행 사항 출력하기
- [X] 종료 후 우승자 목록 출력하기