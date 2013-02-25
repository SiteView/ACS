/**
 * 
 */
package com.swg.acs.message;

import com.swg.acs.MessageBody;
import com.swg.acs.message.cwmp.ArgumentFactory;
import com.swg.acs.message.cwmp.CwmpMessage;

/**
 * @author satriaprayoga
 *
 */
public class AddObjectResponse extends CwmpMessage {

	private static final long serialVersionUID = -8575552897429226990L;
	
	private int status;
	private int instanceNumber;
	
	public AddObjectResponse() {
		super("AddObjectResponse");
	}

	/* (non-Javadoc)
	 * @see com.swg.acs.Message#configureBody(com.swg.acs.MessageBody, com.swg.acs.message.cwmp.ArgumentFactory)
	 */
	@Override
	protected void configureBody(MessageBody bodyPart,
			ArgumentFactory argumentFactory) {

	}

	/* (non-Javadoc)
	 * @see com.swg.acs.Message#configureParse(com.swg.acs.MessageBody)
	 */
	@Override
	protected void configureParse(MessageBody messageBody) {
		instanceNumber=Integer.parseInt(messageBody.getChild("InstanceNumber").getValue());
		status=Integer.parseInt(messageBody.getChild("Status").getValue());
	}
	
	public int getStatus() {
		return status;
	}
	
	public int getInstanceNumber() {
		return instanceNumber;
	}

}
