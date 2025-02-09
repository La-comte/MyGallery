<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Корзина</title>
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
                    <li><a href="/cart">Корзина</a></li>
                </ul>
            </nav>
        </div>
    </div>
</header>

<main class="cart">
    <h1>Ваша корзина</h1>

    <#if cart?has_content>
    <#list cart as product>
        <ul class="cart-list">
            <form method="get" action="/cart/remove/${product.id}">
            <li>
                <h3>${product.title}</h3>
                <p>Цена: ${product.price} ₽ </p>
                <button class="remove-item">Удалить из корзины</button>
            </li>
            </form>
        </ul>

    </#list>
    <div class="cart-summary">
        <form method="post" action="/cart/purchase">
            <p>Итого: <strong>${totalCost} ₽</strong></p>
            <button class="checkout-btn">Оформить заказ</button>
        </form>
    </div>
    <#else>
        <h2>Ваша корзина пуста</h2>
    </#if>


</main>
</body>
</html>
