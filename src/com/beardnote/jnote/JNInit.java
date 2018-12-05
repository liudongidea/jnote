package com.beardnote.jnote;

import com.beardnote.jnote.dao.CategoryDao;
import com.beardnote.jnote.dao.NoteDao;
import com.beardnote.jnote.dao.OptionDao;

public class JNInit {
	public static void main(String[] args) {
		OptionDao ddao = new OptionDao();
		ddao.create();
		
		NoteDao ndao = new NoteDao();
		ndao.create();
		
		CategoryDao cdao = new CategoryDao();
		cdao.create();
	}
}
