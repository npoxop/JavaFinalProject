#language: ru
Функционал: Отправляем запросы

  @demoqaSuccessfullLoginAPI
  Сценарий: Login в систему под валидными даннымия API
    И пользователь авторизуется с валидным логином

  @demoqaUnsuccessfullLoginAPI
  Сценарий: Login в систему под не валидными данными API
    И пользователь авторизуется с невалидным логином

  @demoqaShowBooksListWithoutLoginAPI
  Сценарий: Возможность просмотра списка книг без входа в систему API
    И получаем список книг без авторизации


  @kotik
  Сценарий: Обучение
    И получаем список книг

    @kotik2
    Сценарий: Обучение2
      И пользователь генерирует токен
      И пользователь удаляет книгу из своей коллекции

      @kotik3
      Сценарий: Обучение3
        И пользователь генерирует токен
        И пользователь добавляет книгу себе в коллекцию
        И пользователь удаляет книгу из своей коллекции

