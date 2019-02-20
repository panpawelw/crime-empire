<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="PL">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Crime Empire">
    <meta name="keywords" content="keywords here">
    <meta name="author" content="P&A">
    <link href="https://fonts.googleapis.com/css?family=Press+Start+2P&amp;subset=latin-ext" rel="stylesheet">
    <title>Crime Empire 1.0.0</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/main.css">
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
  </head>
  <body>
   <div class="main_container" id="workspace">
      
        <div class='game_welcome_container draggable'>
          <div class="bar">
          </div>
          <div class="text_area">
            <span>
            <br>
            You've been successfully Logged Out
            <br>
			<form action="login" class="button1 geos_welcome_container_button">
	    		<input type="submit" value="Log in" />
			</form>
			</span>
          </div>
        </div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/app.js" type="text/javascript"></script>
  </body>
</html>
