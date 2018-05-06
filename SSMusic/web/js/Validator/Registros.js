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
                        min: 2
                    },
                    notEmpty: {
                        message: 'Por favor introduce tu nombre ctm'
                    }

                }

            }
        }
    });
});

