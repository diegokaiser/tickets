var app = [];

app.basics = {
    header: function() {
        $("body").on('scroll', function(){
            if($("body").scrollTop() > 70) {
                $("header").addClass("scrolled");
            } else {
                $("header").removeClass("scrolled");
            }
        })
    }
}

app.users = {
    registerValidations: function() {
        let usersForms = $('.form');
        let nombre = $('#nombre');
        let apellido = $('#');
        let tipoDocumento = $('#');
        let numeroDocumento = $('#');
        let correo = $('#');
        let contrasena = $('#');
        let recontrasena = $('#');
        let button = $('#send')
        if (usersForms.length) {
          
          if (
            nombre == "" || 
            apellido == "" || 
            tipoDocumento == "" || 
            numeroDocumento == "" ||
            correo == "" ||
            contrasena == "" ||
            recontrasena == "" ||
            contrasena != recontrasena
          ) {            
            button.prop("disabled", True);
          } else {
            button.prop("disabled", false);
          }
        }
    }
}

$(document).ready(function($){
    
})