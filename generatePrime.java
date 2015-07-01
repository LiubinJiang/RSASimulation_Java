package entity;
import java.math.*;
import java.util.*;

public class generatePrime {
	//private static final Integer UPLIMITED = 1024 ;
	//private static final Integer DOWNLIMITED = 1023;
	//生成2^1023-2^1024之间的随机数
	public String generateRandom(int uplimited){
		BigInteger cond=new BigInteger("2");
		cond=cond.pow(uplimited-1);
		String num="1";
		BigInteger n=new BigInteger("0");
		while(n.min(cond).equals(n)){
			//System.out.println("trail begins");
			Random rnd=new Random();
			n=new BigInteger(uplimited,rnd);
			num=n.toString();
			//System.out.println(n.bitLength());
		}
		//System.out.println(num);
		return num;		
		
	}

}
