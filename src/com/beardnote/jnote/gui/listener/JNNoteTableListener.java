package com.beardnote.jnote.gui.listener;

import java.util.List;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.beardnote.jnote.bean.Note;
import com.beardnote.jnote.dao.NoteDao;
import com.beardnote.jnote.gui.JNNoteEditorPanel;
import com.beardnote.jnote.gui.common.JNConstans;
import com.beardnote.jnote.gui.core.CloseTabPanel;
import com.beardnote.jnote.gui.model.JNNoteTableModel;
import com.beardnote.jnote.gui.util.ComponentUtil;

public class JNNoteTableListener implements ListSelectionListener {
	private static JNNoteTableModel noteTableModel;
	private static JTable notetable;

	public JNNoteTableListener() {
		noteTableModel = (JNNoteTableModel) ComponentUtil
				.getComponent("noteTableModel");
		notetable = (JTable) ComponentUtil.getComponent("notetable");
	}

	public void getNoteTable() {
		int categoryId = JNConstans.CUR_SELECT_CATEGORY_ID;
		List<Note> noteList = NoteDao.getNotesByCategoryId(categoryId);
		noteTableModel.removeRows(0, noteTableModel.getRowCount());
		noteTableModel.addRows(noteList);
		notetable.updateUI();
		notetable.setRowHeight(50);
		notetable.clearSelection();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			Note note = noteTableModel.getNote(notetable.getSelectedRow());
			if (note == null)
				return;
			String title = note.getTitle();
			String content = note.getContent();

			JTabbedPane tabbedPane = (JTabbedPane) ComponentUtil
					.getComponent("tabbedPane");
			JNConstans.CUR_SELECT_UUID = note.getUuid();
			int index = JNTabListener.isOpenTab(note.getUuid());
			if (index < 0) {
				CloseTabPanel closeTabPanel = new CloseTabPanel(title,
						tabbedPane);
				tabbedPane.addTab(title, new JNNoteEditorPanel(note, JNConstans.EDITOR_TYPE_READ).getEditorPanel());
				int size = tabbedPane.getTabCount() - 1;
				tabbedPane.setSelectedIndex(size);
				tabbedPane.setTabComponentAt(size, closeTabPanel);
				JNConstans.CUR_SELECT_TAB_INDEX = size;
				JNTabListener.addTab(note.getUuid());
			} else {
				tabbedPane.setSelectedIndex(index);
				JNConstans.CUR_SELECT_TAB_INDEX = index;
			}

		}

	}

	public void getSearchNoteTable() {
		// TODO Auto-generated method stub
		
	}

}
