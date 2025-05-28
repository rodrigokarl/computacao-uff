<?php
    $servername = "localhost";
    $username = "root";
    $password = "teste";
    $dbname = "ap2";

    $conn = new mysqli($servername, $username, $password, $dbname);

    if ($conn->connect_error) {
        die("Erro ao conectar: " . $conn->connect_error);
    }

    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        if (isset($_POST["nome"])) {
            $nome = $_POST["nome"];
            $sql = "SELECT * FROM clientes WHERE nome regexp '^$nome';";
            $result = $conn->query($sql);
            $result->fetch_all(MYSQLI_ASSOC);

            echo '<table border="1"><tr><th>Nome</th><th>Email</th></tr>';

            foreach ($result as $row) {
                echo '<tr><th>' . $row["nome"] . '</th><th>' . $row["email"] . '</th></tr>';
            }
            echo '</table>';
        }
    }
?>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clientes</title>
</head>
<body>
<form action="clientes.php" method="POST">
    <input type="text" name="nome" placeholder="Digite o nome do cliente" required>
    <button type="submit">Consultar</button>
</form>
</body>
</html>