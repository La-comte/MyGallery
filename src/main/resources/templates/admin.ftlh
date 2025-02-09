<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Администраторская панель</title>
    <link rel="stylesheet" href="/css/styles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<header class="header">
    <div class="top-bar">
        <div class="container">
            <div class="logo">
                <a href="#">Sakura Admin</a>
            </div>
            <nav class="nav">
                <ul class="nav-list">
                    <li><a href="/">На сайт</a></li>
                    <li><a href="#stats">Статистика</a></li>
                    <li><a href="#manage">Управление блюдами</a></li>
                </ul>
            </nav>
        </div>
    </div>
</header>
<main>
    <section id="stats">
        <h2>Статистика</h2>
        <p>Общее количество заказов за все время: <strong>${ordersNum}</strong></p>
        <p>Выручка за сегодняшний день: <strong>${totalCostPerDay?default("0")} ₽</strong></p>
        <#if theMostPopularProduct??>
            <p>Самое популярное блюдо: <strong>${theMostPopularProduct.title}</strong></p>
        <#else>
            <p>Самое популярное блюдо: <strong>Заказов пока не было</strong></p>
        </#if>
        <#if theMostUnpopularProduct??>
            <p>Самое непопулярное блюдо: <strong>${theMostUnpopularProduct.title}</strong></p>
        <#else>
            <p>Самое непопулярное блюдо: <strong>Заказов пока не было</strong></p>
        </#if>
    </section>
    <section id="manage">
        <h2>Управление блюдами</h2>
        <form class="add-dish-form">
            <a href="/product/create">Добавить новое блюдо</a>
        </form>
        <h3>Список блюд</h3>
        <#list products as product>
        <div>
            <p><b>${product.title}</b> ${product.price} руб. |
                <a href="/product/${product.id}">Подробнее...</a></p>
            <form action="/product/delete/${product.id}" method="post">
                <input type="submit" value="Удалить товар"/>
            </form>
        </div>
        <#else>
        <h3>Товаров нет</h3>
        </#list>
    </section>
</main>
</body>
</html>
