$(document).ready(function() {

	var isLogin = true;

	var labelButton = $(document).find(".label-cadastro");
	var contentCadastro = $(document).find(".cadastro");
	var contentLogin = $(document).find(".login");

	var cadastroButton = $(document).find(".button-cadastro");

	const HOME_URL = "file:///C:/Users/lmilano/Desktop/ProgIII/ProgIII/home.html";

	var form = $("#form");

	//funcao label de cadastro 
	labelButton.on("click", function() {

		if (isLogin) {
			contentLogin.hide();
			contentCadastro.show();
		} else {
			contentCadastro.hide();
			contentLogin.show();
		}

	    isLogin = !isLogin
	    removeRequired();
	    labelButton.html(isLogin? "Cadastre-se já!": "Voltar");
	    cadastroButton.val(isLogin? "Acessar": "Cadastrar");
	});

	form.on("submit", function() {

		var emailCad = $(document).find("#email_cad");
		var senhaCad = $(document).find("#senha_cad");

		var emailLog = $(document).find("#email_log");
		var senhaLog = $(document).find("#senha_log");

		if (!isLogin) {
			cadastrarLocalStorage(emailCad.val(), senhaCad.val());
		} else {
			logarLocalStorage(emailLog.val(), senhaLog.val());
		}

		return false;
	});

	function logarLocalStorage(email, senha) {
		var usuario = window.localStorage[email];
		if(usuario === undefined) {
			alert("Email ou Senha errados");
		}
		else {
			if (senha === usuario) {
				window.location=HOME_URL;
			} else {
				alert("Senha incorreta")
			}
		}
	}

	function cadastrarLocalStorage(email, senha) {
		var usuario = getLocalStorage(email);
		if (usuario === undefined) {
			alert("Email já cadastrado");
		} else {
			if (isValid()) {
				alert("cadastrado com sucesso");
				window.localStorage.setItem(email, senha);
			}
		} 
	};

	function getLocalStorage(key) {
		if (typeof window.localStorage === undefined){
			return undefined;
		}
		return window.localStorage.getItem(key);
	}

	function removeRequired() {
		if (isLogin) {
			$("#email_log").attr("required", "required");
			$("#senha_log").attr("required", "required");

			$("#email_cad").removeAttr("required");
			$("#senha_cad").removeAttr("required");
		} else {
			$("#email_cad").attr("required", "required");
			$("#senha_cad").attr("required", "required");

			$("#email_log").removeAttr("required");
			$("#senha_log").removeAttr("required");
		}
	}

	function isValid() {
		if (isLogin) {
			return $("#email_log").val() !== "" && $("#senha_log").val() !== "";
		} else {
			return $("#email_cad").val() !== "" && $("#senha_cad").val() !== "";
		}
	}

});