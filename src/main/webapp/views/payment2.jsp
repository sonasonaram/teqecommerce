<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="teqecommerce.model.User" %>
        
<html>

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
	String[] pinfo = (String[]) request.getAttribute("PRODUCT_INFO");
	User user = (User) request.getAttribute("USER");
	%>

	<div style="padding: 20px;">
	
		<label style="font-family: Arial, Helvetica, sans-serif; font-size: xx-large; color: rgb(0, 0, 0);">
			Dear <%=user.getName() %>, please find below your purchase details
		</label>
		
		<br/><br/>
		

		<div
			style="background-color: lightgray; padding: 25px 10px; border-radius: 10px; margin-bottom: 10px; margin-top: 10px;">

			<label style="font-family: Arial, Helvetica, sans-serif; font-size: x-large; color: rgb(0, 0, 0);">
				Item and Price
			</label>
			<br/><br/>
			<label style="font-family: Arial, Helvetica, sans-serif; font-size: xx-large; color: rgb(0, 0, 0);">
				<%=pinfo[0] %>
			</label>
			<label style="font-family: Arial, Helvetica, sans-serif; font-size: larger; color: rgb(61, 61, 61);">
				Price: $<%=pinfo[1] %> US
			</label>

		</div>
		<div
			style="background-color: lightgray; padding: 25px 10px; border-radius: 10px; margin-bottom: 10px; margin-top: 10px;">

			
		<label style="font-family: Arial, Helvetica, sans-serif; font-size: large; color: rgb(0, 0, 0);">
			The products are dispatched to your registered address as follows:
		</label> <br/><br/>
		<label style="font-family: Arial, Helvetica, sans-serif; font-size: x-large; color: rgb(61, 61, 61);">
			<%=user.getAddress() %>
		</label>

		</div>
		
		<div
			style="background-color: lightgray; padding: 25px 10px; border-radius: 10px; margin-bottom: 10px; margin-top: 10px;">

			
		<label style="font-family: Arial, Helvetica, sans-serif; font-size: large; color: rgb(0, 0, 0);">
			You will shortly receive an email at your registered Email ID: <%=user.getEmail() %>
		</label>

		</div>
		

	</div>

</body>

</html>