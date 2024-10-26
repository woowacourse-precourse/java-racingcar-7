# java-racingcar-precourse

# 구현할 기능 목록
## 입력
-  자동차 입력
    -  "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" 출력
    -  Console.readLine() 활용
-  진행할 라운드
    -  Console.readLine() 활용

## 출력
-  계산된 거리에 따라 '-' 출력
    -  "실행 결과" 출력
    -  [자동차 이름 : '-' * n] 형식으로 출력
-  우승자 출력
    -  우승자가 여려명이면 쉼표(,)로 구분
    -  [최종 우승자 : 자동차 이름] 형식으로 출력

## 기능
-  자동차 
    -  0에서 9 사이 난수 생성
    -  Randoms.pickNumberInRange() 활용
    -  4 이상이면 전진, 아니면 멈춤으로 판단
    -  생성된 난수가 4인지 아닌지 판단
-  심판 
    -  car 객체들의 movement를 비교하여 List<Car> winnerCars로 반환
## 테스트 코드
-  테스트 코드 작성

## 예외처리 (IllegalArgumentException)
-  자동차 생성
  -  값이 안 들어올 때
  -  이름 5자 초과일 때
  -  같은 이름을 가진 자동차가 있을 때
-  라운드 수 예외 처리
    -  숫자가 아닐 때
    -  0 혹은 음수일 때
    -  정수가 아닐 때
    -  null 값일 때

# MVC 패턴 구조

### Main
- [ ] Application
### Model
- [x] Car
- [ ] Cars
- [ ] Referee
- [x] StringSplitter
- [x] RandomNumberGenerator
### View
- [ ] InputView
- [ ] OutputView
### Controller
- [ ] RacingCarGameController
### Enum
- [x] Separator
### Util
- [x] CarNameValidator
- [x] MoveCountValidator
- [x] ErrorMessage

