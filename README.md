# 도메인 별 요구사항 정리

### Car 도메인

- [x] ~~자동차는 4 이상의 수가 주어지면 움직인다~~
- [x] 자동차는 이동 전략(MovingStrategy) 의 movable() 메서드가 true 면 움직인다.
- [x] 자동차 이름 길이는 5 이하여야 한다.

### 이동 전략

- [x] 이동 전략은 movable() 추상 메서드를 가지며, 디폴트 구현체로는 랜덤값에 따라 움직이는 DefaultMovingStrategy 가 있다

### Cars 일급 컬렉션

- [x] 자동차 이름은 중복 될 수 없다 (우승자가 여러 명 일 수 있다는 요구사항이 있으므로, 구분이 필요 할 것이다)


---

# 입출력 요구사항 정리

- [x] 이름 입력 전 "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" 라는 문구가 출력된다
- [x] 사용자는 자동차(들)의 이름을 입력한다.
- [x] 자동차의 이름이 입력되면, 쉼표를 통해서 N 개의 이름을 구분한다 (Ex : "pobi,json" == {pobi,json})
- [x] 이동 횟수 입력 전 "시도할 횟수는 몇 회인가요?" 라는 문구가 출력된다
- [x] 레이싱 결과 출력 전에 "실행 결과" 라는 문구가 출력된다
- [x] 레이싱 결과 데이터를 받아서 출력용 String 으로 바꾼다.
- [x] 자동차 이름은 공백이어도 무방하다. (따라서 공백을 없애지 않는다)
- [x] 자동차 이름은 빈 값일 수 없다.
- [x] 사용자가 입력한 이동횟수는 양의 정수여야 한다. 다른 값은 예외다.







---

# 구현 전 정리한 요구사항 리스트

## 1. 도메인 관련

- [ ] 자동차는 이름을 가진다.
- [ ] 자동차는 위치를 가진다.
- [ ] 위치가 제일 높은 자동차 N 대는 우승자이다

- [ ] 자동차의 이동 기준은 랜덤값이다. 값이 4 이상이면 이동한다.
- [ ] 레이싱 결과 출력 전에 "실행 결과" 라는 문구가 출력된다

## 2. 입출력 관련

- [ ] 사용자는 자동차(들)의 이름을 입력한다.
- [ ] 자동차의 이름이 입력되면, 쉼표를 통해서 N 개의 이름을 구분한다 (Ex : "pobi,json" == {pobi,json})
- [ ] 사용자는 몇 번의 이동을 할 것인지 입력한다.
- [ ] 레이싱이 한 라운드 끝날 때 마다, 실행 과정을 출력한다.
- [ ] 레이싱이 끝나면 결과를 출력한다.
- [ ] 우승자가 여러 명 일 경우, "이름1, 이름2"와 같이 한 개의 SPACE 를 준다.

## 3. 예외사항들

- [ ] 자동차 이름은 공백이어도 무방하다. (따라서 공백을 없애지 않는다)
- [ ] 자동차 이름은 빈 값일 수 없다.
- [x] 자동차 이름은 중복 될 수 없다 (우승자가 여러 명 일 수 있다는 요구사항이 있으므로, 구분이 필요 할 것이다)
- [ ] 사용자가 입력한 이동횟수는 양의 정수여야 한다. 다른 값은 예외다.
- [ ] 모든 차가 거리를 0만큼 이동하면 공동우승이다.