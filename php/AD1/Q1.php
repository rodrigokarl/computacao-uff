<?php
    function verificarAnagrama($string1, $string2) {
        if (strlen($string1) !== strlen($string2)) {
            return false;
        }
        $sorted1 = str_split($string1);
        sort($sorted1);

        $sorted2 = str_split($string2);
        sort($sorted2);

        return ($sorted1 === $sorted2);
    }

    echo verificarAnagrama("amor", "roma");
?>