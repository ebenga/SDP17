var express = require('express');
var app = express();
app.set('port', 3000);
app.use(express.static('public'));
app.listen(app.get('port'), function() {
	console.log("Server running on http://localhost:3000");
});
