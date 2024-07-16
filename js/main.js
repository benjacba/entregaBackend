
document.getElementById("registerForm").addEventListener("submit", (event) => {
    event.preventDefault();

    if(validar(this)){
        this.submit();
    }
})

function limpiarError(){
    var errores = document.getElementsByClassName("error");
    for (let i = 0; i < errores.length; i++) {
        errores[i].innerHTML = "";
    }
}

function validar(formulario){
    
    limpiarError();

    if(formulario.nombre.value.length <= 3){
    //    alert("Por favor ingrese su nombre");
    document.getElementById("errorNombre").innerText = "Por favor ingrese su nombre";
    formulario.nombre.focus();
        return false;
    }

    if(formulario.apellido.value.length <= 3){
    //    alert("Por favor ingrese su apellido");
    document.getElementById("errorApellido").innerText = "Por favor ingrese su apellido";
    formulario.apellido.focus();
        return false;
    }

    var expReg = /^(([^<>()\[\]\\.,;:\s@”]+(\.[^<>()\[\]\\.,;:\s@”]+)*)|(“.+”))@((\[[0–9]{1,3}\.[0–9]{1,3}\.[0–9]{1,3}\.[0–9]{1,3}])|(([a-zA-Z\-0–9]+\.)+[a-zA-Z]{2,}))$/;
    if(!expReg.test(formulario.email.value)) {
        document.getElementById("errorEmail").innerText = "Por favor ingrese un email valido";
        formulario.email.focus();
        return false;
    }

    if (formulario.password.value.trim().length < 8) {
        document.getElementById("errorPassword").innerText = "Por favor ingrese una contraseña de al menos 8 caracteres";
        formulario.password.focus();
        return false;
    }


    if (formulario.fechaNacimiento.value == "") {
        document.getElementById("errorFechaNacimiento").innerText = "Por favor ingrese su fecha de nacimiento";
        formulario.fechaNacimiento.focus();
        return false;
    }


    if (formulario.pais.value == "") {
        document.getElementById("errorPais").innerText = "Por favor seleccione un pais";
        formulario.pais.focus();
        return false;
    }

    if (!formulario.terminos.checked) {
        document.getElementById("errorTerminos").innerText = "Por favor acepte los terminos y condiciones";
        formulario.terminos.focus();
        return false;
    }

    alert("Se ha completado el registro correctamente!");

    window.location.href = "index.html";
    
    return true;
}

























