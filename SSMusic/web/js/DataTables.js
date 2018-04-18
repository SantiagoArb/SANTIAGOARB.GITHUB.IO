/* 
 * Este Script sirve para manipular los datos de la tabla
 * @author Santiago Cardona Saldarriaga
 * @version 28/03/2018
 * @see https://datatables.net/
 */
function Tablas() {
    //la funcion Tablas(), sirve para cambiar los datos almancenados en la misma al momento de dar click en el select #tipo_gestion
    $.post("comboT.jsp", $("#data").serialize(), function (data) {
        /* @param {tabla_grupos} Llama al table con id ='tabla_grupos', para que se muestre en la vista */
        $("#tabla_grupos").html(data);
    });
}
function mostrarTablas() {
    var selectBox = document.getElementById('grupos');
    var userInput = selectBox.options[selectBox.selectedIndex].value;
    if (userInput !== '') {
        document.getElementById('tablas').style.visibility = 'visible';
        Tablas();
    }
    if (userInput === '') {
        document.getElementById('tablas').style.visibility = 'hidden';
    }
}

$(document).ready(function () {
    var table = $('#Izi').DataTable({
        language: {
            sProcessing: "Procesando...",
            sLengthMenu: "Mostrar _MENU_  Registros",
            sZeroRecords: "No se encontraron resultados",
            sEmptyTable: "Ningún dato disponible en esta tabla",
            sInfo: "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
            sInfoEmpty: "Mostrando registros del 0 al 0 de un total de 0 registros",
            sInfoFiltered: "(filtrado de un total de _MAX_ registros)",
            sInfoPostFix: "",
            sSearch: "Buscar:",
            sUrl: "",
            sInfoThousands: ",",
            sLoadingRecords: "Cargando...",
            oPaginate: {
                sFirst: "Primero",
                sLast: "Último",
                sNext: "Siguiente",
                sPrevious: "Anterior"
            },
            oAria: {
                sSortAscending: ": Activar para ordenar la columna de manera ascendente",
                sSortDescending: ": Activar para ordenar la columna de manera descendente"
            }
        },
        ajax: {
            method: "POST",
            url: "../../Otro",
            dataSrc: "datos"
        },
        select: "single",
        columns: [
            {
                className: 'details-control',
                orderable: false,
                data: null,
                defaultContent: '',
                render: function () {
                    return '<i class="fa fa-plus-square" aria-hidden="true"></i>';
                },
                width: '15px'
            },
            {data: "id"},
            {data: "NIT_Empresa"},
            {data: "Nom_Empresa"},
            {data: "Tipo_operacion"},
            {data: "Valor_operacion"}
        ],
        order: [[1, 'asc']],
        dom: 'fBrtip',
        buttons: [
            {
                extend:    'excelHtml5',
                text:      '<i class="fa fa-file-excel-o"></i>',
                titleAttr: 'Excel',
                className: 'btn btn-success btn-sm m-5 width-140 assets-select-btn export-print'
            },
            {
                extend:    'csvHtml5',
                text:      '<i class="fa fa-file-text-o"></i>',
                titleAttr: 'CSV',
                className: 'btn btn-info btn-sm m-5 width-140 assets-select-btn export-print'
            },
            {
                extend:    'pdfHtml5',
                text:      '<i class="fa fa-file-pdf-o"></i>',
                titleAttr: 'PDF',
                className: 'btn btn-warning btn-sm m-5 width-140 assets-select-btn export-print'
            }
        ]
        
    });
    $('#Izi tbody').on('click', 'td.details-control', function () {
        var tr = $(this).closest('tr');
        var tdi = tr.find('i.fa');
        var row = table.row(tr);

        if (row.child.isShown()) {
            // This row is already open - close it
            row.child.hide();
            tr.removeClass('shown');
            tdi.first().removeClass('fa-minus-square');
            tdi.first().addClass('fa-plus-square');
        } else {
            // Open this row
            row.child(format(row.data())).show();
            tr.addClass('shown');
            tdi.first().removeClass('fa-plus-square');
            tdi.first().addClass('fa-minus-square');
        }
    });

    table.on('user-select', function (e, dt, type, cell, originalEvent) {
        if ($(cell.node()).hasClass('details-control')) {
            e.preventDefault();
        }
    });
    $(document).on('click', '.btn_delete', function () {
        var id = $(this).attr('id');
        var row = $(this).parent().parent();
        var nombre = $(this).parents("tr").find("td")[1].innerHTML;
        $('#Estudiante').html(nombre);
    });
});
function format(d) {
    // `d` is the original data object for the row
    return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">' +
            '<tr>' +
            '<td>Full name:</td>' +
            '<td>' + d.nombres + '</td>' +
            '</tr>' +
            '<tr>' +
            '<td>Extension number:</td>' +
            '<td>' + '</td>' +
            '</tr>' +
            '<tr>' +
            '<td>Extra info:</td>' +
            '<td>And any further details here (images etc)...</td>' +
            '</tr>' +
            '</table>';
}

