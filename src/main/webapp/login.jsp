<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
</head>
<body onload='document.f.j_username.focus();'>
    <h3>Login with Username and Password</h3>
    <form name='f'
        action='${pageContext.request.contextPath}/j_spring_security_check'
        method='POST'>
        <table>
            <tr>
                <td>User:</td>
                <td><input type='text' name='j_username'
                    value='demo'>(demo)</td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='j_password'
                    value="demo" />(demo)</td>
            </tr>
            <tr>
                <td colspan='2'><input name="submit" type="submit"
                    value="Login" /></td>
            </tr>
        </table>
    </form>
</body>
</html>