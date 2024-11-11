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
  
  
  <title>submitted</title>
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
  
  <section data-bs-version="5.1" class="menu menu1 cid-tD7N05kG5f" once="menu" id="menu1-1r">
    

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
                    <li class="nav-item"><a class="nav-link link text-black text-primary display-4" href="approved.php">Requested</a></li>
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

<section data-bs-version="5.1" style="height: 100vh;" class="form5 cid-tD7NGIQrZK" id="form5-1u">
    
    
    <div class="container">
        <div class="mbr-section-head">
            <h3 class="mbr-section-title mbr-fonts-style align-center mb-0 display-2">
                <strong>Submitted</strong></h3>
            
        </div>
        <div class="row justify-content-center mt-4">
            <div class="col-lg-8 mx-auto mbr-form" data-form-type="formoid">
                <form  method="POST" class="mbr-form form-with-styler" data-form-title="Form Name"><input type="hidden" name="email" data-form-email="true" value="20Q2sBLddQpVSoLUT4O4dlFVE2cI72GFtaVIVF0y6FVEUlw3Qis6U6TUjyGbHt8QGfMcqjQSXhs7DxiayYyKGutbQZHS0yH3iNU8MrjwoINKx9Zc3W4CE70H4aWK1XnF">
                    <div class="row vw-100">
                        <div hidden="hidden" data-form-alert="" class="alert alert-success col-12">Thanks for filling out the form!</div>
                        <div hidden="hidden" data-form-alert-danger="" class="alert alert-danger col-12">
                            Oops...! some problem!
                        </div>
                    </div>
                    
                    <div class="col-md col-sm-12 form-group mb-3" data-for="name">
                        <div id="hide">
 
        
  <table class="table table-dark table-hover ">
            
                <thead class="table-light">
                    <caption></caption>
                    <tr>
                    <th>Roll no</th>
                <th>Name</th>
               
                <th>Year</th>
                <th>Phone Number</th>
                <th>Address</th>
                <th>Mobile Name</th>
                <th>Color</th>
                <th>Model</th>
                <th>Price</th>
                <th>IMEI</th>
                <th>Date</th>
                    </tr>
                    </thead>
                    <tbody class="table-group-divider">
        </div>
        
<?php
$conn = mysqli_connect("localhost", "root", "", "login");       
    if(!$conn) {
        echo "Connection faild!!";
    } 
   
            
    $sql="select rollno,name,mail,year,phone,color,address,mname,model,price,imei,date1 from info where status='submitted' order by year asc";
            $result=mysqli_query($conn, $sql);
if (mysqli_num_rows($result) > 0) {
   
    while($data = mysqli_fetch_assoc($result)) {
        ?>
          <tr class="table-primary">
                            
                            <td scope="row"><?php echo $data['rollno'] ?></td>
                            <td><?php echo $data['name'] ?></td>
                    
                            <td><?php echo $data['year'] ?></td>
                            <td><?php echo $data['phone'] ?></td>
                            <td><?php echo $data['address'] ?></td>
                            <td><?php echo $data['mname'] ?></td>
                            <td><?php echo $data['color'] ?></td>
                            <td><?php echo $data['model'] ?></td>
                            <td><?php echo $data['price'] ?></td>
                            <td><?php echo $data['imei'] ?></td>
                            <td><?php echo $data['date1']?></td>

                        </tr>
                    </tbody>
                    <tfoot>
                        
                    </tfoot>
      


        <?php
    }
}
else
{
    echo "No details to show";
}
mysqli_close($conn);
 ?>
    </table>


         <center><button onclick="printpage()" id="btn" class="btn btn-primary"> Print</button>
	</center>

	<script type="text/javascript">
		
		function printpage()
		{
			var pb=document.getElementById('btn');
      
			pb.style.visibility='hidden';
  
			window.print()
			pb.style.visibility='visible';
		}
        </script>
    </body>
    </html>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<section data-bs-version="5.1" class="footer7 cid-tDxDUiGNJM" once="footers" id="footer7-3a">

    

    

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