<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ page import="java.util.List" %>
        <%@ page import="teqecommerce.model.User" %>
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

                    <% List<String[]> products;
                    User user = (User) request.getAttribute("USER");
                    %>
                    
                    <label style="font-family: Arial, Helvetica, sans-serif; font-size: xx-large; color: rgb(0, 0, 0);">
						Dear <%=user.getName() %>, please find below the Items in your cart
					</label>
					
					<br/><br/>
                    
                    
                    
                    <%
                        try {
                        products = (List<String[]>)request.getAttribute("PRODUCT_INFO");

                            for (String[] product : products) {
                            %>

                            <div
                                style="background-color:lightgray; padding: 10px; border-radius: 10px; margin-bottom: 10px; margin-top: 10px;">


                                    <label
                                        style="font-family: Arial, Helvetica, sans-serif; font-size: xx-large; color: rgb(0, 0, 0);">
                                        <%=product[0] %>
                                    </label>
                                    <label
                                        style="font-family: Arial, Helvetica, sans-serif; font-size: larger; color: rgb(61, 61, 61);">Price:
                                        $<%=product[1] %> US</label>
                                        
                                        
                                        
                                <form action="deletefromcart" method="post">
                                        
                                    <input type="hidden" name="cartid" value="<%=product[2] %>">
                                    <input
                                        style="float: right; font-family: Arial, Helvetica, sans-serif; font-size: large; color: rgb(0, 0, 0);"
                                        type="submit" value="Delete From Cart">
                                </form>
                                
                                 


                            </div>

                            <% } } catch(Exception e) { } %>


                </div>
                
                
                <div style=" padding: 20px;">
                	
                	<form action="purchaseall" method="post">
                        <input
                            style="float: right; font-family: Arial, Helvetica, sans-serif; font-size: large; color: rgb(0, 0, 0);"
                            type="submit" value="Purchase All the above items">
                    </form>
                	
                </div>



            </body>

            </html>