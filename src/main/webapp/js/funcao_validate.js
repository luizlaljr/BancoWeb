/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function validarCampos() {

    var nome = document.getElementById("txtNome").value;
    var login = document.getElementById("txtLogin").value;
    var cpf = document.getElementById("txtCpf").value;
    var senha1 = document.getElementById("txtSenha1").value;
    var senha2 = document.getElementById("txtSenha2").value;

    if ((nome === null) || (nome === "") || (/^\s+$/.test(nome))) {
        document.getElementById("txtNome").value = "";
        document.getElementById("txtNome").focus();
        document.querySelector('#alert').innerHTML = "O campo nome está vazio!";
        $('#alert').collapse('show');
        return false;

    } else if ((login === null) || (login === "") || (/^\s+$/.test(login))) {
        $('#alertNomeVazio').collapse('hide');
        document.getElementById("txtLogin").value = "";
        document.getElementById("txtLogin").focus();
        document.querySelector('#alert').innerHTML = "O campo login está vazio!";
        $('#alert').collapse('show');
        return false;

    } else if (testaCPF(cpf)) {
        document.getElementById("txtCpf").value = "";
        document.getElementById("txtCpf").focus();
        document.querySelector('#alert').innerHTML = "O CPF é inválido!";
        $('#alert').collapse('show');
        return false;

    } else if ((senha1 === null) || (senha1 === "") || (/^\s+$/.test(senha1))) {
        document.getElementById("txtSenha1").value = "";
        document.getElementById("txtSenha1").focus();
        document.querySelector('#alert').innerHTML = "A senha está vazia!";
        $('#alert').collapse('show');
        return false;

    } else if (senha1 !== senha2) {
        document.getElementById("txtSenha2").value = "";
        document.getElementById("txtSenha2").focus();
        document.querySelector('#alert').innerHTML = "A senha não confere!";
        $('#alert').collapse('show');
        return false;

    }
    return true;
}

function testaCPF(CPF) {
    var strCPF = CPF.replace(/[\.-]/g,"");
    var Soma;
    var Resto;
    Soma = 0;
    if ((strCPF === "00000000000") || (strCPF === "") || (strCPF === null) || (/^\s+$/.test(strCPF)))
        return true;

    for (i = 1; i <= 9; i++)
        Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (11 - i);
    Resto = (Soma * 10) % 11;

    if ((Resto === 10) || (Resto === 11))
        Resto = 0;

    if (Resto !== parseInt(strCPF.substring(9, 10)))
        return true;

    Soma = 0;
    for (i = 1; i <= 10; i++)
        Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (12 - i);
    Resto = (Soma * 10) % 11;

    if ((Resto === 10) || (Resto === 11))
        Resto = 0;

    if (Resto !== parseInt(strCPF.substring(10, 11)))
        return true;

    return false;
}


