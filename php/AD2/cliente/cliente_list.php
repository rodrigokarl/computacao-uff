<?php
    include "../banco/db.php";
    $users = readUser($connection);
?>

<!DOCTYPE html>
<html>
<head>
    <title>Clientes</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<h1>Clientes</h1>

<a href="cliente_form.php">Novo Cliente</a><br>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Email</th>
        <th>Telefone</th>
        <th>Ações</th>
    </tr>
    <?php foreach ($users as $row): ?>
    <tr>
        <td><?=htmlspecialchars($row['id'])?></td>
        <td><?=htmlspecialchars($row['nome'])?></td>
        <td><?=htmlspecialchars($row['email'])?></td>
        <td><?=htmlspecialchars($row['telefone'])?></td>
        <td><a href="cliente_edit.php?id=<?=$row['id']?>">Editar</a> <a href="cliente_delete.php?id=<?=$row['id']?>">Excluir</a></td>
    </tr>
    <?php endforeach; ?>
</table>

<a href="../">Voltar</a>

</body>
</html>
