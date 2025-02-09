<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Меню</title>
    <link rel="stylesheet" href="/css/styles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<header class="header">
    <div class="top-bar">
        <div class="container">
            <div class="logo">
                <a href="/">Sakura</a>
            </div>
            <nav class="nav">
                <ul class="nav-list">
                    <li><a href="/">Меню</a></li>
                    <li><a href="cart">Корзина</a></li>
                </ul>
            </nav>
        </div>
    </div>
</header>
<main>
    <h2>Подробная информация о товаре</h2>
        <div>
            <form method="get" action="/cart/add/${product.id}">
            <h3>${product.title}</h3>
                <p>Цена: ${product.price} ₽ </p>
                <p>Описание: ${product.description}</p>
                <button class="add-to-cart">Добавить в корзину</button></br>
            </form>
        </div>
</main>
</body>
</html>