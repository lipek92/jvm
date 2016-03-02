var express = require('express');
var app = express();
var path = require('path');

app.get('/:classname', function (req, res) {
  res.sendFile(path.join(__dirname, 'resources/classes/' + req.params.classname + '.class'));
});

app.get('/', function (req, res) {
  res.send('Dostępne klasy na serwerze:');
});

app.listen(3000, function () {
  console.log('REST app listening on port 3000!');
});