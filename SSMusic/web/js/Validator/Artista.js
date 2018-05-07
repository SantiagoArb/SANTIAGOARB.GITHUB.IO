$(document).ready(function () {
    $('#Reg_Artistas').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            NOM_ARTISTA: {
                validators: {
                    stringLength: {
                        min: 3,
                        max: 8,
                        message: 'Por introduce un nombre de minimo 3 caracteres y maximo 8'
                    },
                    notEmpty: {
                        message: 'Por favor introduce un nombre'
                    },
                    regexp: {
                        regexp: /^[a-z\s]+$/i,
                        message: 'El nombre no puede contener caracteres especiales ni numeros'
                    }
                }
            },
            NOM_REPRESENTANTE: {
                validators: {
                    stringLength: {
                        min: 3,
                        max: 20,
                        message: 'El nombre debe ser de un minimo de 3 caracteres y maximo 20'
                    },
                    notEmpty: {
                        message: 'Por favor introduce un nombre'
                    },
                    regexp: {
                        regexp: /^[a-z\s]+$/i,
                        message: 'El nombre no puede contener caracteres especiales ni numeros'
                    }
                }
            },
            DOC_REPRESENTANTE: {
                validators: {
                    stringLength: {
                        min: 10,
                        max: 15,
                        message: 'El documento debe ser de un minimo de 8 caracteres y maximo 15'
                    },
                    notEmpty: {
                        message: 'Por favor introduce un documento valido'
                    }
                }
            },
            TEL_REPRESENTANTE: {
                validators: {
                    stringLength: {
                        min: 7,
                        max: 12,
                        message: 'Por favor introduce un numero telefonico de un minimo de 7 caracteres y maximo 12'
                    },
                    notEmpty: {
                        message: 'Por favor introduce un numero telefonico'
                    }
                }
            },
            COR_REPRESENTANTE: {
                validators: {
                    emailAddress: {
                        message: 'Por favor introduce un correo electronico valido'
                    },
                    notEmpty: {
                        message: 'Por favor introduce un numero telefonico'
                    }
                }
            },
            
            select_empresas: {
                validators: {
                    notEmpty: {
                        message: 'Por favor selecciona una empresa'
                    }
                }
            }
        }
    });
});

