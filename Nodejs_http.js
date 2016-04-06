var api = {};

api.get = function(input, req, res) {
		//basic mode with server demo image
    require('http').get( {
  		host: 'darkdusk.org',
  		path: encodeURI('/vroom/api/viewer.php?key=/*YOUR API KEY*/&img=/*YOUR IMG PATH*/'),
    }, function(response) {
        var str = '';
        response.on('data', function (chunk) {
            str += chunk;
        });
        response.on('end', function () {
            res.send(str);
        });
    });
    
		//AR mode, please use mobile device testing
    require('http').get( {
  		host: 'darkdusk.org',
  		path: encodeURI('/vroom/api/viewer.php?key=/*YOUR API KEY*/&img=/*YOUR IMG PATH*/&mo=AR'),
    }, function(response) {
        var str = '';
        response.on('data', function (chunk) {
            str += chunk;
        });
        response.on('end', function () {
            res.send(str);
        });
    });
    
		//VR mode, please use mobile device testing
		//You can use full path to load image, but make sure it fit "Cross-Origin Resource Sharing policy"
    require('http').get( {
  		host: 'darkdusk.org',
  		path: encodeURI('/vroom/api/viewer.php?key=/*YOUR API KEY*/&img=/*YOUR IMG PATH*/&mo=VR'),
    }, function(response) {
        var str = '';
        response.on('data', function (chunk) {
            str += chunk;
        });
        response.on('end', function () {
            res.send(str);
        });
    });
};

module.exports = api;
