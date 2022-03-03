package ec.com.comus.form;

import java.util.Date;

public interface ChangeBPartnerListener {
	
	public abstract void setBPartnerID(Integer C_BPartner_ID);
	
	public abstract void setDate(Date date);

	public abstract void setDescription(Object object);
	
	public abstract void createNewFolder();
	
	public abstract void loadImagesFolder();

}
