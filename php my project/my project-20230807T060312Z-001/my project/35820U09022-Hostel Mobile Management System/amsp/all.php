<?php
session_start();
$uname=$_SESSION['username'];
?>
<!DOCTYPE html>
<html  >
<head>
  <!-- Site made with Mobirise Website Builder v5.8.9, https://mobirise.com -->
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="generator" content="Mobirise v5.8.9, mobirise.com">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1">
  <link rel="shortcut icon" href="assets/images/logo.png" type="image/x-icon">
  <meta name="description" content="">
  
  
  <title>Add</title>
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-grid.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-reboot.min.css">
  <link rel="stylesheet" href="assets/dropdown/css/style.css">
  <link rel="stylesheet" href="assets/socicon/css/styles.css">
  <link rel="stylesheet" href="assets/theme/css/style.css">
  <link rel="preload" href="https://fonts.googleapis.com/css?family=Jost:100,200,300,400,500,600,700,800,900,100i,200i,300i,400i,500i,600i,700i,800i,900i&display=swap" as="style" onload="this.onload=null;this.rel='stylesheet'">
  <noscript><link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Jost:100,200,300,400,500,600,700,800,900,100i,200i,300i,400i,500i,600i,700i,800i,900i&display=swap"></noscript>
  <link rel="preload" as="style" href="assets/mobirise/css/mbr-additional.css"><link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css" type="text/css">

  
    
  <style>
      @import url('https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,400;0,500;0,700;1,300&display=swap');
      *{
        font-family: 'Poppins', sans-serif;
      }  
      </style> 
  
</head>
<body>
  
  <section data-bs-version="5.1" class="menu menu1 cid-tDanUc8mBK" once="menu" id="menu1-2a">
    

    <nav class="navbar navbar-dropdown navbar-fixed-top navbar-expand-lg">
        <div class="container-fluid">
        <div class="navbar-brand">
               
               <span class="navbar-caption-wrap"><a class="navbar-caption text-black display-7"><?php echo $uname ?></a></span>
           </div>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-bs-toggle="collapse" data-target="#navbarSupportedContent" data-bs-target="#navbarSupportedContent" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <div class="hamburger">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                </div>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav nav-dropdown nav-right" data-app-modern-menu="true">
                <li class="nav-item"><a class="nav-link link text-black text-primary display-4" href="admin.php">Home</a></li>
                <li class="nav-item"><a class="nav-link link text-black text-primary display-4" href="post.php">Post</a></li>
                    <li class="nav-item"><a class="nav-link link text-black text-primary display-4" href="add.php">Add</a></li>
                    <li class="nav-item"><a class="nav-link link text-black text-primary display-4" href="receive.php">Requested</a></li>
                    <li class="nav-item"><a class="nav-link link text-black text-primary display-4" href="approved.php">Approved</a></li>
                    <li class="nav-item"><a class="nav-link link text-black text-primary display-4" href="attendance.php">Attendance</a>
                    </li><li class="nav-item"><a class="nav-link link text-black text-primary display-4" href="all.php">All</a></li>
                    <li class="nav-item"><a class="nav-link link text-black text-primary display-4" href="sub.php">Submitted</a></li>
                    <li class="nav-item"><a class="nav-link link text-black text-primary display-4" href="nsub.php">Not-submitted</a></li>

                     <li class="nav-item"><a class="nav-link link text-black text-primary display-4" href="delete.php">Delete</a></li>
                        <li class="nav-item"><a class="nav-link link text-black display-4" href="index.php">Logout</a></li></ul>
                           <div class="icons-menu">
                            <a class="iconfont-wrapper" href="https://www.facebook.com/login/" target="_blank">
                        <span class="p-2 mbr-iconfont socicon-facebook socicon"></span>
                    </a>
                    <a class="iconfont-wrapper" href="https://twitter.com/i/flow/login" target="_blank">
                        <span class="p-2 mbr-iconfont socicon-twitter socicon"></span>
                    </a>
                    <a class="iconfont-wrapper" href="https://www.instagram.com/" target="_blank">
                        <span class="p-2 mbr-iconfont socicon-instagram socicon"></span>
                    </a>
                    
                </div>
                
            </div>
        </div>
    </nav>
</section>

<section data-bs-version="5.1" class="form5 cid-tD7ziM5ucR" id="form5-w">
    
    
    <div class="container">
        <div class="mbr-section-head">
            <h3 class="mbr-section-title mbr-fonts-style align-center mb-0 display-2"><strong>All Details</strong></h3>
            
        </div>
        <div class="row justify-content-center mt-4">
            <div class="col-lg-8 mx-auto mbr-form" data-form-type="formoid">
                <form  method="POST" class="mbr-form form-with-styler" data-form-title="Form Name"><input type="hidden" name="email" data-form-email="true" value="cJTwJKYYmsUtEmMWyGKD3wGRgBEOw7XFlfMrv+a/WSzbez5i+MuApKIEi+20hPhLW5pgvfDGAD5LxLLyHL9xi9KaQFos2nSCHdhbckz7FYD4Ht7AczWwpy0sl1zGEbfY">
                   <div align="left">
                    <div class="dragArea row">
                        <div class="col-md col-sm-12 form-group mb-3" data-for="name">
                        <div id="hide">
 
 <?php

 if(!$_SESSION['login']){
     header("Location: index.php",true);
     exit();
 }
 $result="";
 $mess="";
 $_SESSION['username'];
 $uname=$_SESSION['username'];
 

 $conn = mysqli_connect("localhost", "root", "", "login");
     if(!$conn) {
         echo "Connection faild!!";
     }
 $sql123="select post1 from post1";
 $result123=mysqli_query($conn,$sql123);
 $row=mysqli_fetch_assoc($result123);
 
 ?>
 </div>

