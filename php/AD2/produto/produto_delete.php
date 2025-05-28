<?php
    include "../banco/db.php";

    if (isset($_POST['id'])) {
        deleteProduct($connection, $_POST['id']);
    }

    if (!isset($_GET['id'])) {
        header('Location: produto_list.php');
    }

?>

<!DOCTYPE html>
<html>
<head>
    <title>Deletar Produto</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<h1>Deletar Produto</h1>

<form action="produto_delete.php" method="POST">
    <label>Deseja realmente deletar o produto?</label>
    <input type="hidden" name="id" value="<?=$_GET['id']?>" required/>
    <input type="submit" value="Confirmar">
    <a href="produto_list.php">Voltar.</a>
</form>

</body>
</html>