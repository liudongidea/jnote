package com.beardnote.jnote.gui;

import java.awt.Event;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.beardnote.jnote.gui.listener.JNDelBtnActionListener;
import com.beardnote.jnote.gui.listener.JNNewBtnActionListener;
import com.beardnote.jnote.gui.listener.JNNewDayNoteBtnActionListener;
import com.beardnote.jnote.gui.listener.JNTodoBtnActionListener;

/**
 * 工具栏
 * 
 * @author Administrator
 * 
 */
public class JNToolBar {
	private JToolBar toolbar = null;

	public JNToolBar() {
		toolbar = new JToolBar();
		toolbar.setFloatable(false);

		JButton newNoteBtn = new JButton("新建笔记");
		newNoteBtn.registerKeyboardAction(new JNNewBtnActionListener(),
				KeyStroke.getKeyStroke('N', Event.CTRL_MASK),
				JComponent.WHEN_IN_FOCUSED_WINDOW);
		newNoteBtn.addActionListener(new JNNewBtnActionListener());

		JButton newDayNoteBtn = new JButton("新建日记");
		newDayNoteBtn.addActionListener(new JNNewDayNoteBtnActionListener());

		JButton deleteNoteBtn = new JButton(" 删除 ");
		deleteNoteBtn.addActionListener(new JNDelBtnActionListener());

		JButton todoBtn = new JButton(" TODO ");
		todoBtn.addActionListener(new JNTodoBtnActionListener());

		JButton optionBtn = new JButton(" 选项 ");
		optionBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UIManager.put("RootPane.setupButtonVisible", false);
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						JNOptionPanel OptionFrame = new JNOptionPanel(
								GraphicsEnvironment
										.getLocalGraphicsEnvironment()
										.getDefaultScreenDevice()
										.getDefaultConfiguration());
					}
				});

			}
		});
		
		JButton aboutBtn = new JButton(" 关于 ");
		aboutBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UIManager.put("RootPane.setupButtonVisible", false);
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						JNAboutPanel aboutFrame = new JNAboutPanel(
								GraphicsEnvironment
										.getLocalGraphicsEnvironment()
										.getDefaultScreenDevice()
										.getDefaultConfiguration());
					}
				});

			}
		});
		
		
		toolbar.add(new JLabel("  "));
		toolbar.add(newDayNoteBtn);
		toolbar.add(new JLabel("  "));
		toolbar.add(newNoteBtn);
		toolbar.add(new JLabel("  "));
		toolbar.add(deleteNoteBtn);
		toolbar.add(new JLabel("  "));
		toolbar.add(todoBtn);
		toolbar.add(new JLabel("  "));
		toolbar.add(optionBtn);
		toolbar.add(new JLabel("  "));
		toolbar.add(aboutBtn);
	}

	public JToolBar getToolbar() {
		return toolbar;
	}

}
