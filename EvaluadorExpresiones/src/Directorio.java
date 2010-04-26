import java.io.*;
import java.nio.channels.FileChannel;
import javax.swing.JOptionPane;

public class Directorio {
	private String Nombre;

	public Directorio(String Cadena){
		File Directorio = new File("C:/ProgSist/");

		File Crear=new File(Directorio,Cadena);
		Nombre=Cadena;
		if(Crear.exists()){
			JOptionPane.showMessageDialog(null,"Ya existe un proyecto con el Mismo Nombre ");
		}else{
			Crear.mkdirs();
		}
	}


	public void MoverArchivo1(){
		 try{
			 FileInputStream fis = new FileInputStream("C:/MASM611/BINR/Irvine16.lib");
			 FileOutputStream fos = new FileOutputStream("C:/ProgSist/"+Nombre+"/Irvine16.lib");
			 FileChannel canalFuente = fis.getChannel();
			 FileChannel canalDestino = fos.getChannel();
			 canalFuente.transferTo(0, canalFuente.size(), canalDestino);
			 fis.close();
			 fos.close();
		 }catch(Exception e){
			 JOptionPane.showMessageDialog(null,"Verifica la existencia del Archivo...");
		 }
	}

	public void MoverArchivo2(){
		 try{
			 FileInputStream fis = new FileInputStream("C:/MASM611/BIN/Irvine16.inc");
			 FileOutputStream fos = new FileOutputStream("C:/ProgSist/"+Nombre+"/Irvine16.inc");
			 FileChannel canalFuente = fis.getChannel();
			 FileChannel canalDestino = fos.getChannel();
			 canalFuente.transferTo(0, canalFuente.size(), canalDestino);
			 fis.close();
			 fos.close();
		 }catch(Exception e){
			 JOptionPane.showMessageDialog(null,"Verifica la existencia del Archivo...");
		 }
	}

	public void MoverArchivo3(){
		 try{
			 FileInputStream fis = new FileInputStream("C:/MASM611/BIN/Macros.inc");
			 FileOutputStream fos = new FileOutputStream("C:/ProgSist/"+Nombre+"/Macros.inc");
			 FileChannel canalFuente = fis.getChannel();
			 FileChannel canalDestino = fos.getChannel();
			 canalFuente.transferTo(0, canalFuente.size(), canalDestino);
			 fis.close();
			 fos.close();
		 }catch(Exception e){
			 JOptionPane.showMessageDialog(null,"Verifica la existencia del Archivo...");
		 }
	}

	public void MoverArchivo4(){
		 try{
			 FileInputStream fis = new FileInputStream("C:/MASM611/BIN/Oper.asm");
			 FileOutputStream fos = new FileOutputStream("C:/ProgSist/"+Nombre+"/Oper.asm");
			 FileChannel canalFuente = fis.getChannel();
			 FileChannel canalDestino = fos.getChannel();
			 canalFuente.transferTo(0, canalFuente.size(), canalDestino);
			 fis.close();
			 fos.close();
		 }catch(Exception e){
			 JOptionPane.showMessageDialog(null,"Verifica la existencia del Archivo...");
		 }
	}

	public void EscribirArchivo(String Cadena){
		  try {
		        BufferedWriter outfile =new BufferedWriter(new FileWriter("C:/ProgSist/"+Nombre+"/"+Nombre+".asm"));
		        outfile.write(Cadena);
		        outfile.close();
		    }
		    catch (IOException e){

		    }

	}

	public void EscribirBat(){
			String Instruccion="";
			//Runtime.getRuntime().exec("CMD /C COPY \"" + origen + "\\Irvine16.inc\" \"" + destino + "\"").waitFor();
			Instruccion+="masm "+Nombre+".asm";
			Instruccion+="\nlink "+Nombre+".obj";
			Instruccion+="\n@pause";

			try {
				BufferedWriter outfile =new BufferedWriter(new FileWriter("C:/ProgSist/"+Nombre+"/"+Nombre+".bat"));
		        outfile.write(Instruccion);
		        outfile.close();
		    } catch (IOException e){
		    	JOptionPane.showMessageDialog(null,"Error al creAr el bat");
		    }

	}

}
