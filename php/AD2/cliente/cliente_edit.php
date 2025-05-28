<?php
    include "../banco/db.php";

    if (isset($_POST["id"]) && isset($_POST["nome"]) && isset($_POST["email"]) && isset($_POST["telefone"])) {
        updateUser($connection, $_POST["id"], $_POST["nome"], $_POST["email"], $_POST["telefone"]);
        header('Location: cliente_list.php');
    }

    if (isset($_GET["id"])) {
        $user = findUser($connection, $_GET["id"]);
    }
    else {
        header('Location: cliente_list.php');
    }

?>

<!DOCTYPE html>
<html>
<head>
    <title>Editar Cliente</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<h1>Editar Cliente</h1>

<form action="cliente_edit.php" method="POST">
    <input type="hidden" name="id" value="<?=$user['id']?>" required/>

    <label>Nome:</label><br>
    <input type="text" name="nome" value="<?=htmlspecialchars($user['nome'])?>" required/><br>

    <label>Email:</label><br>
    <input type="text" name="email" value="<?=htmlspecialchars($user['email'])?>" required/><br>

    <label>Telefone:</label><br>
    <input type="tel" name="telefone" value="<?=htmlspecialchars($user['telefone'])?>" required/><br><br>

    <input type="submit" value="Salvar">
    <a href="cliente_list.php">Voltar</a>
</form>


</body>
</html>

