# language: ru

@withdrawal
Функция: Вклады

  @Parameterized
  Структура сценария:  Параметризированная проверка наличия вклада с определёнными параметрами
    * Проверить корректность открытия страницы
    * Закрыть окно выбора региона
    * Выбрать меню "Вклады"
    * Нажать кнопку настройки вклада
    * Заполнить поле "Сумма" значением "<depositValue>":
    * Выбрать "<depositPeriod>" в поле "Срок":
    * Выбрать "<depositType>" в выпадающем списке поля "Тип вклада":
    * Выбрать банки в выпадающем списке поля "Банки":
      | <bank№1> |
      | <bank№2> |
      | <bank№3> |
      | <bank№4> |
      | <bank№5> |
    * Выбрать дополнительные опции:
      | <additional№1> |
      | <additional№2> |
      | <additional№3> |
    * Проверить соответствие актуального в поле "Сумма" значения введённому значению "<depositValue>":
    * Проверить соответствие актуального в поле "Срок" значения выбранному значению "<depositPeriod>":
    * Проверить соответствие актуального в поле "Тип вклада" значения выбранному значению "<depositType>":
    * Проверить состояния чекбоксов выбранных банков:
      | <bank№1> |
      | <bank№2> |
      | <bank№3> |
      | <bank№4> |
      | <bank№5> |
    * Проверить состояния чекбоксов выбора дополнительных опций:
      | <additional№1> |
      | <additional№2> |
      | <additional№3> |
    * Нажать кнопку "Показать"
    * Закрыть окно акции "Кэшбэк за вклад"
    * Проверить на равенство количество подходящих вкладов и ожидаемое значение "<amount>":
    * Проверить вклад банка "<bankName>" на соответствие процентной ставки значению "<rate>":
    * Проверить вклад банка "<bankName>" на соответствие срока значению "<period>":
    * Проверить вклад банка "<bankName>" на соответствие дохода значению "<profit>":

    Примеры:
      | depositValue | depositPeriod | depositType    | bank№1       | bank№2       | bank№3   | bank№4      | bank№5   | additional№1         | additional№2  | additional№3     | amount | bankName      | rate  | period  | profit      |
      | 1 000 000    | 6 месяцев     | Обычные вклады | Тинькофф     | ВТБ          | Открытие | Газпромбанк | Сбербанк | Со снятием           | С пополнением | С капитализацией | 14     | Тинькофф Банк | 5,63% | 182 дн. | от 27 740 ₽ |
      | 500 000      | 2 года        | Детский        | Ак Барс Банк | Банк «РОССИЯ | Сбербанк |             |          | С выплатой процентов |               |         ""       | 7      | Сбербанк      | 6,80% | 730 дн. | от 72 514 ₽ |