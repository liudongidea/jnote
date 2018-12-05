KindEditor.plugin('jnpaste', function(K) {
	var editor = this, name = 'jnpaste';
	// 点击图标时执行
	editor.clickToolbar(name, function() {
		save();
	});
});