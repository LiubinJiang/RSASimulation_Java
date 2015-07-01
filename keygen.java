package entity;
import java.math.*;
import java.util.*;
public class keygen {
	//BigInteger n=new BigInteger("0");
	private static final BigInteger NUM_1 = new BigInteger("1");
	
	public keygen(){}
	
	public String obtainPrivatekey(String pubKey, String phiN){
		String d=null;
		BigInteger p=new BigInteger(phiN);
		BigInteger n=new BigInteger(pubKey);
		d=n.modInverse(p).toString();
		return d;
		
	}
	
	public String obtainPublickey(){
		String e="5";
		return e;
	}
	
	public String obtainN(String p,String q){
		String result=null;
		BigInteger prime1=new BigInteger(p);
		BigInteger prime2=new BigInteger(q);
		result=prime1.multiply(prime2).toString();
		return result;
		
	}
	
	public String obtainPhin(String p,String q){
		String result=null;
		BigInteger prime1=new BigInteger(p);
		BigInteger prime2=new BigInteger(q);
		prime1=prime1.subtract(NUM_1);
		prime2=prime2.subtract(NUM_1);
		result=prime1.multiply(prime2).toString();
		return result;
		
	}
	

}
