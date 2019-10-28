$(document).ready(function() {

	var isCadastro = true;

	var labelButton = $(document).find(".label-cadastro");
	var contentCadastro = $(document).find(".cadastro");
	var contentLogin = $(document).find(".login");

	var cadastroButton = $(document).find(".button-cadastro");

	//funcao label de cadastro 
	labelButton.on("click", function() {

	if (isCadastro) {
		contentLogin.hide();
		contentCadastro.show();
	} else {
		contentCadastro.hide();
		contentLogin.show();
	}

    isCadastro = !isCadastro
    labelButton.html(isCadastro? "Cadastre-se já!": "Voltar");
    cadastroButton.val(isCadastro? "Acessar": "Cadastrar");
	});

});