<?php
    include "../banco/db.php";

    if (isset($_POST["nome"]) && isset($_POST["email"]) && isset($_POST["telefone"])) {
        createUser($connection, $_POST["nome"], $_POST["email"], $_POST["telefone"]);
        header('Location: cliente_list.php');
    }
?>

<!DOCTYPE html>
<html>
<head>
    <title>Novo Cliente</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<h1>Novo Cliente</h1>

<form action ="cliente_form.php" method="POST">
    <label>Nome:</label><br>
    <input type="text" name="nome" required/><br>

    <label>Email:</label><br>
    <input type="text" name="email" required/><br>

    <label>Telefone:</label><br>
    <input type="tel" name="telefone" pattern="[0-9]{11}" required/><br><br>

    <input type="submit" value="Salvar">
    <a href="cliente_list.php">Voltar</a>
</form>

</body>
</html>
