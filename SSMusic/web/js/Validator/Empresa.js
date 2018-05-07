$(document).ready(function () {
    $('#Reg_Empresa').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            NIT_EMPRESA_D: {
                validators: {
                    stringLength: {
                        min: 3,
                        max: 8,
                        message: 'Por introduce un NIT de minimo 3 caracteres y maximo 8'
                    },
                    notEmpty: {
                        message: 'Por favor introduce un NIT'
                    },
                    regexp: {
                        regexp: /^[0-9]+$/,
                        message: 'El NIT no puede contener valores alfabeticos'
                    }
                }
            },

            NOM_EMPRESA_D: {
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
            NOM_ENCARGADO_D: {
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
            DOC_ENCARGADO_D: {
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
            TEL_ENCARGADO_D: {
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
            COR_ENCARGADO_D: {
                validators: {
                    emailAddress: {
                        message: 'Por favor introduce un correo electronico valido'
                    },
                    notEmpty: {
                        message: 'Por favor introduce un numero telefonico'
                    }
                }
            },
            TIPO_OPERACION_D: {
                validators: {
                    notEmpty: {
                        message: 'Por favor introduce un tipo de operacion'
                    }
                }
            },
            VALOR_OPERACION_D: {
                validators: {
                    notEmpty: {
                        message: 'Por favor introduce un monto $'
                    }
                }
            }
        }
    });



});

