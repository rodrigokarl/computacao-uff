<?php

    $saldoDeGols = array (
        "Time1" => 1, "Time2" => 0, "Time3" => -2, "Time4" => 3, "Time5" => -1,
    );
    function armazenaSaldoDeGols($resultados, &$saldoDeGols) {
        foreach ($resultados as $nomeTime=>$resultado) {
            $saldoDeGols[$nomeTime] = $resultado[0] - $resultado[1];
        }
    }
