package Model;

import javax.swing.JButton;

import View.ViewEntrar;
import View.ViewMenuAdministrador;
import View.ViewMenuFuncionario;

//import View.ViewMenuAdministrador;
//import View.ViewMenuFuncionario;

public class ModelMenu {

	public static JButton funcionarioButton;

	public ModelMenu(){
		
		if (funcionarioButton != null) {
			new ViewMenuFuncionario();
			
		}else {
			new ViewMenuAdministrador();
		}
	     new ViewEntrar().dispose();
	}
  }


