<%-- 
    Document   : Register
    Created on : 17 Jan 2026, 5:37:42 pm
    Author     : riya vesuwala
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p style="color:red;">
            ${msg}
        </p>

        <h1>User Registration</h1>
        <form action="Registration" method="post">
            Username : <input type="text" name="username" ><br/>
            Login Id : <input type="text" name="loginid" ><br/>
            Password : <input type="text" name="password" ><br/>
            Password Question : <select name="question">
                <option>What is your pet name?</option>
                <option>What is your birth city?</option>
                <option>What is your favorite food?</option>
                <option>What is your school name?</option>
            </select><br/>
            Answer : <input type="text" name="answer" ><br/>
            Email : <input type="email" name="email" ><br/>
            Phone : <input type="text" name="phone" ><br/>
            Address : <textarea name="address" ></textarea><br/>
            City : <input type="text" name="city" ><br/>
            State : <input type="text" name="state" ><br/>
            Country : <input type="text" name="country" ><br/>
            Pin : <input type="text" name="pin" ><br/>
            Captcha :
            <b style="font-size: 20px;color: blue;">
                ${sessionScope.captcha}
            </b><br/>
            <input type="text" name="usercaptcha" placeholder="Enter CAPTCHA" required><br/>
            <input type="submit" value="Register">
        </form>
        <a href="login.html">Already Register</a>
    </body>
</html>
