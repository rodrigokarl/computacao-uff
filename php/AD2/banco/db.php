<?php
    $host = "localhost";
    $user = "root";
    $password = "teste";
    $database = "sistema_vendas";

    $connection = new mysqli($host, $user, $password, $database);

    if ($connection->connect_error) {
        die($connection->connect_error);
    }

    //funcoes para implementar em clientes
    function findUser($connection, $id) {
        $id = mysqli_real_escape_string($connection, $id);

        $sql = "SELECT * FROM `sistema_vendas`.`clientes` WHERE id = ?";
        $stmt = mysqli_stmt_init($connection);

        if (!mysqli_stmt_prepare($stmt, $sql)) {
            exit('Erro');
        }

        mysqli_stmt_bind_param($stmt, 'i', $id);
        mysqli_stmt_execute($stmt);

        $cliente = mysqli_fetch_assoc(mysqli_stmt_get_result($stmt));

        mysqli_close($connection);
        return $cliente;
    }

    function createUser($connection, $nome, $email, $telefone) {
        $nome = mysqli_real_escape_string($connection, $nome);
        $email = mysqli_real_escape_string($connection, $email);
        $telefone = mysqli_real_escape_string($connection, $telefone);

        if ($nome && $email && $telefone) {
            $sql = "INSERT INTO `sistema_vendas`.`clientes` (nome, email, telefone, data_cadastro) VALUES (?, ?, ?, now())";
            $stmt = mysqli_stmt_init($connection);

            if (!mysqli_stmt_prepare($stmt, $sql)) {
                exit('Erro');
            }

            mysqli_stmt_bind_param($stmt, 'sss', $nome, $email, $telefone);
            mysqli_stmt_execute($stmt);

            mysqli_close($connection);
            return true;
        }
    }

    function readUser($connection) {

        $users = array();

        $sql = "SELECT * FROM `sistema_vendas`.`clientes`";
        $result = mysqli_query($connection, $sql);

        if (mysqli_num_rows($result) > 0) {
            $users = mysqli_fetch_all($result, MYSQLI_ASSOC);
        }

        //mysqli_close($connection);
        return $users;
    }

    function updateUser($connection, $id, $nome, $email, $telefone) {
        if ($id && $nome && $email && $telefone) {
            $sql = "UPDATE `sistema_vendas`.`clientes` SET nome = ?, email = ?, telefone = ? WHERE id = ?";
            $stmt = mysqli_stmt_init($connection);

            if (!mysqli_stmt_prepare($stmt, $sql)) {
                exit('Erro');
            }

            mysqli_stmt_bind_param($stmt, 'sssi', $nome, $email, $telefone, $id);
            mysqli_stmt_execute($stmt);

            mysqli_close($connection);
            return true;
        }
    }

    function deleteUser($connection, $id) {
        $id = mysqli_real_escape_string($connection, $id);

        if ($id) {
            $sql = "DELETE FROM `sistema_vendas`.`clientes` WHERE id = ?";
            $stmt = mysqli_stmt_init($connection);

            if (!mysqli_stmt_prepare($stmt, $sql)) {
                exit('Erro');
            }

            mysqli_stmt_bind_param($stmt, 'i', $id);
            mysqli_stmt_execute($stmt);

            mysqli_close($connection);
            return true;
        }
    }

    //funcoes para implementar em produtos
    function findProduct($connection, $id) {
        $id = mysqli_real_escape_string($connection, $id);

        $sql = "SELECT * FROM `sistema_vendas`.`produtos` WHERE id = ?";
        $stmt = mysqli_stmt_init($connection);

        if (!mysqli_stmt_prepare($stmt, $sql)) {
            exit('Erro');
        }

        mysqli_stmt_bind_param($stmt, 'i', $id);
        mysqli_stmt_execute($stmt);

        $product = mysqli_fetch_assoc(mysqli_stmt_get_result($stmt));

        mysqli_close($connection);
        return $product;
    }

    function createProduct($connection, $nome, $preco, $estoque) {
        $nome = mysqli_real_escape_string($connection, $nome);
        $preco = mysqli_real_escape_string($connection, $preco);
        $estoque = mysqli_real_escape_string($connection, $estoque);

        if ($nome && $preco && $estoque) {
            $sql = "INSERT INTO `sistema_vendas`.`produtos` (nome, preco, estoque, data_cadastro) VALUES (?, ?, ?, now())";
            $stmt = mysqli_stmt_init($connection);

            if (!mysqli_stmt_prepare($stmt, $sql)) {
                exit('Erro');
            }

            mysqli_stmt_bind_param($stmt, 'sdi', $nome, $preco, $estoque);
            mysqli_stmt_execute($stmt);

            mysqli_close($connection);
            return true;
        }
    }

    function readProduct($connection) {
        $products = array();

        $sql = "SELECT * FROM `sistema_vendas`.`produtos`";
        $result = mysqli_query($connection, $sql);

        if (mysqli_num_rows($result) > 0) {
            $products = mysqli_fetch_all($result, MYSQLI_ASSOC);
        }

        //mysqli_close($connection);
        return $products;
    }

    function updateProduct($connection, $id, $nome, $preco, $estoque) {
        if ($id && $nome && $preco && $estoque) {
            $sql = "UPDATE `sistema_vendas`.`produtos` SET nome = ?, preco = ?, estoque = ? WHERE id = ?";
            $stmt = mysqli_stmt_init($connection);

            if (!mysqli_stmt_prepare($stmt, $sql)) {
                exit('Erro');
            }

            mysqli_stmt_bind_param($stmt, 'sdii', $nome, $preco, $estoque, $id);
            mysqli_stmt_execute($stmt);

            mysqli_close($connection);
            return true;
        }
    }

    function deleteProduct($connection, $id) {
        $id = mysqli_real_escape_string($connection, $id);

        if ($id) {
            $sql = "DELETE FROM `sistema_vendas`.`produtos` WHERE id = ?";
            $stmt = mysqli_stmt_init($connection);

            if (!mysqli_stmt_prepare($stmt, $sql)) {
                exit('Erro');
            }

            mysqli_stmt_bind_param($stmt, 'i', $id);
            mysqli_stmt_execute($stmt);

            mysqli_close($connection);
            return true;
        }
    }

    //funcoes para implementar em pedidos

    function createPedido($connection, $cliente_id, $total) {
        $cliente_id = mysqli_real_escape_string($connection, $cliente_id);
        $total = mysqli_real_escape_string($connection, $total);

        if ($cliente_id && $total) {
            $sql = "INSERT INTO `sistema_vendas`.`pedidos` (cliente_id, data_pedido, total) VALUES (?, now(), ?)";
            $stmt = mysqli_stmt_init($connection);

            if (!mysqli_stmt_prepare($stmt, $sql)) {
                exit('Erro');
            }

            mysqli_stmt_bind_param($stmt, 'id', $cliente_id, $total);
            mysqli_stmt_execute($stmt);

            mysqli_close($connection);
            return true;
        }
    }

    function readPedido($connection) {
        $pedidos = array();

        $sql = "SELECT * FROM `sistema_vendas`.`pedidos`";
        $result = mysqli_query($connection, $sql);

        if (mysqli_num_rows($result) > 0) {
            $pedidos = mysqli_fetch_all($result, MYSQLI_ASSOC);
        }

        //mysqli_close($connection);
        return $pedidos;
    }

    function readItens($connection, $pedido_id) {
        $itens_pedido = array();

        $sql = "SELECT * FROM `sistema_vendas`.`itens_pedido` WHERE pedido_id = $pedido_id";
        $result = mysqli_query($connection, $sql);

        if (mysqli_num_rows($result) > 0) {
            $itens_pedido = mysqli_fetch_all($result, MYSQLI_ASSOC);
        }

        //mysqli_close($connection);
        return $itens_pedido;

    }




?>