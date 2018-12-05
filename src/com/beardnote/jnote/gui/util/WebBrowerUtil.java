package com.beardnote.jnote.gui.util;

import javax.swing.JTextField;

import jodd.io.FileUtil;
import jodd.util.StringUtil;
import jodd.util.SystemUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

import com.beardnote.jnote.bean.Note;
import com.beardnote.jnote.dao.NoteDao;
import com.beardnote.jnote.gui.JNAttachmentPanel;

public class WebBrowerUtil {
	private static final Logger log = LoggerFactory
			.getLogger(WebBrowerUtil.class);

	public static JWebBrowser setNoteReadPanel(JWebBrowser webBrowser,
			Note note, JNAttachmentPanel attachment, JTextField titleTextField) {
		try {
			webBrowser.executeJavascript("save()");

			note = NoteDao.getNoteByUuid(note.getUuid());
			String path = SystemUtil.getWorkingFolder() + ("/display/lofter");
			String readerPath = path + "/index.html";
			String reader = FileUtil.readString(readerPath);

			String content = note.getContent();
			String workFolder = SystemUtil.getWorkingFolder();
			workFolder = StringUtil.replace(workFolder, "\\", "/") + "/data/";
			content = StringUtil.replace(content, "../../../data/", workFolder);
			reader = StringUtil.replace(reader, "{{path}}", path);
			reader = StringUtil.replace(reader, "{{title}}", note.getTitle());
			reader = StringUtil.replace(reader, "{{content}}", content);
			webBrowser.setHTMLContent(reader);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return webBrowser;
	}

	public static JWebBrowser setNoteWritePanel(JWebBrowser webBrowser,
			Note note, JNAttachmentPanel attachment, JTextField titleTextField) {
		try {
			String pagedownPath = SystemUtil.getWorkingFolder()
					+ "/resources/kindeditor";
			webBrowser.navigate(pagedownPath + "/index.html");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return webBrowser;
	}

}
