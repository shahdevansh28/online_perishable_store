<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container">
  <h1 class="logo">
    Online Perishable Store
  </h1>
  <form class="regform" method="POST" action="validateLogin">
    <input style="width:60%" type="text" name="email" placeholder="email" required/>  
    <br/>
    <input style="width:60%" type="password" name="password" placeholder="password" required/> 
    <br/> 
    <div style="margin-top:2%;margin-bottom:2%">
        <input type="radio" name="userType" value="customer" required/>
        <label style="width:70%;margin-left:2%;" for="userType">Customer</label>
        <input type="radio" style="margin-left:5%;" name="userType" value="admin" required/>
        <label style="width:70%;margin-left:2%" for="userType">Admin</label>
        <br/>
    </div>
    <button>Login</button>
  </form>
  <button class="link"><a class="decorate" href="signin">not a user? sign in </a></button>
</div>
<style>
  .logo{
    color:#FF9900;
    padding:2%;
    background-color: #232F3E;
    font-weight:bold;
    font-size:24px;
    position:relative;
    border-radius:10px;
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
    0% {margin:0px;left:0%;width:20vw;transform: rotate(90deg);}
    12.5% {margin:25px;left:25%;width:20vw;transform: rotate(0deg);}
    25% {margin:25px;left:50%;width:20vw;transform: rotate(0deg);}
    50% {margin:25px;left:100%;width:20vw;transform: rotate(0deg);}
    75% {margin:25px;left:75%;width:20vw;transform: rotate(0deg);}
    87.5% {margin:25px;left:50%;width:20vw;transform: rotate(0deg);}
    100% {margin:0px;left:0%;width:10vw;transform: rotate(-90deg);}
  }
</style>