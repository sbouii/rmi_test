import java.rmi.*;
import java.io.OutputStream;
import java.io.InputStream;
import java.rmi.server.*;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader; 
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
public class Inst extends UnicastRemoteObject implements InstInterface 
{
       public Inst() throws RemoteException
       {
	    super();
       }
       public String ajouter(String Inst, String nom, String prenom, int cin, int telephone) throws RemoteException {             
           
           File fichierTexte = new File (Inst);
           FileWriter ecrireFichier;
           try {
              ecrireFichier = new FileWriter(fichierTexte,true); 
              ecrireFichier.write("\r\n");
	      ecrireFichier.write(nom );
	      ecrireFichier.write("		" );
	      ecrireFichier.write(prenom);
	      ecrireFichier.write("		" );
	      ecrireFichier.write(cin);
	      ecrireFichier.write("		" );
	      ecrireFichier.write(telephone);
              ecrireFichier.close();
              return "ok!";
           } 
           catch (FileNotFoundException e) {
            e.printStackTrace();
            return "erreur : fichier non trouvable ou pas d'acces au fichier";
           }
           catch (IOException e) { 
            e.printStackTrace();  
            return "erreur !";     
           }          
      }
      public String chercher(String Inst, String nom) throws RemoteException {
                
               try {
                BufferedReader reader = new BufferedReader(new FileReader(Inst)); 
                String line = null; 
                while ((line = reader.readLine()) != null) { 
                 if (line.contains(nom)) { 
                    return(line);
                 }
                }
                return "pas d'employé de ce nom !";       
               }
               catch (FileNotFoundException e) {
                e.printStackTrace();
                return "erreur : fichier non trouvable ou pas d'acces au fichier";
               }
               catch (IOException e) {
                e.printStackTrace();
                return " erreur !";
               } 

      }
      
      public int IndiceLigne(String nom, String Inst)throws RemoteException
      {
    		int no=2;
 		 try {
 	
 			
 			 File f = new File(Inst); 
 			 		
 			 BufferedReader reader = new BufferedReader(new FileReader(f)); 
 			 String line = reader.readLine();
 		
 			
    	  while (((line = reader.readLine()) != null)&&(line.contains(nom)==false))
    	  {
    		  no++;
    	  }
    	  return no;
      }
 		   catch (FileNotFoundException e) {
 	            e.printStackTrace();
 	            System.out.println("erreur : fichier non trouvable ou pas d'accÃ©s au fichier");
 	            return 0;
 	           }
 	           catch (IOException e) { 
 	            e.printStackTrace();  
 	            System.out.println( "erreur !"); 
 	            return 0;
 	           } 
      }
      
      public void supprimer(String Inst,int indice, String Inst2) throws RemoteException {
    	   Scanner fluxEntree = null;
    		 PrintWriter fluxSortie = null;
    		 try
    		 { fluxEntree =new Scanner(new FileInputStream(Inst));
    		 fluxSortie= new PrintWriter(
    		 new FileOutputStream(Inst2)); }
    		 catch(FileNotFoundException e)
    		 { System.out.println("Erreur ouverture fichier.");
    		 System.exit(0); }
    		 String ligne = null;
    		 int nblines=0;
    		 while (fluxEntree.hasNextLine( ))
    		 { ligne = fluxEntree.nextLine( );
    		 nblines++;
    		 if (nblines!=indice) {
    		 
    		 fluxSortie.println( ligne); }}
    		 fluxEntree.close( );
    		 fluxSortie.close( );
    		 
      }
      
     public  void ecraser(String Inst, String Inst2)throws RemoteException {
    	 try (InputStream sourceFile = new java.io.FileInputStream(Inst2);  
		            OutputStream destinationFile = new FileOutputStream(Inst)) { 
		        // Lecture par segment de 0.5Mo  
		        byte buffer[] = new byte[512 * 1024]; 
		        int nbLecture; 
		        while ((nbLecture = sourceFile.read(buffer)) != -1){ 
		            destinationFile.write(buffer, 0, nbLecture); 
		        } 
		    } catch (IOException e){ 
		        e.printStackTrace();
		        System.out.println("erreur");
		        // Erreur 
		    } 
		   }
		 
  
    		 
			
      
     
     
     

 	public void ajour (String Inst, String Inst2, String nom1,String prenom1, int cin1, int tel1, int indice1)throws RemoteException
 	{

		   Scanner fluxEntree = null;
		 PrintWriter fluxSortie = null;
		 try
		 { fluxEntree =new Scanner(new FileInputStream(Inst));
		 fluxSortie= new PrintWriter(
		 new FileOutputStream(Inst2)); }
		 catch(FileNotFoundException e)
		 { System.out.println("Erreur ouverture fichier.");
		 System.exit(0); }
		 String ligne = null; 
		 int nblines=0;
		 while (fluxEntree.hasNextLine( ))
		 { 
		if (nblines==indice1 )
		{ ajouter(Inst2,nom1,prenom1,cin1,tel1);
		ligne = fluxEntree.nextLine( );
		}
		else {  
	    fluxSortie.println( ligne);}
	    nblines++;
		
	
		}
		 fluxEntree.close( );
		 fluxSortie.close( );
	
		 
  }
}
