// Usage:
//
// var myConverter = new Markdown.Converter(myEditor, null, { strings: Markdown.local.fr });

(function () {
        Markdown.local = Markdown.local || {};
        Markdown.local.zh = {
        bold: "保存 Ctrl+S",

        bold: "加粗 <strong> Ctrl+B",
        boldexample: "texte en gras",

        italic: "斜体 <em> Ctrl+I",
        italicexample: "texte en italique",

        link: "文字链接 <a> Ctrl+L",
        linkdescription: "连接",
        linkdialog: "<p><b>插入链接</b></p><p>http://example.com/ \"链接提醒\"</p>",

        quote: "引用 <blockquote> Ctrl+Q",
        quoteexample: "Citation",

        code: "插入代码<pre><code> Ctrl+K",
        codeexample: "代码位置",

        image: "插入图片 <img> Ctrl+G",
        imagedescription: "description de l'image",
        imagedialog: "<p><b>插入图片</b></p><p>http://example.com/images/diagram.jpg \"图片描述\"</p>",

        olist: "插入有序列表<ol> Ctrl+O",
        ulist: "插入无序列表<ul> Ctrl+U",
        litem: "列表",

        heading: "插入标题 <h1>/<h2> Ctrl+H",
        headingexample: "标题",

        hr: "插入分割线<hr> Ctrl+R",

        undo: "撤销 - Ctrl+Z",
        redo: "恢复 - Ctrl+Y",
        redomac: "Refaire - Ctrl+Shift+Z",

        help: "关于Markdown"
    };
})();