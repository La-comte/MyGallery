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
                    <li><a href="#menu">Меню</a></li>
                    <li><a href="/cart">Корзина</a></li>
                    <li><a href="#about">О нас</a></li>
                </ul>
            </nav>
        </div>
    </div>
</header>
<main>
    <section id="menu">
        <h1 class="container">Меню</h1>
        <div class="container menu-grid">
            <#list products as product>
                <div>
                    <form method="get" action="/cart/add/${product.id}">
                        <h3>${product.title}</h3>
                        <p>${product.price} ₽ </p>
                        <button class="add-to-cart">Добавить в корзину</button></br>
                        <a href="/product/${product.id}">Подробнее о товаре</a>
                    </form>
                </div>
            </#list>
        </div>
    </section>

    <section id="about" class="container">
        <h3>J'PAN – маленькая Япония в центре Москвы, Городские японские бистро, в которых нет ни столетних традиций, ни тысячелетней истории.</h3>
    </section>
    <section class="container">
    <p><h4>Раздел для <a href="/admin">администраторов</a></h4></p>
    </section>
    </body>
</html>
