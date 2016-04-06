<?php
	//basic mode with server demo image
	$curl_init = curl_init("https://darkdusk.org/vroom/api/viewer.php?key=$YOUR_API_KEY&img=4.jpg");
	curl_setopt($curl_init, CURLOPT_RETURNTRANSFER, true);
	echo curl_exec($curl_init)//html
	
	//AR mode, please use mobile device testing
	$curl_init = curl_init("https://darkdusk.org/vroom/api/viewer.php?key=$YOUR_API_KEY&mo=AR&img=4.jpg");
	curl_setopt($curl_init, CURLOPT_RETURNTRANSFER, true);
	echo curl_exec($curl_init)//html
	
	//VR mode, please use mobile device testing
	//You can use full path to load image, but make sure it fit "Cross-Origin Resource Sharing policy"
	$curl_init = curl_init("https://darkdusk.org/vroom/api/viewer.php?key=$YOUR_API_KEY&mo=VR&img=https://community.htc.com/tw/data/attachment/forum/201411/24/190922byyqrytlmrwufqky.jpg");
	curl_setopt($curl_init, CURLOPT_RETURNTRANSFER, true);
	echo curl_exec($curl_init)//html
?>
