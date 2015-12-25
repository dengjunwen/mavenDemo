package com.cgq.util;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class MD5 {

	public static String md5(String plainText) {
		String str = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			str = buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
/*		  for(int i=0;i<100;i++){
			 	Random r = new Random();
			 	int result = r.nextInt(540);
			 	System.out.println(result);
		  }*/
		  
	    	
	   /*     Integer Level1 = new Integer(540);
	        int first = 0;
	       if(Level1.intValue()!=0){
	            first = 540/Level1.intValue();
	        }
	       
	       System.out.println(first);*/
		  
		  
		System.out.println(md5("zhangsir"));
		
		
	}
}