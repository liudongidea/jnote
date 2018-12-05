define(function(require) {
	var $ = require("jquery");
	return function(c) {
		 alert('moduleB加载成功，参数：' +c);
	}
});