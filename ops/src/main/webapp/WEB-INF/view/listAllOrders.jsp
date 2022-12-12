<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>listAllOrders</title>
</head>
<body>
    <div class="topnav" id="myTopnav">
        <a href="customerHome" >Home</a>
        <a href="seeMyCart?userId=${user.userid}">Cart</a>
        <a href="seeMyOrders?userId=${user.userid}">Orders</a>
        <a href="login">Logout</a>
        <a href="javascript:void(0);" class="icon" onclick="myFunction()">
            <i class="fa fa-bars"></i>
        </a>
    </div>
    <table>
        <th>orderid</th><th>total-amount</th><th>date</th><th>view order</th>
        <c:forEach var = "order" items="${orders}">
            <tr>
                <td>${order.orderid}</td>
                <td><span class="largeProductPrice">${order.totalAmount}</span>.00 Rs.</td>
                <td>${order.orderDate}</td>
                <td>
                    <form action="viewOrder" method="GET">
                        <input type="hidden" name="orderId" value="${order.orderid}" />
                        <button>view</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

<style>
    table {
        border-collapse: collapse;
        width: 100%;
    }

    th, td {
        text-align: left;
        padding: 8px;
        }

    tr:hover{
        background-color: #232F3E;
        color:#FF9900;
    }
    .placeOrderForm{
        margin-left:2%;
        float:left;
    }
    .placeBtn{
        color:black;
        background-color:#FF9900;
        font-size:24px;
        padding:5px;
    }
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
      .largeProductPrice{
          font-size:36px;
          color:rgb(236, 19, 19);
      }
      .largeProductPrice:hover{
          color:rgb(255, 37, 37);
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
        width:50%;
        cursor:pointer;
        background-color: #FF9900;
        color:#232F3E;
        font-size:20px;
        border:none;
        outline:none;
        border-radius:10px;
        padding:5px;
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