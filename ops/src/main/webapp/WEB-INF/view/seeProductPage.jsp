<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>display product page</title>
</head>
<script>
    function validate(event){
        const productQuantity=parseInt(document.getElementById("productQuantity").value);
        const itemQuantity=parseInt(document.getElementById("itemQuantity").value);
        // alert("in validate"+productQuantity + " " + itemQuantity)
        if(productQuantity<itemQuantity){
            alert("Not enough items present in inventory");
            event.preventDefault();
        }
    }
</script>
<body>
    <div class="topnav" id="myTopnav">
        <a href="customerHome" class="active">Home</a>
        <a href="seeMyCart?userId=${user.userid}">Cart</a>
        <a href="seeMyOrders?userId=${user.userid}">Orders</a>
        <a href="login">Logout</a>
        <a href="javascript:void(0);" class="icon" onclick="myFunction()">
            <i class="fa fa-bars"></i>
        </a>
    </div>
    <div style="width: 100%;">
        <div style="width: 40%;  float: left; "> 
            <image  class="productImage" src="${product.productImage}"></image>
        </div>
        <div style="margin-left: 40%;  "> 
            
            <p class="largeProdName">Product: ${product.productName}</p>
            <p class="prodName">Price : <span class="largeProdPrice">${product.productPrice}</span>.00 Rs.</p>
            <p class="prodName">Product Type : ${product.productType}</p>
            <p class="largeProdDesc">${product.productDescription}</p>
            <p class="prodName">only <span class="prodPrice">${product.productQuantity}</span> left in stock</p>
        </div>
    </div>
    <div class="container">
        <input type="hidden" id="productQuantity" value="${product.productQuantity}"/>
        <form action="addToCart" method="GET" onSubmit="validate(event)">
            <input type="hidden" name="productId" value="${product.productid}"/>
            <input type="hidden" name="userId" value="${user.userid}" />
            Item Quantity : 
            <input type="text" value="1" id="itemQuantity" name="itemQuantity" placeholder="itemQuantity"/>
            <button type="submit">Add to cart</button>
        </form>
    </div>
    
</body>
</html>
<style>
    
    .topnav {
      overflow: hidden;
      background-color: #333;
      margin-bottom:2%;
    }
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
        color:#232F3E;
        font-size:20px;
        padding:1%;
        border-radius:10px;
        border:none;
        outline:none;
    }
    .productImage{
        width:90%;
        margin:2%;
        border-radius:5px;
    }
    .largeProdName{
        font-size:24px;
    }
    .largeProdDesc{
        font-size:20px;
        color:rgb(80, 74, 74);
    }
    .largeProdPrice{
        font-size:36px;
        color:brown;
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