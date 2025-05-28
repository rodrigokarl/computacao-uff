<?php
    include "../banco/db.php";

    if (isset($_POST['id'])) {
        deleteUser($connection, $_POST['id']);
    }

    if (!isset($_GET['id'])) {
        header('Location: cliente_list.php');
    }

?>

<!DOCTYPE html>
<html>
<head>
    <title>Deletar Usuário</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<h1>Deletar Usuário</h1>

<form action="cliente_delete.php" method="POST">
    <label>Deseja realmente deletar o usuário?</label>
    <input type="hidden" name="id" value="<?=$_GET['id']?>" required/>
    <input type="submit" value="Confirmar">
    <a href="cliente_list.php">Voltar.</a>
</form>

</body>
</html>
