<?php
    include "../banco/db.php";

    if (!isset($_GET['id'])) {
        header('Location: pedido_list.php');
    }

    $itens_pedido = readItens($connection, $_GET['id']);
?>

<!DOCTYPE html>
<html>
<head>
    <title>Pedidos</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<h1>Itens do pedido #<?=$_GET['id']?></h1>

<table border="1">
    <tr>
        <th>Produto</th>
        <th>Quantidade</th>
        <th>Preço Unitário</th>
        <th>Total</th>
    </tr>
    <?php foreach ($itens_pedido as $row): ?>
        <tr>
            <td><?= htmlspecialchars($row['produto_id']) ?></td>
            <td><?= htmlspecialchars($row['quantidade']) ?></td>
            <td><?= htmlspecialchars($row['preco_unitario']) ?></td>
            <td><?= htmlspecialchars($row['preco_unitario'] * $row['quantidade']) ?></td>
        </tr>
    <?php endforeach; ?>

</table><br>

<a href="pedido_list.php?id=<?= $_GET['id'] ?>">Voltar</a></td>


</body>
</html>
