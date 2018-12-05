KindEditor.plugin('save', function(K) {
	var editor = this, name = 'save';
	// 点击图标时执行
	editor.clickToolbar(name, function() {
		save();
	});
});