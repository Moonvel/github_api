# github_api_testing(тестирование API Github, получение всех репозиториев организации Selenide).
## Пакет tests:
+ Класс SelenideRepoTests: взятие всех репозиториев организации selenide, сравнение действительной информации и информации в ответе.
## Пакет steps:
+ Класс ApiSteps: получение репозитория организации, получение списка всех репозиториев организации.
## Пакет property:
+ Класс PropsHelper: установка свойств, которые подгружаются в других классах из файла local.properties.
## Пакет model:
+ Класс Repos: модель репозитория, которая применяется в работе с REST Assured. 
+ Класс License: модель лицензии, которая входит в модель Repos.
+ Класс Owner: модель владельца, которая входит в модель Repos.
## Пакет helper:
+ Класс ApiHelper: выполнение GET запроса, проверка ответа на код 200 и непустое тело.