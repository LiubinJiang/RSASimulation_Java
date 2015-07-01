package entity;
import java.math.BigInteger;
import java.util.*;


public class primeNumber {
	BigInteger num_neg1=new BigInteger("-1");
	BigInteger num_2=new BigInteger("2");
	BigInteger num_0=new BigInteger("0");
	BigInteger num_1=new BigInteger("1");

	//构造函数
	public primeNumber(){}
	
	//得到bigint的二进制位数
	public Integer obtainBit(String n){
		int result=0;
		BigInteger num=new BigInteger(n);
		
		result=num.bitLength();
		return result;
	}
	
	//产生小于被测数的随机数
	public String randomNumber(int numBit, String n){
		
		Random rnd=new Random();
		BigInteger num=new BigInteger(n);
		BigInteger randomNum=num_0; //initial value=0
		while(randomNum.equals(num_0)==true||randomNum.min(num)==num){
			randomNum=new BigInteger(numBit,rnd);
		}
		return randomNum.toString();		
	}
	
	//Miller-Rabin中的S
	public Integer obtainS(String n){
		BigInteger num=new BigInteger(n);
		int count=0;
		num=num.add(num_neg1);
		//System.out.println("n-1 is "+num);
		while(num.mod(num_2).equals(num_0)==true){
			num=num.divide(num_2);
			count++;
		}
		return count;
	}
	
	//Miller-Rabin中的d
	public String obtainD(String n,int s){
		BigInteger num=new BigInteger(n);
		BigInteger d=new BigInteger("0");
		BigInteger power2=new BigInteger("0");
		String result=null;
		num=num.add(num_neg1);
		power2=num_2.pow(s);
		d=num.divide(power2);
		result=d.toString();
		return result;		
	}
	
	//每一次迭代的结果
	public boolean aPowerdmodN(String randomNumber,String times,String n,int s){
		boolean result=false;
		BigInteger opResult=num_0;
		BigInteger a=new BigInteger(randomNumber);
		BigInteger d=new BigInteger(times);
		BigInteger num=new BigInteger(n);
		BigInteger exp=num_2;
		BigInteger numMinus1=num.add(num_neg1);
		//System.out.println(numMinus1);
				
		for(int i=1;i<=s;i++){
			if(i==1){
				//System.out.println(i+"th times");
				opResult=a.modPow(d, num);
				//System.out.println("random number is "+a+"; d is "+d+"; original number is "+n+"; s is "+s );
				//System.out.println("a^d= "+Math.pow(r,d));
				//System.out.println("mod n = "+opResult);
				if(opResult.equals(num_1)||opResult.equals(numMinus1)){
					result=true;
					//System.out.println("true at k="+i);
					break;
				}
				else continue;
			}else{
				//System.out.println(i+"th times");
				exp=num_2;
				exp=exp.pow(i-1);
				//System.out.println("exp is "+exp);
				
				opResult=a.modPow(d.multiply(exp),num);
				//System.out.println("mod n is "+opResult+",k="+i);
				if(opResult.equals(numMinus1)){
					//System.out.println("true at k="+i);
					result=true;
					break;
				}
			}	
		}
		return result;
	}
	
	//public boolean finalCheck(int step,boolean)
	
	//public boolean checkIteration(step){
		//if(step==1&check)
	//}
	
	

}
