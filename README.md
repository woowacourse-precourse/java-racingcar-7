# java-racingcar-precourse

## 객체 모델링
![img.png](images/model.png)
## 클래스 다이어그램
![img.png](images/class_diagram.png)

## 기능구현목록

---
### MODEL
#### CarRace
- [ ] 각 자동차를 동작시킨다.
- [ ] 레이스에 참여한 자동차를 알려준다.
#### Car
- [ ] 자동차 이름을 검증한다.
  - 자동차 이름이 공백인 경우 에러
- [ ] 조건에 따라, 현재 위치를 한 칸 움직인다.
#### MoveCondition
- [ ] 조건이 만족되는지 판단한다.
#### NumberGenerator
- [ ] 랜덤 숫자를 생성한다.
#### RaceInfo
- [x] 자동차 이름을 검증한다.
  - 자동차 이름이 공백인 경우 에러
  - 자동차들간 이름이 중복이 발생한 에러
- [x] 총 시도 횟수를 검증한다.

---
## VIEW
#### InputView
- [ ] 사용자로부터 게임정보를 전달받는다.
- [ ] 사용자의 입력 형식을 검증한다.

#### OutputView
- [x] 입력 안내문을 출력한다.
- [ ] 레이스의 진행상태를 출력한다.
- [ ] 레이스의 우승자를 출력한다.

---
##  Controller
#### CarRaceController
-  [ ] 총 시도횟수 만큼 레이스를 진행한다.
-  [ ] 레이스가 종료 된 후, 우승자를 계산한다. 
---