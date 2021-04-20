#language: ru
Функционал: API тесты demoqa.com

  @demoqaSuccessfullLoginAPI
  @allAPI
  @allProject
  Сценарий: Login в систему под валидными даннымия API
    И пользователь авторизуется с валидным логином и паролем

  @demoqaUnsuccessfullLoginAPI
  @allAPI
  @allProject
  Сценарий: Login в систему под не валидными данными API
    И пользователь авторизуется с валидным логином и не валидным паролем

  @demoqaShowBooksListWithoutLoginAPI
  @allAPI
  @allProject
  Сценарий: Возможность просмотра списка книг без входа в систему API
    И получаем список книг без авторизации

  @demoqaAddRemoveBooksAPI
  @allAPI
  @allProject
  Сценарий: Добавление и удаление книги в/из коллекции API
    И пользователь генерирует токен
    И пользователь добавляет книгу себе в коллекцию
    И пользователь удаляет книгу из своей коллекции
