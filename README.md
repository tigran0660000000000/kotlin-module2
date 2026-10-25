# Модуль 2 — Основы Jetpack Compose

Практические задания 1–10 по дисциплине «Проектирование и разработка мобильных приложений на языке Котлин».
РТУ МИРЭА, группа ИКБО-62-24, Погосян Т.Г.

Android-приложение на Kotlin + Jetpack Compose (minSdk 24, compileSdk 35, AGP 8.7.3, Kotlin 2.0.21).
На главном экране меню: каждая кнопка открывает экран соответствующего задания.

| Задание | Файл | Содержание |
|---|---|---|
| 1 | `Task1.kt`, `MainActivity.kt` | Функция `Hello(name: String?)` |
| 2 | `Task2.kt` | Три макета `@Preview`: portrait, landscape, round |
| 3 | `Task3.kt`, `res/values/strings.xml` | Три варианта оформления текста |
| 4 | `Task4.kt` | Кнопка на всю ширину с рамкой и тенью |
| 5 | `Task5.kt` | Контейнер с кругом-инициалами |
| 6 | `Task6.kt`, `res/drawable/circle.xml` | Векторное изображение в Box |
| 7 | `Task7.kt` | Контакты на Column и Row |
| 8 | `Task8.kt` | Исправленный трекер воды + счётчик дней с нормой 1500 мл |
| 9 | `app/src/androidTest/.../WaterTrackerTest.kt` | UI-тесты трекера воды |
| 10 | `Task10.kt` | Исправленная корзина интернет-магазина |

Код: `app/src/main/java/ru/pogosyan/module2/`.

## Запуск

Открыть проект в Android Studio и запустить конфигурацию `app` на эмуляторе или устройстве.
UI-тесты (задание 9): `./gradlew connectedDebugAndroidTest` при запущенном эмуляторе.
