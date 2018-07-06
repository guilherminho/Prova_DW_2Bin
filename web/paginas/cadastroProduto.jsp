<%-- 
    Document   : produto
    Created on : 29/06/2018, 09:30:41
    Author     : a1711997
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Cadastro de Produtos</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" type="text/css" href="estilo.css">
    </head>
    <body>
        <header>
            <table>
                <tr>
                    <td>
                        <button class="carrinhobtn"><a href="cadastroProduto.html"><img src="logo.png"></a></button>
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
        <h1 align="center">CADASTRO DE PRODUTOS</h1><br>
        <form>
            <div id="formulario">
                <label for="id"> Id </label><br>
                <input type="text" name="id"><br><br>
                <label for="nome"> Nome </label><br>
                <input type="text" name="nome"><br><br>
                <label for="preco"> Preço </label><br>
                <input type="text" name="preco"><br><br>
                <label for="descricao"> Descrição </label><br>
                <input type="text" name="descricao"><br><br>
                <label for="tipo"> Tipo </label><br>
                <input type="text" name="tipo"><br><br>
                <label for="marca"> Marca </label><br>
                <textarea name="marca"></textarea><br><br>
                <button type="submit" class="btn btn-orange"> CADASTRAR PRODUTO </button>
            </div>
        </form>
    </body>
</html>
