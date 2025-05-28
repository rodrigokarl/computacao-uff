<?php

    $resultadosTime1 = array (
        "Time2" => array (1, 0),
        "Time3" => array (2, 1),
        "Time4" => array (2, 3),
        "Time5" => array (1, 1),
    );


    function insereResultados($resultados, $nomeAdversario, $numGolsPro, $numGolsContra) {
        $resultados[$nomeAdversario] = array($numGolsPro, $numGolsContra);
        return $resultados;
    }

    $resultadosTime1Atualizados = insereResultados($resultadosTime1, "Time6", 3, 2);

    $saldoDeGols = array (
        "Time1" => 1, "Time2" => 0, "Time3" => -2, "Time4" => 3, "Time5" => -1,
    );
    function armazenaSaldoDeGols($resultados, &$saldoDeGols) {
        foreach ($resultados as $nomeTime=>$resultado) {
            $saldoDeGols[$nomeTime] = $resultado[0] - $resultado[1];
        }
    }

    armazenaSaldoDeGols($resultadosTime1Atualizados, $saldoDeGols);
    print_r($saldoDeGols);