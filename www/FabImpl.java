import java.rmi.*;
import java.rmi.server.*;
public class FabImpl extends UnicastRemoteObject implements FabInterface{
   public FabImpl()throws RemoteException {}; 
   public InstInterface newInst() throws RemoteException {       
   return new Inst();}
}

