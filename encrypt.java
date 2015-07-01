package entity;
import java.util.*;
import java.math.*;
public class encrypt {
	public encrypt(){}
	
	public String encryptFunction(String m, String e, String n){
		String result=null;
		BigInteger message=new BigInteger(m);
		BigInteger pubkey=new BigInteger(e);
		BigInteger num=new BigInteger(n);
		result=message.modPow(pubkey, num).toString();
		return result;
		
	}
	
	public String decryptFunction(String c, String d, String n){
		String result=null;
		BigInteger ciphertext=new BigInteger(c);
		BigInteger prikey=new BigInteger(d);
		BigInteger num=new BigInteger(n);
		result=ciphertext.modPow(prikey, num).toString();
		return result;
	}

}
