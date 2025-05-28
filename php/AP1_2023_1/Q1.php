<?php
    $arr = array("id" => 1, "nome" => "Flavio", "receita" => [10.0, 5.5, 2.3, 3.0]);

    function verificaTipo($array) {
        $expected_types = array("id" => "integer", "nome" => "string", "receita" => "array");

        foreach ($array as $key => $value) {
            if (!isset($value) || gettype($value) !== $expected_types[$key]) {
                return false;
            }
        }
        return true;
    }

    $r = verificaTipo($arr);

    echo $r;