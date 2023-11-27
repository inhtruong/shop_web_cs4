const registerButton = document.getElementById("register");
const loginButton = document.getElementById("login");
const container = document.getElementById("container");

registerButton.addEventListener("click", () => {
    container.classList.add("right-panel-active");
});

loginButton.addEventListener("click", () => {
    container.classList.remove("right-panel-active");
});

document.addEventListener("DOMContentLoaded", function() {
    const loginForm = document.getElementById("loginForm");
    const registerForm = document.getElementById("registerForm");

    // Gửi yêu cầu đăng nhập
    loginForm.addEventListener("submit", function(e) {
        e.preventDefault();
        const username = document.getElementById("loginEmail").value;
        const password = document.getElementById("loginPassword").value;

        const obj = {
            username: username,
            password: password
        };

        $.ajax({
            headers: {
                'accept': 'application/json',
                'content-type': 'application/json'
            },
            type: 'POST',
            url: 'http://localhost:8080/api/auth/login',
            data: JSON.stringify(obj),
            success: function(data) {
                Swal.fire("Success", "Login successful", "success").hide();
            },
            error: function(error) {
                Swal.fire("Error", "Login failed", "error");
            }
        });
    });

    // Gửi yêu cầu đăng ký
    registerForm.addEventListener("submit", function(e) {
        e.preventDefault();
        const username = document.getElementById("usernameReg").value;
        const email = document.getElementById("registerEmail").value;
        const password = document.getElementById("registerPassword").value;

        const obj = {
            username: username,
            email: email,
            password: password
        };

        $.ajax({
            headers: {
                'accept': 'application/json',
                'content-type': 'application/json'
            },
            type: 'POST',
            url: 'http://localhost:8080/api/auth/register',
            data: JSON.stringify(obj),
            success: function(data) {
                Swal.fire("Success", "Registration successful", "success").hide();
            },
            error: function(error) {
                Swal.fire("Error", "Registration failed", "error");
            }
        });
    });
});

/* Show login form on button click */

// $('.loginBtn').click(function(){
//     $('.login').show();
//     $('.signUp').hide();
//     /* border bottom on button click */
//     $('.loginBtn').css({'border-bottom' : '2px solid #ff4141'});
//     /* remove border after click */
//     $('.signUpBtn').css({'border-style' : 'none'});
// });


/* Show sign Up form on button click */

// $('.signUpBtn').click(function(){
//     $('.login').hide();
//     $('.signUp').show();
//     /* border bottom on button click */
//     $('.signUpBtn').css({'border-bottom' : '2px solid #ff4141'});
//     /* remove border after click */
//     $('.loginBtn').css({'border-style' : 'none'});
// });