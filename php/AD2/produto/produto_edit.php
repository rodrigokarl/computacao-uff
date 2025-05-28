<?php
    include "../banco/db.php";

    if (isset($_POST["id"]) && isset($_POST["nome"]) && isset($_POST["preco"]) && isset($_POST["estoque"])) {
        updateProduct($connection, $_POST["id"] ,$_POST["nome"], $_POST["preco"], $_POST["estoque"]);
        header('Location: produto_list.php');
    }

    if (isset($_GET["id"])) {
        $product = findProduct($connection, $_GET['id']);
    }
    else {
        header('Location: produto_list.php');
    }

?>

<!DOCTYPE html>
<html>
<head>
    <title>Editar Produto</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<h1>Editar Produto</h1>

<form action="produto_edit.php" method="POST">
    <input type="hidden" name="id" value="<?=$product['id']?>" required/>
    <label>Nome:</label><br>
    <input type="text" name="nome" value="<?=htmlspecialchars($product['nome'])?>" required/><br>

    <label>Preço:</label><br>
    <input type="number" name="preco" step="0.01" value="<?=htmlspecialchars($product['preco'])?>" required/><br>

    <label>Estoque:</label><br>
    <input type="number" name="estoque" value="<?=htmlspecialchars($product['estoque'])?>" required/><br><br>

    <input type="submit" value="Salvar">
    <a href="produto_list.php">Voltar</a>
</form>

</body>
</html>
