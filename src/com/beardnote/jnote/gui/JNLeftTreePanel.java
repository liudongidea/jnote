package com.beardnote.jnote.gui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.TreeSelectionModel;

import com.beardnote.jnote.bean.Category;
import com.beardnote.jnote.dao.CategoryDao;
import com.beardnote.jnote.gui.core.tree.JNTree;
import com.beardnote.jnote.gui.listener.JNCategoryTreeListener;
import com.beardnote.jnote.gui.util.ComponentUtil;

/**
 * 左侧树形菜单
 * 
 * @author Administrator
 * 
 */
public class JNLeftTreePanel {
	private JPanel leftTreePanel;

	public JNLeftTreePanel() {
		leftTreePanel = new JPanel();
		leftTreePanel.setBorder(BorderFactory.createEmptyBorder());
		leftTreePanel.setLayout(new BorderLayout());
		JComponent categoryTree = createTree();
		leftTreePanel.add(categoryTree, BorderLayout.CENTER);
	}

	public JPanel getLeftTreePanel() {
		return leftTreePanel;
	}

	public JComponent createTree() {
		List<Category> categories = new CategoryDao().getAllCategory();

		JNTree jntree = new JNTree(categories);
		JTree jtree = jntree.getJtree();
		jtree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

		ComponentUtil.setComponent("categoryTree", jtree);
		jtree.addTreeSelectionListener(new JNCategoryTreeListener());
		JScrollPane js = new JScrollPane(jtree);
		js.setBorder(BorderFactory.createEmptyBorder());
		return js;
	}
}
