# java-racingcar-precourse

## System Sequence

```mermaid
sequenceDiagram
    actor U as User
    box rgb(0.5, 0.5, 0.5, 0.2)
        participant A as Application
        participant CL as CarList
        participant C as Car
    end

    rect rgb(1, 1, 0, 0.2)
        note right of U: Step 1 - 자동차 생성
        U ->>+ A: generate_cars(line)
        A ->>+ CL: construct(car_names)
        loop car_names
            CL ->>+ C: construct(name)
            C -->>- CL: car
        end
        CL -->>- A: car_list
        deactivate A
    end

    rect rgb(1, 1, 0, 0.2)
        note right of U: Step 2 - 자동차 경주 진행
        U ->>+ A: start_game(line)
        loop 1..count
            A ->>+ CL: move(count)
            loop car_list
                CL ->> C: move()
            end
            A ->> CL: get_status()
            loop car_list
                CL ->>+ C: get_status()
                C -->>- CL: status
            end
            CL -->>- A: status_list
            A -->> U: status_list
        end
    end

    rect rgb(1, 1, 0, 0.2)
        note right of U: Step 3 - 경주 결과 출력
        A ->>+ CL: print_winners()
        loop winners
            CL ->>+ C: get_name()
            C -->>- CL: name
        end
        CL -->>- A: winner_names
        A -->>- U: winner_names
    end
```

## Domain

### Car

- [ ] 5자 이하의 이름을 가짐
- [ ] 확률적으로 성공하는 전진 기능
- [ ] 다른 자동차와 전진 거리를 기준으로 비교 기능
- [ ] 정보 출력 기능

## Flow

### 자동차 생성

- [ ] 입력(line)을 파싱하여 자동차 이름 목록 생성
- [ ] 자동차 이름 목록으로 자동차 목록 생성

### 자동차 경주 진행

- [ ] 입력(line)을 받아 이동 횟수 생성
- [ ] 이동 횟수만큼 자동차 목록에 전진, 정보 출력 수행

### 경주 결과 출력

- [ ] 우승 자동차 목록 계산
- [ ] 우승 자동차 목록 출력
