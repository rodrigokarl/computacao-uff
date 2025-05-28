<?php
    include "../banco/db.php";
    $products = readProduct($connection);
?>

<!DOCTYPE html>
<html>
<head>
    <title>Bem-vindo ao Sistema de Vendas</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<h1>Produtos</h1>

<a href="produto_form.php">Novo Produto</a><br>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Preço</th>
        <th>Estoque</th>
        <th>Ações</th>
    </tr>
    <?php foreach ($products as $row): ?>
    <tr>
        <td><?=htmlspecialchars($row['id'])?></td>
        <td><?=htmlspecialchars($row['nome'])?></td>
        <td><?=htmlspecialchars($row['preco'])?></td>
        <td><?=htmlspecialchars($row['estoque'])?></td>
        <td><a href="produto_edit.php?id=<?=$row['id']?>">Editar</a> <a href="produto_delete.php?id=<?=$row['id']?>">Excluir</a></td>
    </tr>
    <?php endforeach; ?>
</table>

<a href="../">Voltar</a>

</body>
</html>