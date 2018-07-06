<%-- 
    Document   : listaTipo
    Created on : 05/07/2018, 19:40:02
    Author     : Guilherme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lista de tipos</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" type="text/css" href="estilo.css">
    </head>
    <body>
    <head>
        <title>Lista de produtos</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" type="text/css" href="estilo.css">
    </head>
    <body>
        <header>
            <table>
                <tr>
                    <td>
                        <button class="carrinhobtn"><a href="listaTipo.html"><img src="logo.png"></a></button>
                    </td>
                    <td></td>
                    <td>
                        <input class="searchBar" placeholder="O que você procura?" type="text" name="search bar">
                    </td>
                    <td>
                        <button class="searchbtn btn-orange"><img src="lupa.png"></button>			
                    </td>
                    <td class="gambiarra"></td>
                    <td><button class="carrinhobtn"><img src="carrinho.png"></button></td>
                    <td><button class="carrinhobtn"><img src="entrar.png"></button></td>
                </tr>
            </table>
        </header>
        <h1 align="center">LISTA DE TIPOS</h1><br>
        <table width="100%" class="table table-striped table-bordered table-hover dataTable no-footer dtr-inline" id="dataTables-example" role="grid" aria-describedby="dataTables-example_info" border="2px" style="width: 100%;">
            <thead>
                <tr role="row">
                    <th class="sorting_asc" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="ID do tipo" style="width: 170px;">idTipo</th>
                    <th class="sorting" tabindex="0" aria-controls="dataTables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Nome do tipo" style="width: 170px;">Nome</th>
                </tr>
            </thead>
            <tbody>
                ${resultadoTipo}
            </tbody>
        </table>
    </body>
</html>
