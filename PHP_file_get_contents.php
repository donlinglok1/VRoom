<?php
	//basic mode with server demo image
	echo file_get_contents("https://darkdusk.org/vroom/api/viewer.php?key=$YOUR_API_KEY&img=$YOUR_IMG_PATH");
	
	//AR mode, please use mobile device testing
	echo file_get_contents("https://darkdusk.org/vroom/api/viewer.php?key=$YOUR_API_KEY&img=$YOUR_IMG_PATH&mo=AR");
	
	//VR mode, please use mobile device testing
	//You can use full path to load image, but make sure it fit "Cross-Origin Resource Sharing policy"
	echo file_get_contents("https://darkdusk.org/vroom/api/viewer.php?key=$YOUR_API_KEY&img=$YOUR_IMG_PATH&mo=VR");
?>
