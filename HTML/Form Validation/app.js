// Verifies password input
var password = document.getElementById("password");
var confirmPass = document.getElementById("confirmPass");
var username = document.getElementById("username");
var users = [ "username", "choose_wisely" ];
var pattern = new RegExp("^[a-zA-Z0-9_]{5,20}$");

function validateUsername() {

	if (!pattern.test(username.value)) {
		username
				.setCustomValidity('Username must be between 5-20 characters and use the following characters: a-z, A-Z, 0-9, _');
	}

	else if (users.includes(username.value)) {
		username
				.setCustomValidity("This username is taken. Please try another");
	} else {
		username.setCustomValidity('');
	}
}

function validatePassword() {
	if (password.value != confirmPass.value) {
		confirmPass.setCustomValidity("Passwords Don't Match");
	} else {
		confirmPass.setCustomValidity('');
	}
}

username.onkeyup = validateUsername;
confirmPass.onkeyup = validatePassword;

// jQuery functions

// Formats phone numbers
$(".phone").on('change', function() {
	var number = $(this).val()
	number = number.replace(/(\d{3})(\d{3})(\d{4})/, "$1-$2-$3");
	$(this).val(number)
});

// Serializes forms as JSON
(function() {
	function toJSONString(form) {
		var obj = {};
		var elements = form.querySelectorAll("input, select, textarea");
		for (var i = 0; i < elements.length; ++i) {
			var element = elements[i];
			var name = element.name;
			var value = element.value;

			if (name) {
				obj[name] = value;
			}
		}

		return JSON.stringify(obj);
	}

	document.addEventListener("DOMContentLoaded", function() {
		var formVal = document.getElementById("formValidation");
		var formAdd = document.getElementById("formAddress");
		var output = document.getElementById("output");
		var isValidForm;
		var json;

		$("#body").on("click", "input", function(event) {

			var elem = $(this);

			if (elem.is("[id^='submit']")) {

				isValidForm = formVal.checkValidity();

				if (isValidForm) {
					json = toJSONString(formVal);
					output.innerHTML = json;
				}

			}

			if (elem.is("[id^='submit2']")) {

				isValidForm = formAdd.checkValidity();

				if (isValidForm) {
					json = toJSONString(formAdd);
					output.innerHTML = json;
				}

			}

		});

	});

})();