/**
 * 
 */
package com.swg.acs.message.cwmp;

import com.swg.acs.MessageBody;

/**
 * @author satriaprayoga
 *
 */
public class CwmpMessageBody extends CwmpArgument implements MessageBody{
	
	
	public CwmpMessageBody(String name) {
		this(name,null,null);
	}
	
	public CwmpMessageBody(String name, String prefix, String uri) {
		super(name, prefix, uri);
	}

	@Override
	public boolean hasFault() {
		return (getName().equals("Fault"));
	}

}
