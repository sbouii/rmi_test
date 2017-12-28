import java.rmi.*;
import java.util.Scanner;
import java.rmi.registry.*;
import java.util.Scanner;
public class InstClient {
public InstClient (String [] args) {

    try{
	  if(System.getSecurityManager() == null) 
		System.setSecurityManager(new RMISecurityManager());
          Registry reg = LocateRegistry.getRegistry("localhost",1099); 
	  FabInterface fabrique = (FabInterface) reg.lookup("Fabrique");
          InstInterface Obj1;
          Obj1= (InstInterface)fabrique.newInst();
          System.out.println("\n selectionner l'institution (quitter avec ctrl-c)\n");
          System.out.println(" 1: FST \n 2:ENIT \n 3:ISI  \n 4:INSAT \n 5:ENSIT\n6:ENSI \n");
          Scanner sca = new Scanner(System.in);
          int scn = sca.nextInt();
          String filename = "";
          String filename2 = "";
          switch(scn){
           case 1:
           
        	   filename = "C:\\Users\\Hèla\\Desktop\\m\\rmi-master\\fst.txt";
        	   filename2 = "C:\\Users\\Hèla\\Desktop\\m\\rmi-master\\fst2.txt";
           break;
           case 2:
           filename = "C:\\Users\\Hèla\\Desktop\\m\\rmi-master\\enit.txt";
           filename2="C:\\Users\\Hèla\\Desktop\\m\\rmi-master\\enit2.txt";
           break;
           case 3:
           filename = "C:\\Users\\Hèla\\Desktop\\m\\rmi-master\\isi.txt";
           filename2 = "C:\\Users\\Hèla\\Desktop\\m\\rmi-master\\isi2.txt";
           break;
           case 4:
           filename = "C:\\Users\\Hèla\\Desktop\\m\\rmi-master\\insat.txt";
           filename2 = "C:\\Users\\Hèla\\Desktop\\m\\rmi-master\\insat2.txt";
           break;
           case 5:
           filename = "C:\\Users\\Hèla\\Desktop\\m\\rmi-master\\ensit.txt";
           filename2 = "C:\\Users\\Hèla\\Desktop\\m\\rmi-master\\ensit2.txt";
           break;
           case 6:
           filename = "C:\\Users\\Hèla\\Desktop\\m\\rmi-master\\ensi.txt";
           filename2 = "C:\\Users\\Hèla\\Desktop\\m\\rmi-master\\ensi2.txt";
           break;
          }
          System.out.println("\n selectionner l'operation que vous voulez faire(quitter avec ctrl-c)\n");
          System.out.println(" 1: pour ajouter un employé \n 2: pour mettre à  jour un employé  \n 3: pour supprimer un employé  \n 4: pour chercher un employé \n 5: pour quitter" );
          Scanner scan = new Scanner(System.in);
          int sc = scan.nextInt();
          switch(sc){
           case 1:
           System.out.println("Veuillez entrer les informations suivantes: \n");
           System.out.println("nom: ");
           Scanner scan1 = new Scanner(System.in);
           String nom = scan1.nextLine();
           System.out.println("prenom:   ");
           Scanner scan2 = new Scanner(System.in);
           String prenom = scan2.nextLine();
           System.out.println("cin:    ");
           Scanner scan3 = new Scanner(System.in);
           int cin = scan3.nextInt();
           Scanner scan4 = new Scanner(System.in);
           System.out.println("telephone:    ");
           int telephone = scan4.nextInt();
           Obj1.ajouter(filename,nom,prenom,cin,telephone);
           System.out.println("Employe ajoute!");
           break;
           case 2:
        	   
        	   System.out.println("Veuillez entrer le nom de l'employe à mettre à jour : \n");
               System.out.println("nom: ");
               Scanner scan9 = new Scanner(System.in);
               String name1 = scan9.nextLine();
               int indice1=Obj1.IndiceLigne(name1, filename);
               if (indice1==0)
               {
             	  System.out.println("ce nom d'employé est introuvable");
               }
               else
               {
                
                System.out.println("Veuillez entrer les informations suivantes: \n");
                System.out.println("nom: ");
                Scanner scan11 = new Scanner(System.in);
                String nom1 = scan11.nextLine();
                System.out.println("prenom:   ");
                Scanner scan12 = new Scanner(System.in);
                String prenom1 = scan12.nextLine();
                System.out.println("cin:    ");
                Scanner scan13 = new Scanner(System.in);
                int cin1 = scan13.nextInt();
                Scanner scan14 = new Scanner(System.in);
                System.out.println("telephone:    ");
                int telephone1 = scan14.nextInt();
                
                Obj1.ajour(filename,filename2,nom1,prenom1,cin1,telephone1, indice1);
               
                Obj1.ecraser(filename,filename2);
                System.out.println("informations mis à jour");
               }
        	   
        	   
        	   
        	   
        	   
        	   break;
           
           case 3: 
        	   System.out.println("Veuillez entrer le nom de l'employe à supprimer: \n");
               System.out.println("nom: ");
               Scanner scan6 = new Scanner(System.in);
               String nam = scan6.nextLine();
              int indice=Obj1.IndiceLigne(nam, filename);
              if (indice==0)
              {
            	  System.out.println("ce nom d'employé est introuvable");
              }
              else
              {
               Obj1.supprimer(filename, indice, filename2);
               Obj1.ecraser(filename,filename2);
               System.out.println("Employe supprimé!");
              }
              break;
           
           case 4:           
           System.out.println("Veuillez entrer le nom de l'employe: \n");
           System.out.println("nom: ");
           Scanner scan5 = new Scanner(System.in);
           String name = scan5.nextLine();
           System.out.println("voilà l'objet cherché:");
           
          String s=Obj1.chercher(filename, name);
          System.out.println("nom		prenom		   cin		telephone");
          System.out.println(s);
           break;
          
         
          }

     }    
     catch (Exception e) {
	  System.out.println ("Erreur d'acces a l'objet distant.");
	  System.out.println (e.toString());
          }
}
}

