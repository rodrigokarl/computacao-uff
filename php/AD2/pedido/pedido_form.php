<?php
    include "../banco/db.php";

    $clientes = readUser($connection);

    $items = readProduct($connection);

    if (isset($_POST['cliente_id']) && isset($_POST['preco']) && isset($_POST['quantidade'])) {
        $total = intval($_POST['quantidade']) * floatval($_POST['preco']);
        createPedido($connection, $_POST['cliente_id'], $total);
        header('Location: pedido_list.php');
    }
?>

<!DOCTYPE html>
<html>
<head>
    <title>Novo Pedido</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<h1>Novo Pedido</h1>

<form action ="pedido_form.php" method="POST">
    <label>Cliente:</label><br>

    <select name="cliente_id">
        <?php foreach ($clientes as $row): ?>
            <option value="<?= $row["id"] ?>"><?= $row["nome"] ?></option>
        <?php endforeach ?>
    </select><br><br>

    <h2>Itens do Pedido</h2>

    <?php foreach ($items as $row): ?>

        <?=$row['nome']?> (R$ <?=$row['preco']?>) - Quantidade:
        <input type="hidden" name="preco" value="<?=$row['preco']?>">
        <input type="number" name="quantidade"><br>

    <?php endforeach ?>
    <br>

    <input type="submit" value="Finalizar Pedido">
    <a href="pedido_list.php">Cancelar</a>
</form>

</body>
</html>
