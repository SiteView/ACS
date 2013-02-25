/**
 * 
 */
package com.swg.acs.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.commons.codec.binary.Base64;

/**
 * @author satriaprayoga
 *
 */
public class CpeAuthenticator implements Authenticator {
	
	private final static Map<String, String> userMaps=new HashMap<String, String>();
	
	public CpeAuthenticator() {
		userMaps.put("admin", "admin");
	}

	@Override
	public boolean authenticate(HttpServletRequest request,
			HttpServletResponse response) {
		String authHeader=request.getHeader("Authorization");
		if(authHeader==null || authHeader.isEmpty()){
             return false;
		}
		if(authHeader.toUpperCase().startsWith("BASIC "))
		{
			String usernamePass64=authHeader.substring(6);
			String usernamePassDecode=null;
//			usernamePassDecode=new String(Base64.decodeBase64(usernamePass64));
			String[] info=usernamePassDecode.split(":");
			System.out.println("username="+info[0]+" : "+"password="+info[1]);
			if(userMaps.get(info[0])!=null){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}

	@Override
	public boolean isBasic(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDigest(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
