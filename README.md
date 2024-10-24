# java-racingcar-precourse
## 객체 구성도
![제목 없는 다이어그램 drawio (2)](https://github.com/user-attachments/assets/06bae2e1-fdc5-47c7-8e6b-347965d6a98d)
## 기능 요구 사항
### View
- ReaderHelper
  - [ ] 입력을 받아 쉼표(,)를 기준으로 선수 이름을 반환
    - [ ] 공백을 입력 받는 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션 종료
  - [ ] 입력을 받아 게임을 진행할 횟수를 반환
- PrintHelper
  - [ ] 플레이어 객체 리스트를 받아 게임 상황 출력
  - [ ] 플레이어 객체를 받아 게임 상황에 맞게 반환
  - [ ] 우승자 리스트를 받아 출력
### Model
- RacingGame
  - [X] 출전 선수 이름 리스트를 받아 플레이어 세팅
  - [X] 게임을 진행시킴
  - [X] 우승자 리스트를 반환
- Car
  - [X] 출전 선수 이름을 받아 플레이어 생성
  - [X] 출전 선수 점수 반환
  - [X] 출전 선수 이름 반환
  - [X] 전진 시도
### Controller
- GameController
  - [ ] 전체 흐름 관리 
  - [ ] 선수 이름과 게임 진행 횟수 설정
  - [ ] 게임 진행
  - [ ] 게임 마무리
### Oher
- Validator
  - [ ] 출전 선수 이름이 5자를 초과할 시 `IllegalArgumentException`을 발생시킨 후 애플리케이션 종료
  - [ ] 출전 선수 이름이 공백일 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션 종료
  - [ ] 출전 선수 이름 중복될 시 `IllegalArgumentException`을 발생시킨 후 애플리케이션 종료
  - [ ] 게임을 진행할 횟수를 입력 받을때 숫자가 아닌 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션 종료