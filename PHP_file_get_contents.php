<?php
	//basic mode with server demo image
	echo file_get_contents("https://darkdusk.org/vroom/api/viewer.php?key=$YOUR_API_KEY&img=4.jpg");
	
	//AR mode, please use mobile device testing
	echo file_get_contents("https://darkdusk.org/vroom/api/viewer.php?key=$YOUR_API_KEY&mo=AR&img=4.jpg");
	
	//VR mode, please use mobile device testing
	//You can use full path to load image, but make sure it fit "Cross-Origin Resource Sharing policy"
	echo file_get_contents("https://darkdusk.org/vroom/api/viewer.php?key=$YOUR_API_KEY&mo=VR&img=https://community.htc.com/tw/data/attachment/forum/201411/24/190922byyqrytlmrwufqky.jpg");
?>
