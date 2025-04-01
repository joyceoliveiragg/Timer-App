# App de banco de horas - para estudo e desenvolvimento do projeto do decola tech 2025 avanade DIO
Java RESTfulAPI criada para app de banco de horas.

## Diagrama de Classes
```mermaid
classDiagram
    class User {
        +String userName
        +Infos infos
        +Workload workload
        +WeeklyActivity weeklyActivity
        +DailyActivity dailyActivity
        +Progress progress
    }

    class Infos {
        +String contract
        +String sector
        +String hours
        +String manager
        +String project
    }

    class Workload {
        +String internHours
        +String cltHours
    }

    class WeeklyActivity {
        +List~String~ days
        +List~String~ workedHours
        +List~String~ workloads
        +List~String~ projects
    }

    class DailyActivity {
        +List~String~ hours
        +List~String~ projects
        +List~String~ cards
    }

    class Progress {
        +String totalWorkedHoursMonth
        +String totalWorkedHoursWeek
        +String leave
        +String holidays
    }

    %% Sugestão de classe adicional
    class LeaveRequest {
        +String leaveType
        +String startDate
        +String endDate
        +String status
    }

    %% Relacionamentos
    User "1" --> "1" Infos
    User "1" --> "1" Workload
    User "1" --> "1" WeeklyActivity
    User "1" --> "1" DailyActivity
    User "1" --> "1" Progress
    User "1" --> "0..*" LeaveRequest
