<?php
    if (isset($_POST["nome"]) && isset($_POST["endereco"]) && isset($_POST["email"])) {
        $conn = new mysqli("localhost", "root", "teste", "ap2");

        if ($conn->connect_error) {
            die("Erro ao conectar: " . $conn->connect_error);
        }

        $stmt = $conn->prepare("INSERT INTO leitores(nome, endereco, email) VALUES(?, ?, ?)");

        $stmt->bind_param("sss", $_POST["nome"], $_POST["endereco"], $_POST["email"]);

        if ($stmt->execute()) {
            echo "Usuário cadastrado com sucesso.";
        }
        else {
            echo "Erro ao cadastrar usuário: " . $stmt->error;
        }

        $stmt->close();
        $conn->close();
    }
?>

<!DOCTYPE HTML>
<HTML>
<HEAD>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Leitores</title>
</HEAD>
<BODY>

<form action="cadastro.php" method="POST">
    <label for="nome">Nome:</label>
    <input type="text" name="nome" required><br><br>

    <label for="endereco">Endereço:</label>
    <input type="text" name="endereco" required><br><br>

    <label for="email">Email:</label>
    <input type="text" name="email" required><br><br>

    <button type="submit">Cadastrar</button>

</form>

</BODY>
</HTML>
