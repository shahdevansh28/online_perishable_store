<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>customer confirmation page</title>
</head>
<body>
    <center>
        <div style="padding:5%;background-color: #232F3E;color:#FF9900;font-size:20px;">
            <h1>Confirmation page</h1>
            <p style="font-size:20px;color:white;">Confirmation msg : ${confirmation_msg}</p>
            <button style="background-color:#FF9900;border:none;border-radius:5px;padding:10px;"><a style="font-size:20px;color:black;" href="${go_back_url}">go back</a></button>
        </div>      
    </center>
    
</body>
</html>
<style>
    a,

a:visited { color: #93291b; text-decoration: none; }


a:hover { text-decoration: underline }


h1 { font-family: 'Enriqueta', arial, serif; line-height: 1.25; margin: 0 0 10px; font-size: 40px; font-weight: bold; }

h1 a,

h1 a:visited { color: #333333 }


h1 a:hover { color: #93291b; text-decoration: none; }


p { color: #333333; font-family: "Helvetica Neue",Arial,sans-serif; font-size: 16px; font-weight: 300; line-height: 1.5625; margin-bottom: 15px; }


a.read-more { background-color: #93291b; border: 1px solid #333333; border-radius: 3px 3px 3px 3px; box-shadow: 0 0 1px #93291b inset; color: #f5f5f5; padding: 5px; }


a.read-more:hover { background-color: #be3523; border-radius: 3px 3px 3px 3px; text-decoration: none; }
</style>