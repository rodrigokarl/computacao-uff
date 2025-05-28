<?php
    function remover_caracteres_especiais($string) {
        $string = preg_replace('/[^A-Z]/ui', '', $string);
        $string = preg_replace('/\d/', '', $string);
        return $string;
    }

    $result = remover_caracteres_especiais("FlA!!vio123!@#");
    echo $result;