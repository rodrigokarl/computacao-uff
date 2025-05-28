<?php
    function calculaSaldo($cliente, $operacao) {
        $cliente_unique = array_unique($cliente);
        foreach($cliente_unique as $c) {
            $saldo = 0;
            for($i = 0; $i < sizeof($cliente); $i++) {
                if($c == $cliente[$i]) {
                    $saldo += $operacao[$i];
                }
            }
            $saldo_unique[$c] = $saldo;
        }
        return $saldo_unique;
    }

    $cliente = array(1, 2, 1, 3, 1);
    $operacao = array(200, 300, 100, -100, 400);

    print_r(calculaSaldo($cliente, $operacao));
?>