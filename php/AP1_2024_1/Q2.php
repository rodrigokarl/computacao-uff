<?php
    $resultadosTime = array(
        array(1, 0),
        array(2, 1)
    );

    $pontos = calculaPontos($resultadosTime);

    function calculaPontos($resultados) {
        $pontos = 0;

        foreach($resultados as $time=>$resultado) {
            //vitória
            if ($resultado[0] > $resultado[1]) {
                $pontos += 3;
            }
            else {
                // empate
                if ($resultado[0] == $resultado[1]) {
                    $pontos += 1;
                }
            }
        }
        return $pontos;
    }

    echo $pontos;