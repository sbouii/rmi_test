import java.rmi.Remote;
import java.rmi.RemoteException;
public interface InstInterface extends Remote 
{
	public String ajouter(String Inst, String nom, String prenom, int cin, int telephone) throws RemoteException;
        public String chercher(String Inst, String nom) throws RemoteException;
        public int IndiceLigne (String nom,String Inst)throws RemoteException;
        public  void supprimer(String Inst, int indice, String Inst2) throws RemoteException;
        public void ecraser(String Inst, String Inst1)throws RemoteException ;

        public void ajour (String Inst, String Inst2, String nom1,String prenom1, int cin1, int tel1, int indice1)throws RemoteException;
        
}
