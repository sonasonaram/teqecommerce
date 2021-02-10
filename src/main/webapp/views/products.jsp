<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ page import="java.util.List" %>
        <%@ page import="teqecommerce.model.Product" %>
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

                <div style=" padding: 20px;">

                    <% List<Product> products;
                        try {
                        products = (List<Product>)request.getAttribute("PRODUCTS");

                            for (Product p : products) {
                            %>

                            <div
                                style="background-color:lightgray; padding: 10px; border-radius: 10px; margin-bottom: 10px; margin-top: 10px;">

                                    <label
                                        style="font-family: Arial, Helvetica, sans-serif; font-size: xx-large; color: rgb(0, 0, 0);">
                                        <%=p.getName() %>
                                    </label>
                                    <label
                                        style="font-family: Arial, Helvetica, sans-serif; font-size: larger; color: rgb(61, 61, 61);">Price:
                                        $<%=p.getPrice() %> US</label>
                                
                                
                                    
                                <form action="purchase" method="post">
                                
                                    <input type="hidden" name="productid" value="<%=p.getId() %>">
                                    <input
                                        style="float: right; font-family: Arial, Helvetica, sans-serif; font-size: large; color: rgb(0, 0, 0);"
                                        type="submit" value="Buy">
                                </form>
                                
                                
                                <form action="addtocart" method="post">
                                
                                    <input type="hidden" name="productid" value="<%=p.getId() %>">
                                    <input
                                        style="float: right; font-family: Arial, Helvetica, sans-serif; font-size: large; color: rgb(0, 0, 0);"
                                        type="submit" value="Add to Cart">
                                </form>


                            </div>

                            <% } } catch(Exception e) { } %>






                </div>



            </body>

            </html>