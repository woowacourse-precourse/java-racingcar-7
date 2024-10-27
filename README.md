# java-racingcar-precourse

-------
# 공통 피드백에서 잘 못지키는 것들 
- 디버거 사용 
- 이름을 통해 의도를 드러내자 
- 코드 포매팅 사용
  - Ctrl + Alt + L
# java-racingcar-precourse

---
# 공통 피드백에서 잘 못지키는 것들
- 디버거 사용
- 이름을 통해 의도를 드러내자
- 코드 포매팅 사용
  - `Ctrl + Alt + L`
# 👷기능 요구사항 정의
## Utils
- [x] **InputValidator**
  - [x] 사용자 입력을 검증
    - [x] 자동차 이름
      - [x] 적절한 입력을 제외하고 모두 에러처리 - 적절한 입력을 찾는 정규식 찾고 그 외의 경우 `IllegalArgumentException`
    - [x] 횟수
      - [x] 잘못된 입력을 받았을 때 `IllegalArgumentException`이 나오게 문자열을 입력으로 받고 정수인지 검증
- [] **InputParser**
  - [] 사용자 입력에서 CarName 을 파싱
## Domain
- [x] **Car**
  - [x] 이름, 위치
  - [x] 움직이는 동작 : move()
- [x] **Cars**
  - [x] 'car' 객체 리스트
  - [x] `car` 목록 관리
  - [x] `winner` 찾기  : findWinner()
     -[x] 최대 이동거리 찾기 : getMaxLocation()
- [x] **RacingGame**
  - [x] `Cars` 
  - [x] Random 값을 Car 전달 : game() 
- [x] **GameRule**
  - [x] 인터페이스
  - [x] isMovable()
  - [x] 현재는 RandomRule 구현체만 존재
## View
- [ ] **InputView**
  - [ ] 사용자의 입력을 받음
- [ ] **OutputView**
  - [ ] 게임 별 결과를 출력 (횟수 별)
    - [ ] 'Cars' 전달
  - [ ] 게임의 결과를 양식에 맞게 출력
    - [ ] 'Winner' 전달

## Controller
- [ ] **GameController**
  - [ ] Game 을 실행

---

## 추가된 코드 컨벤션 지키기
- `indent` <= 2
- 3항 연산자 사용 금지
- 함수(메서드)는 최대한 하는 일 작게 유지하기