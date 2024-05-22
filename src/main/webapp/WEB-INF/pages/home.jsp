<html>
<head>
<script src="js/vsScript.js"></script>
<!-- <script src="js/jquery-latest.js"></script>
<script src="js/common.js"></script> -->

</head>
<body>

	<h1>Visual Cryptography - Demo</h1>

	<!-- <form method="POST" action="/upload" enctype="multipart/form-data">
		<input type="file" name="file" /><br />
		<br /> <input type="submit" value="Submit" />
	</form> -->
	
	<div>
	<form class="form-container" enctype='multipart/form-data'	id="imageUploadfrm" name="imageUploadfrm">
            <div>
            <!-- <span><img src="images/upload.png" border="0" alt=""></span>  -->
            <span>Browse file</span> 	
              <input class="file-input" type="file" id="file" name="file" value="Browse File" accept=".png" onchange="showImage(event)">
            </div>
            <div> 
	            <span></span>
	             <div></div>
            </div>
            <div style="margin-top: 10px;">
	            <button type="button" onClick="uploadAndEncryptImg()"> Upload And Encrypt</button>
	            <button type="button" onClick="decryptImage()"> Decrypt </button>
            </div>
            <div>
				<div>
					<div id="errorDiv" name="errorDiv" style="color: red; text-align: center"></div>
				</div>
			</div>

			<div class="row">
				<div>
					<div id="result" name="result" style="color: red; text-align: center;">
						<img id="originalImg" style="display:none;" name="originalImg" alt="original image" width="200" height="100" />
					</div>
				</div>
				<div style="margin-top: 10px; display: flex; flex-wrap: wrap;" id="encryptImagesDisplay"></div>
				<div style="margin-top: 10px;" id="outputImagesDisplay"></div>
			 </div>
		</form>
	</div>
<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
</body>
</html>