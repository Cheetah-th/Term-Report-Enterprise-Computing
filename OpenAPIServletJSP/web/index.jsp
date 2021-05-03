<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<html>
<head>
    <title></title>
</head>

<body>
    <h3> ข้อมูลการใช้และการเข้าถึงอินเทอร์เน็ต </h3>

    <form action="OpenAPI" method="post">

    <h4> Choose API: </h4>
         <input type=radio name="status" value="1">อัตราการเข้าถึงของบริการอินเทอร์เน็ตความเร็วสูงต่อจำนวนครัวเรือน <br><br>
         <input type=radio name="status" value="2">จำนวนผู้ลงทะเบียนใช้บริการอินเทอร์เน็ตความเร็วสูง <p>

       &nbsp &nbsp <input type=submit value="Submit">
     </form>
</body>
</html>

    