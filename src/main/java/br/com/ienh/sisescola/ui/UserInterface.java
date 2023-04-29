package br.com.ienh.sisescola.ui;

import br.com.ienh.sisescola.ui.menus.MenuMain;

public class UserInterface {

	public static void run() {
		
		String[] logo = {
				"",
				"       / \\__",
	            "     (       @\\___",
	            "     /             O",
	            "    /       (_____/",
	            "   /_____ /   U",
	            "",   
	            "       SISESCOLA",
	            "",
	            "     Seja bem-vindo!",
	            ""
		};

        for (String linha : logo)
            System.out.println(linha);
        
        new MenuMain().executar();
		
	}
	
}
