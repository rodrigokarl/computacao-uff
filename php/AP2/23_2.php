<?php
    function connect_db($db_name)
    {
        $conn = new mysqli("localhost", "root", "", $db_name);
        return $conn;
    }

    function update_status($conn)
    {
        $sql = "UPDATE Reserva SET Status = 'V' WHERE DataReserva < CURRENT_DATE() AND Status = 'A';";
        $conn->query($sql);
    }

    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        if (isset($_POST["nome"])) {
            $nome = $_POST["nome"];
            $conn = connect_db("reserva_mesa");
            $sql = "SELECT * FROM Reserva WHERE NomeCliente LIKE '%$nome%'";
            $result = $conn->query($sql);
            $result->fetch_all(MYSQLI_ASSOC);
            echo '
<table border="1">
<tr>
<th>Nome:</th>
<th>Data do Registro da Reserva</th>
<th>Data da Reserva</th>
<th>Número da Mesa</th>
<th>Status da Reserva</th>
</tr>';
            foreach ($result as $row) {
                echo '
<tr>
<th>. $row["NomeCliente"] .</th>
<th>. $row["DataReserva"] .</th>
<th>. $row["DataPedido"] .</th>
<th>. $row["Mesa_id"] .</th>
<th>. $row["Status"] .</th>
</tr>
';
            }
            echo "</table>";
        }
    }
?>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cliente</title>
</head>
<body>
<form action="23_2.php" method="POST">
    <input type="text" name="nome" placeholder="Digite o nome do cliente" required>
    <button type="submit">Buscar</button>
</form>
</body>
</html>
