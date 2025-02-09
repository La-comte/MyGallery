<!DOCTYPE html>
<html>
<head>
    <title>Лан Ма</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<h1>Лан Ма</h1>
<h3>Создать новое блюдо</h3>
<form action="/product/create" method="post" enctype="multipart/form-data">
    Название: <input type="text" name="title"/><br><br>
    Описание: <input type="text" name="description"/><br><br>
    Цена: <input type="number" name="price"/><br><br>
    Имя раздела: <input type="text" name="author"/><br><br>
    Фотография: <input type="file" name="file1"/><br><br>
    <input type="submit" value="Добавить товар"/>
</form>
</body>
</html>