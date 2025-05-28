<?php
    function verificar_nome_cliente($nome, $dados) {
        $encontrado = false;

        foreach ($dados as $cliente) {
            if ($cliente["nome"] == $nome) {
                $encontrado = true;
                $receitas_trimestrais = $cliente["receita"];
                $total_receitas = array_sum($receitas_trimestrais);
                break;
            }
        }

        if ($encontrado) {
            $html = "<table border='1'><thead><tr><th>1o Trimestre</th><th>2o Trimestre</th><th>3o Trimestre</th><th>4o Trimestre</th><th>Total</th></tr></thead><tbody><tr>";
            foreach ($receitas_trimestrais as $receita) {
                $html .= "<td>" . $receita . "</td>";
            }
            $html .= "<td>" . $total_receitas . "</td></tr></tbody></table>";
        }
        else {
            $html = "<table border='1'><tbody><tr><td>Nome não encontrado</td></tr></tbody></table>";
        }
        return $html;
    }
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $nome_cliente = $_POST["nome"];
    }
    else {
        $nome_cliente = "";
    }
?>

<html>
<head>
    <meta charset="UTF-8">
    <title>Questão 3</title>
</head>
<body>
<h1>Questão 3</h1>
<form method="post">
    <label for="nome">Nome do Cliente:</label>
    <input type="text" id="nome" name="nome" value="<?php echo $nome_cliente ?>" required>
    <button type="submit">Enviar</button>
</form>

<?php
    $dados = array(
        array("id"=>1, "nome"=>"Flavio", "receita"=>array(10.0, 5.5, 2.3, 3.0)),
        array("id"=>2, "nome"=>"Maria", "receita"=>array(15.0, 2.5, 8.3, 4.0)),
        array("id"=>3, "nome"=>"João", "receita"=>array(5.0, 7.5, 4.1, 6.0))
    );

    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $resultado = verificar_nome_cliente($nome_cliente, $dados);
        echo $resultado;
    }
?>

</body>
</html>
