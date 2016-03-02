var express = require('express');
var path = require('path');
var fs = require('fs-extra');
var app = express();

app.get('/:classname', function (req, res) {
	changeFilenames();	
	res.sendFile(path.join(__dirname, 'resources/classes/' + req.params.classname + '.class'));
});

app.get('/', function (req, res) {
	res.send('Add /classname in http request for getting .class file');
});

function changeFilenames(){
	fs.copySync(path.resolve(__dirname,'./resources/classes/MyImpl.class'), path.resolve(__dirname,'./resources/classes/MyImpl.copy'));
	fs.copySync(path.resolve(__dirname,'./resources/classes/MyImpl2.class'), path.resolve(__dirname,'./resources/classes/MyImpl.class'));
	fs.copySync(path.resolve(__dirname,'./resources/classes/MyImpl.copy'), path.resolve(__dirname,'./resources/classes/MyImpl2.class'));
}

app.listen(3000, function () {
	console.log('REST app listening on port 3000!');
});