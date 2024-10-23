# java-racingcar-precourse

-------
# 공통 피드백에서 잘 못지키는 것들 
- 디버거 사용 
- 이름을 통해 의도를 드러내자 
- 코드 포매팅 사용
  - Ctrl + Alt + L
# 👷기능 요구사항 정의
## Utils
- InputValidator
  - 사용자 입력을 검증
    - 자동차 이름
    - 횟수

## Domain
- Car
  - 이름, 위치
  - 움직이는 동작
- Cars
  - car
  - winner 찾기
- Game
  - Cars
  - Random 값에 따라 Cars move
## Controller
- GameController
  - Game 을 실행
## View
- InputView
  - 사용자의 입력을 받음
- OutputView
  - 게임 별 결과를 출력 (횟수 별)
    - Cars  전달 해야될 듯
  - 게임의 결과를 양식에 맞게 출력
    - Winner 전달 해야될 듯
----
추가된 코드 컨벤션 지키기
- indent <= 2
- 3항 연산사 사용 x
- 함수(메서드) 최대한 하는 일 작게