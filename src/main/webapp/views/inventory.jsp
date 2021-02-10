<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <title>TeqECommerce</title>
    </head>

    <body style="margin: 0; padding: 0;">
        <div style="background-color: chocolate; width: 100vw; height: 80px; display: flex; align-items: center; ">
            <div style="width: 100%; margin: 0; padding: 0 20px">
                <a href="home" style="text-decoration: none;"><label style="font-family: Arial, Helvetica, sans-serif; font-size: xx-large; color: rgb(255, 255, 255);">TeqECommerce</label></a>
                <a href="login" style="text-decoration: none;"><button style="padding: 10px; float: right;">Login / Register</button></a>
                <a href="allproduct" style="text-decoration: none;"><button style="padding: 10px; float: right;">See Products</button></a>
                <a href="cart" style="text-decoration: none;"><button style="padding: 10px; float: right;">Cart</button></a>
            </div>
        </div>

		<%
		String status;
		try {
			status = request.getAttribute("STATUS").toString();
		} catch(Exception e) {
			status = "";
		}
		%>

        <h2><%= status %>Add a New Product Below</h2>
        
        <form action="addproduct" method="post">

            <label>Product Name</label>
            <input name="name" type="text">
            
            <label>Product Price</label>
            <input name="price" type="number">
            
            <input type="submit" value="Add Product">
        </form>

    </body>

    </html>