<table align="left">
<div>



       <?php
       if($uname) {
         $sql1="select * from info";
         $result1=mysqli_query($conn,$sql1);
         $num1=mysqli_num_rows($result1);
         ?>
           <label>Registered students ||<div align="center"><?php echo " ".$num1 ?></div></label>
         <?php
    

         $sql2="select * from login";
         $result2=mysqli_query($conn,$sql2);
         $num2=mysqli_num_rows($result2);
         ?>
   <label>The total user||<div class="numberCircle" align="center"><?php echo $num2 ?></div></label>
        
         <?php
         

         $sql3="select * from info where status='submitted'";
         $result3=mysqli_query($conn,$sql3);
         $num3=mysqli_num_rows($result3);
         ?>
            <label>Pending to check||<div class="numberCircle" align="center"><?php echo $num3 ?></div></label>


         <?php
         $sql4="select * from info where status='verified'";
         $result4=mysqli_query($conn,$sql4);
         $num4=mysqli_num_rows($result4);

         ?>
         <label>Verified by Incharges||<div class="numberCircle" align="center"><?php echo $num4 ?></div></label>
         <?php
    

    $sql5="select * from info where year='1'";
    $result5=mysqli_query($conn,$sql5);
    $num5=mysqli_num_rows($result5);
    ?>
    <label>The total 1st years||<div class="numberCircle" align="center"><?php echo $num5 ?></div></label>
    <?php
    

         $sql6="select * from info where year='2'";
         $result6=mysqli_query($conn,$sql6);
         $num6=mysqli_num_rows($result6);
         ?>
  <label>The total 2nd years||<div class="numberCircle" align="center"><?php echo $num6 ?></div></label>
         <?php
    

         $sql7="select * from info where year='3'";
         $result7=mysqli_query($conn,$sql7);
         $num7=mysqli_num_rows($result7);
         ?>
         <label>The total 3rd years<div class="numberCircle" align="center"><?php echo $num7 ?></div></label>
        



       </div>
       <table class="table">
        <thead class="tead-dark">
<?php

           $sql="select rollno,name,name,mail,year,dpt,phone,color,address ,mname,model,price,imei,date1 from info";

           
           $result=mysqli_query($conn, $sql);
           if (mysqli_num_rows($result) > 0) {
               ?>
               <table class="table table-dark table-hover ">
            
            <thead class="table-light">
                <caption></caption>
                <tr>
                <th>Roll no</th>
            <th>Name</th>
            <th>Mail_Id</th>
            <th>Year</th>
            <th>Department</th>
            <th>Phone Number</th>
            
            <th>Mobile Name</th>
            <th>Color</th>
            <th>Model</th>
          <th>Price</th>
            <th>IMEI</th>
          
                </tr>
                </thead>
                <tbody class="table-group-divider">
    
    <?php
               while($data = mysqli_fetch_assoc($result)) {
                
    ?> <tr class="table-primary">
                            
    <td scope="row"><?php echo $data['rollno'] ?></td>
    <td><?php echo $data['name'] ?></td>
    <td><?php echo $data['mail'] ?></td>
    <td><?php echo $data['year'] ?></td>
    <td><?php echo $data['dpt'] ?></td>
    <td><?php echo $data['phone'] ?></td>

    <td><?php echo $data['mname'] ?></td>
    <td><?php echo $data['color'] ?></td>
    <td><?php echo $data['model'] ?></td>
   <td><?php echo $data['price'] ?></td>
    <td><?php echo $data['imei'] ?></td>

<?php
                 
                       
               }   
               echo "</table>"; 
                
               if(count($_POST)>0){
                   $sql2="update info set status='submitted' where rollno='$uname' ";
                   $re=mysqli_query($conn,$sql2);
                   if ($re === TRUE) {
                       $mess="Submitted successfully";
                     } else {
                       $mess="Error";
                     }
       
               }
               
           }
       }
?>
     
    </table>
   <script type="text/javascript">
       
       function printpage()
       {
           var pb=document.getElementById('btn');
     var pb1=document.getElementById('hide');
           pb.style.visibility='hidden';
     pb1.style.visibility='hidden';
           window.print()
           pb.style.visibility='visible';
       }
   </script>
                           
                           <div class="col-lg-12 col-md-12 col-sm-12 align-center mbr-section-btn"><button type="submit" onclick="printpage()" class="btn btn-primary display-4" id="btn">Print</button></div>
      </div>
     </center>
   
                        </div>
                        
                        
                   </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<section data-bs-version="5.1" class="footer7 cid-tDxGiVrvjL" once="footers" id="footer7-3h">

    

    

    <div class="container">
        <div class="media-container-row align-center mbr-white">
            <div class="col-12">
                <p class="mbr-text mb-0 mbr-fonts-style display-7">
                    © Copyright 2023 David Alex - All Rights Reserved
                </p>
            </div>
        </div>
    </div>
</section>
</body>
</html>