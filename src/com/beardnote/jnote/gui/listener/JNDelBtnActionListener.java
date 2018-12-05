package com.beardnote.jnote.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTabbedPane;

import com.beardnote.jnote.dao.NoteDao;
import com.beardnote.jnote.gui.common.JNConstans;
import com.beardnote.jnote.gui.util.ComponentUtil;

/**
 * 删除当前选择的笔记
 * 
 * @author Administrator
 * 
 */
public class JNDelBtnActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		String uuid = JNConstans.CUR_SELECT_UUID;
		int index = JNConstans.CUR_SELECT_TAB_INDEX;
		if (uuid == null || index == -1) {
			return;
		}

		new NoteDao().deleteNoteByUuid(uuid);

		JTabbedPane tabbedPane = (JTabbedPane) ComponentUtil.getComponent("tabbedPane");
		tabbedPane.remove(index);
		JNTabListener.removeTab(index);
		new JNNoteTableListener().getNoteTable();

		if (index > 0) {
			tabbedPane.setSelectedIndex(index - 1);
		}
		JNConstans.CUR_SELECT_UUID = null;
	}

}
