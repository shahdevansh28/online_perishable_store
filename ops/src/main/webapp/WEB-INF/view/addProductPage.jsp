<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>add product page</title>
</head>
<body>
    
    <div class="topnav" id="myTopnav">
        <a href="adminHome">Home</a>
        <a href="addProduct"  class="active">add-product</a>
        <a href="displayAllProducts">inventory</a>
        <a href="listAllUsers">consumers</a>
        <a href="login">Logout</a>
        <a href="javascript:void(0);" class="icon" onclick="myFunction()">
            <i class="fa fa-bars"></i>
        </a>
    </div>
    <p class="logo">add product page</p>
    <form action="saveProduct" class="regform" method="post">
        <input class="myinput" type="text" name="productName" placeholder="productName" /><br/>
        
        <input class="myinput" type="text" name="productDescription" placeholder="productDescription" /><br/>
        <input class="myinput" type="text" name="productPrice" placeholder="productPrice" /><br/>
        <input class="myinput" type="text" name="productQuantity" placeholder="productQuantity" /><br/>
        <textarea class="similarInput" type="text" name="productImage" placeholder="productImage" ></textarea><br/>
        <div style="margin-top:2%;margin-bottom:2%">
            
            <input type="radio" name="productType" value="vegetable"/>
            <label style="width:70%;margin-right:30px;" for="productType">vegetable</label>
            <input type="radio" name="productType" value="fruit"/>
            <label style="width:70%;margin-right:30px;" for="productType">fruit</label>
            <input type="radio" name="productType" value="food"/>
            <label style="width:70%;margin-right:30px;" for="productType">food</label>
            <br/>
            <button type="submit">add product</button>
        </div>
    </form>
</body>
</html>
<style>
    
    .topnav {
      overflow: hidden;
      background-color: #333;
      margin-bottom:2%;
    }
    .logo{
        background-color:#232F3E;
        margin:20px;
        padding:5px;
        width:40%;
        margin-left:30%;
        text-align: center;
        font-variant: small-caps;
        color:#FF9900;
        border-radius: 20px;
        font-weight:bold;
        font-size:30px;
        position:relative;
        /* animation: logo 10s infinite; */
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
      .myinput{
        width:60%;
      }
      .similarInput{
        border:none;
        outline:none;
        border-bottom:1px solid black;
        font-size:20px;
        margin-left:1.5%;
        width:60%;
      }
      .button1{
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
    
    .topnav a {
      width:9%;
      float: left;
      display: block;
      color: #f2f2f2;
      text-align: center;
      padding: 14px 16px;
      text-decoration: none;
      font-size: 17px;
    }
    
    .topnav a:hover {
      background-color: #ddd;
      color: black;
    }
    
    .topnav a.active {
      background-color: #FF9900;
      color: white;
    }
    
    .topnav .icon {
      display: none;
    }
    
    @media screen and (max-width: 600px) {
      .topnav a:not(:first-child) {display: none;}
      .topnav a.icon {
        float: right;
        display: block;
      }
    }
    
    @media screen and (max-width: 600px) {
      .topnav.responsive {position: relative;}
      .topnav.responsive .icon {
        position: absolute;
        right: 0;
        top: 0;
      }
      .topnav.responsive a {
        float: none;
        display: block;
        text-align: left;
      }
    }
    .product{
        width:21%;
        margin-left:2%;
        float:left;
    }
    button{
        cursor:pointer;
        background-color: #FF9900;
        border:none;
        outline:none;
        color:black;
        font-size:20px;
        padding:5px;
        border-radius:10px;
        margin:1%;
        width:60%;
    }
    .productImage{
        width:90%;
        margin:2%;
        border-radius:5px;
    }
    .prodName{
        font-size:20px;
    }
    .prodDesc{
        font-size:15px;
    }
    .prodPrice{
        font-size:30px;
        color:rgb(134, 0, 0);
    }
    </style>