Feature: Тестовое задание - Мобильное приложение Альфа-Банк - Демо режим

  Scenario: Вход в Демо Режим
    * Page - check current page 'Выбор языка'
    * Page - get element 'Россия' and click
    * Page - check current page 'Авторизация'
    * Page - get element 'Демо' and click
    * Page - check current page 'Основной экран'

  Scenario: Проверка счетов
    * Page - get element 'Показать все счета' and click
    * Page - get element 'Счета[2]' and check state 'is displayed'
    * Page - get element 'Счета[0]' and save text to 'result'
    * Verify - contains string expected '9 928 214,29' to actual '${result}'
    * Page - get element 'Счета[1]' and save text to 'result'
    * Verify - contains string expected '28 772,10' to actual '${result}'
    * Page - get element 'Счета[2]' and save text to 'result'
    * Verify - contains string expected '12 040,44' to actual '${result}'

  Scenario: Проверка карт
    * Page - get element 'Счета и карты' and click
    * Page - check current page 'Счета и карты'
    * Page - get element 'Карты[1]' and click
    * Page - check current page 'Информация о карте'
    * Page - get element 'Карты[1]' and scroll to other element 'Имя карты' with text 'Виртуальная карта' in direction 'RIGHT'
    * Page - get element 'Карты[1]' and scroll to other element 'Имя карты' with text 'MasterCard Cashback с чипом' in direction 'LEFT'
    * Page - get element 'Назад' and click
    * Page - get element 'Назад' and click
    * Page - check current page 'Основной экран'

  Scenario: Проведение платежа
    * Page - get element 'Платежи и переводы' and click
    * Page - check current page 'Платежи и переводы'
    * Page - get element 'Между счетами' and click
    * Page - get element 'Перевод ввод' and set '100'
    * Page - get element 'Перевод' and click
    * Page - get element 'Запретить' and click
    * Page - get element 'Отмена' and click
    * Page - get element 'Назад' and click
    * Page - get element 'Назад' and click

  Scenario: Скролл и выход
    * Page - check current page 'Основной экран'
    * Page - scroll to other element 'Альфа' in direction 'DOWN'
