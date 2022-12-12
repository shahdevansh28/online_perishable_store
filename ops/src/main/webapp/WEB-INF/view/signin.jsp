<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<body>
  <div class="container">
    <h1 class="logo">
      Online Perishable Store
    </h1>

  <form class="regform" method="POST" action="validateSignin">
    <input style="width:60%" type="text" name="email" placeholder="email"/>  
    <br/>
    <input style="width:60%" type="password" name="password" placeholder="password"/> 
    <br/> 
    <input type="hidden" name="userType" value="customer"/>
    <div>
      <button>Signin</button>
    </div>
  </form>
  <button class="link"><a class="decorate" href="login">already a user? login</a></button>
</div>
</body>
</html>
<style>
  .logo{
    background-color:#FF9900;
    margin:20px;
    padding:3%;
    color:#232F3E;
    border-radius: 20%;
    font-weight:bold;
    font-size:30px;
    position:relative;
    animation: logo 10s infinite;
    animation-direction: alternate;
  }
  body{
    font-family:helvetica;
    font-size:20px;
  }
  .container{
    margin:2%;
    padding:2%;
  }
  .regform{
    width:70%;
    margin-left:30%;
    /* margin-top:5%; */
  }
  input{
    border:none;
    outline:none;
    border-bottom:1px solid black;
    font-size:20px;
    margin:1%;
  }
  button{
    background-color:#FF9900;
    outline:none;
    border:none;
    font-size:20px;
    border-radius:10px;
    color:black;
    padding:1%;
    width:60%;
    margin-top: 1%; 
  }
  .decorate{
    text-decoration:none;
    color:white;
  }
  .link{
    background-color:#232F3E;
    color:white;
    margin-left:30%;
    width:42%;
  }
  @keyframes logo{
    0% {left:0%;width:15vw;transform: rotate(0deg);}
    25%{left:32%;width:15vw;transform: rotate(360deg);}
    50% {left:100%;width:15vw;transform: rotate(0deg);}
    75%{left:32%;width:15vw;transform: rotate(-360deg);}
    100% {left:0%;width:15vw;transform: rotate(0deg);}
  }
</style>