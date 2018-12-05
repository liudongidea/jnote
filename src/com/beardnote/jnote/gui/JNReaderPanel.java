package com.beardnote.jnote.gui;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;

import jodd.io.FileUtil;
import jodd.util.StringUtil;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

import com.beardnote.jnote.bean.Note;

/**
 * 阅读日志面板
 * 
 * @author zhaopeng
 * 
 */
public class JNReaderPanel {

	/**
	 * html阅读器组件
	 * 
	 * @param note
	 * @return
	 */
	public static JComponent getReader(Note note) {

		final JWebBrowser webBrowser = new JWebBrowser();
		webBrowser.setName("webReader");
		webBrowser.setBarsVisible(false);
		webBrowser.setStatusBarVisible(false);
		webBrowser.setBorder(BorderFactory.createEmptyBorder());
		try {
			String path = String.class.getResource("/display/memento")
					.getPath();
			path = path.substring(1);
			String readerPath = path + "/index.html";
			String reader = FileUtil.readString(readerPath);
			reader = StringUtil.replace(reader, "{{path}}", path);
			reader = StringUtil.replace(reader, "{{title}}", note.getTitle());
			reader = StringUtil.replace(reader, "{{content}}",
					note.getContent());
			webBrowser.setHTMLContent(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return webBrowser;
	}

}
