/**
 * @author Fredy Ramirez Guzman
 */
import java.awt.*; 
import java.awt.event.*;

import javax.swing.*;

public class VentanaEvaluador 
extends JFrame implements ActionListener{	
	private
	JLabel l1 = new JLabel("Expresion: ");
	JLabel l2 = new JLabel("Resultados: ");
	JTextField expre = new JTextField();	
	JTextArea resul = new JTextArea();
	JButton eva = new JButton("Evaluar");
	JButton limExp = new JButton("Limp. Exp.");
	JButton limRes = new JButton("Limp. Res.");
    JButton cod = new JButton("Hecer .ASM");
	ContextoExpresion expresion;
    AnalizadorGramatical gramatica;
	Codigo codigo;

	
    public VentanaEvaluador() { 
    	setTitle("Evaluador de Expresiones");
    	setResizable(false);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	getContentPane().setLayout(null);
    	    	
    	setBounds(300, 50, 420, 350);
    	
    	componentes();
    }
    
    private void componentes(){
    	l1.setBounds(10,20,70,20);    	
    	expre.setFont(new Font("dialog", Font.BOLD, 12));
    	expre.setBounds(90,20,300,20);
    	
    	l2.setBounds(220,50,80,20);    	
    	resul.setFont(new Font("dialog", Font.PLAIN, 14));
    	resul.setBackground(getContentPane().getBackground());
    	resul.setBounds(150,80,200,220);
    	eva.setBounds(15,80,100,25);
    	eva.addActionListener(this);
    	eva.setActionCommand("eva");
    	limExp.addActionListener(this);
    	limExp.setActionCommand("le");
    	limExp.setBounds(15,120,100,25);
    	limRes.addActionListener(this);
    	limRes.setActionCommand("lr");
    	limRes.setBounds(15,160,100,25);
        cod.addActionListener(this);
        cod.setActionCommand("cod");
        cod.setBounds(15,200,100,25);
    	
    	getContentPane().add(l1);
    	getContentPane().add(expre);
    	getContentPane().add(l2);
    	getContentPane().add(resul);
    	getContentPane().add(eva);
    	getContentPane().add(limExp);
    	getContentPane().add(limRes);
        getContentPane().add(cod);
    }
    
    public void actionPerformed(ActionEvent e){
       gramatica = new AnalizadorGramatical(
                   new AnalizadorLexico(expre.getText()));

	   if(e.getActionCommand().equals("eva")){
		   if(expre.getText().compareTo("") != 0){
			   resul.append(">  " + expre.getText() + "\n");               
			   expresion = new ContextoExpresion(); 
			   try{
				   double valor=expresion.evaluar(gramatica.analizar());
				   String ResultadoFinal=String.valueOf(valor);
				   resul.append(">  " + ResultadoFinal + "\n\n");
			   }catch(Error error){
				   JOptionPane.showMessageDialog(null,"ERROR!!!\n"+
							"La expresion no se puede evaluar...");
				   resul.append(">  ERROR!!!" + "\n\n");
			   }
			}
		   	else{
		   		JOptionPane.showMessageDialog(null,"ERROR!!!\n"+
		   				"El campo de la expresion esta vacio.\n"+
		   				"Inserte una Expresion...");
		   	}
           UltimoEvaluado=expresion.Cabecera()+expresion.VarInicial()+
                   expresion.Var()+expresion.CodeI()+expresion.Operaciones()+
                   expresion.CodeF();
	   }			
	   if(e.getActionCommand().equals("le")){
		   expre.setText("");		   
	   }
	   if(e.getActionCommand().equals("lr")){
		   resul.setText("");
       }
       if(e.getActionCommand().equals("cod")){           
           String Nom=JOptionPane.showInputDialog(null,"Ingresa el nombre: ","CRear",1);
					Directorio Crear=new Directorio(Nom);
					Crear.EscribirArchivo(Programa());
           
       }
    }

    String UltimoEvaluado="";
    public String Programa(){
		return UltimoEvaluado;
	}
   
    public static void main(String[] args) {
    	new VentanaEvaluador().setVisible(true);	
	}    
}