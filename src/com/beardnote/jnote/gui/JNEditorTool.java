package com.beardnote.jnote.gui;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.beardnote.jnote.bean.Note;
import com.beardnote.jnote.gui.listener.JNEditorBtnActionListener;

/**
 * 编辑器工具栏,包含标题和工具按钮
 * 
 * @author zhaopeng
 * 
 */
public class JNEditorTool {

	private JPanel editorToolPanel;
	private JPanel notePanel;
	private Note note;
	private JTextField titleTextField;

	public JNEditorTool(Note note, JPanel notePanel) {
		this.notePanel = notePanel;
		this.note = note;
		editorToolPanel = new JPanel(new BorderLayout());
		this.titleTextField = new JTextField();
		titleTextField.setName("title");
		titleTextField.setOpaque(false);// 设置文本框背景透明
		titleTextField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		titleTextField.setColumns(45);
		titleTextField.setSize(45, 20);
		titleTextField.setText(note.getTitle());
		editorToolPanel.add(titleTextField, BorderLayout.WEST);
	}

	/**
	 * 编辑器工具栏
	 * 
	 * @return
	 */

	public JPanel getEditorToolPanel() {
		return editorToolPanel;
	}

	public JTextField getTitleTextField() {
		return titleTextField;
	}

}
