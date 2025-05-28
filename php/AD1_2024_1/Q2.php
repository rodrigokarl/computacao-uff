<?php
    function verificaEtapa1($senha){
        if (strlen($senha) >= 6) {
            return true;
        }
        return false;
    }

    function verificaEtapa2($senha) {
        if (preg_match('/[A-Z]/', $senha)) {
            return true;
        }
        return false;
    }

    function verificaEtapa3($senha) {
        if (preg_match('\d/', $senha)) {
            return true;
        }
        return false;
    }

    function verificaEtapa4($senha) {
        if (preg_match('/(\!|\@|\#|\$|\%|\&|\*|\(|\)|\[|\]|\{|\})/', $senha)) {
            return true;
        }
        return false;
    }

?>