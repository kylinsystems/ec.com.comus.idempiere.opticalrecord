package ec.com.comus.form;

import org.adempiere.webui.component.Tab;
import org.adempiere.webui.component.Tabbox;
import org.adempiere.webui.component.Tabpanel;
import org.adempiere.webui.component.Tabpanels;
import org.adempiere.webui.component.Tabs;
import org.adempiere.webui.panel.ADForm;
import org.adempiere.webui.panel.CustomForm;
import org.adempiere.webui.panel.IFormController;
import org.adempiere.webui.util.ZKUpdateUtil;

public class WOpticalRecordForm implements IFormController{
	
	private CustomForm form = new CustomForm();
	private Tabpanel tabAddImage;
	private Tabpanel tabPOpticalRecord;
	private WStoreImage storeImage;
	private WOpticalRecord opticalRecord;

	@Override
	public ADForm getForm() {
		
		Tabbox tabbedPane = new Tabbox();
		form.appendChild(tabbedPane);
		Tabpanels tabpanels = new Tabpanels();
		tabAddImage = new Tabpanel();
		tabPOpticalRecord = new Tabpanel();

		
		Tabs tabs = new Tabs();
		Tab tabOpticalRecord = new Tab();
		Tab tabAddPicture = new Tab();

		tabOpticalRecord.setLabel("Historial");
		tabAddPicture.setLabel("Agregar imagenes");
			
		tabs.appendChild(tabOpticalRecord); 
		tabs.appendChild(tabAddPicture);

		
		ZKUpdateUtil.setHflex(tabpanels, "1");
		tabpanels.appendChild(tabPOpticalRecord);
		tabpanels.appendChild(tabAddImage);
		
		ZKUpdateUtil.setHflex(tabbedPane, "1");
		ZKUpdateUtil.setVflex(tabbedPane, "1");
		tabbedPane.appendChild(tabs);
		tabbedPane.appendChild(tabpanels);
		
		storeImage = new WStoreImage();
		opticalRecord = new WOpticalRecord(storeImage);
		ADForm formOpticalRecord = opticalRecord.getForm();
		tabPOpticalRecord.appendChild(formOpticalRecord);
		
		
		ADForm formImage = storeImage.getForm();
		tabAddImage.appendChild(formImage);

	
		return form;
	}

}
