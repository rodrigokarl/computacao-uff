<?php
    include "../banco/db.php";

    if (isset($_POST["nome"]) && isset($_POST["preco"]) && isset($_POST["estoque"])) {
        createProduct($connection, $_POST["nome"], $_POST["preco"], $_POST["estoque"]);
        header('Location: produto_list.php');
    }
?>

<!DOCTYPE html>
<html>
<head>
    <title>Novo Produto</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<h1>Novo Produto</h1>

<form action="produto_form.php" method="POST">
    <label>Nome:</label><br>
    <input type="text" name="nome" required/><br>

    <label>Preço:</label><br>
    <input type="number" name="preco" step="0.01" required/><br>

    <label>Estoque:</label><br>
    <input type="number" name="estoque" required/><br><br>

    <input type="submit" value="Salvar">
    <a href="produto_list.php">Voltar</a>
</form>

</body>
</html>
