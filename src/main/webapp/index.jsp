<%@  page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Insert title here</title>

<style>

.container {

    display:flex;

    gap: 50px;
    }

.fs1{

background-color:pink;

}

.fs2{

background-color:yellow;

}

.fs3{

background-color:orange;
}



fieldset {

    width: 30%;

    padding: 15px;

}

.button-container{



   text-align:center;

   margin-top:30px; 

}

.view-container{



   text-align:center;

   margin-top:30px; 



}



</style>

</head>

<body>
<form action="reginfo" method="post">



<div class="container">



<fieldset class="fs1">

<h3 align="center">Personal Info</h3>

<label>Name: </label>

<input type="text" name="name" placeholder="Enter the user name" ><br><br>

<label>Email: </label>

<input type="email" name="email" placeholder="Enter the email"><br><br>

<label>Gender: </label>

<input type="radio" name="gender" value="Male">Male
<input type="radio" name="gender" value="Female">Female

<input type="radio" name="gender" value="Other">Other<br><br>

<label>Phone number:</label>

<input type="tel" name="pnumber" >



</fieldset>



<fieldset class="fs2">

<h3 align="center">Address Info</h3>

<label>Village:</label>
<input type="text" name="village"><br><br>

<label>Mandal:</label>

<input type="text" name="mandal"><br><br>

<label>District:</label>

<input type="text" name="district"><br><br>



<label>State:</label>

 <input type="text" name="state">

</fieldset>
<fieldset class="fs3">

<h3 align="center">Education Info</h3>

<label>degree:</label>

<input type="text" name="degree"><br><br>

<label>college:</label>

<input type="text" name="college"><br><br>

<label>yearofpass:</label>

<input type="text" name="yearofpass"><br><br>

</fieldset>

</div>

<div class="button-container">
<input type="submit" value="Submit">

 </div>

</form>



<form action="viewUsers" method="get">

<div class="view-container">

    <input type="submit" value="View Users">

    </div>

</form>

</body>

</html>