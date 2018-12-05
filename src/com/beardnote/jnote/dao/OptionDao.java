package com.beardnote.jnote.dao;

import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;

import com.beardnote.jnote.bean.Option;
import com.beardnote.jnote.common.DBFactory;
import com.beardnote.jnote.gui.common.JNConstans;

public class OptionDao {
	static Dao dao = new NutDao(DBFactory.getDataSource());

	/**
	 * 由Nutz创建表
	 */
	public static void create() {
		dao.create(Option.class, true);
		Option o = new Option();
		o.setEditorType(JNConstans.EDITORY_MARKDOWN);
		dao.insert(o);
	}

	public static Option get() {
		Option option = dao.fetch(Option.class);
		return option;
	}

	public static void save() {
		dao.insert(new Option());
	}

	public static void update(int editorType) {
		Option o = new Option();
		o.setId(1);
		o.setEditorType(editorType);
		dao.update(o);
	}

	public static void main(String[] args) {
		OptionDao d = new OptionDao();
		d.create();
		// d.save();
		// d.update("html");
	}
}
