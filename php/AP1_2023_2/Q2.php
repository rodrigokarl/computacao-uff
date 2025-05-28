<?php
    function processaClassificacao($file_input, $file_output) {
        $fl_in = fopen($file_input, "r");
        $fl_out = fopen($file_output, "w");

        while (fgetcsv($fl_in) !== false) {
            $dados = fgetcsv($fl_in, 1000, ";");
            $x0 = $dados[0];
            $x1 = $dados[1];
            $resultado = classificaFlor($x0, $x1);
            switch ($resultado) {
                case Iris::Setosa:
                    $resultado = "Iris-Setosa";
                    break;
                case Iris::Versicolor:
                    $resultado = "Iris-Versicolor";
                    break;
                case Iris::Virginica:
                    $resultado = "Iris-Virginica";
                    break;
                default:
                    $resultado = "";
            }
            $dados[] = $resultado;
            fputcsv($fl_out, $dados);
        }
    }