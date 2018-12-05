define(function(require) {
	var $ = require("jquery");
	return function(c) {
		alert('moduleA加载成功，参数：' + $.param(c));
	}
});