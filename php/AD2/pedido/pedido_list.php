<?php
    include "../banco/db.php";
    $clientes = readUser($connection);
    $pedidos = readPedido($connection);
?>

<!DOCTYPE html>
<html>
<head>
    <title>Pedidos</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<h1>Pedidos</h1>

<a href="pedido_form.php">Novo Pedido</a><br>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Cliente</th>
        <th>Data</th>
        <th>Total</th>
        <th>Ações</th>
    </tr>
    <?php foreach ($pedidos as $row): ?>
            <tr>
                <td><?= htmlspecialchars($row['id']) ?></td>
                <td><?= htmlspecialchars($row['cliente_id']) ?></td>
                <td><?= htmlspecialchars($row['data_pedido']) ?></td>
                <td><?= htmlspecialchars($row['total']) ?></td>
                <td><a href="pedido_view.php?id=<?= $row['id'] ?>">Ver Itens</a></td>
            </tr>
    <?php endforeach; ?>
</table>

<a href="../">Voltar</a>

</body>
</html>
