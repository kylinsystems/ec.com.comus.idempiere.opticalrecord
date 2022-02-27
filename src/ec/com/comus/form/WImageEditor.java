package ec.com.comus.form;

import org.adempiere.webui.apps.AEnv;
import org.adempiere.webui.component.ConfirmPanel;
import org.adempiere.webui.component.Grid;
import org.adempiere.webui.component.GridFactory;
import org.adempiere.webui.component.Label;
import org.adempiere.webui.component.Row;
import org.adempiere.webui.component.Rows;
import org.adempiere.webui.component.Window;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.South;
import org.zkoss.zul.West;

public class WImageEditor extends Window implements EventListener<Event>{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ConfirmPanel confirmPanel;

	public WImageEditor(){
		super();
		setWidth("50%");
		setHeight("70%");
		setSizable(true);
		this.setBorder("normal");
		setClosable(true);
		initComponent();
		AEnv.showCenterScreen(this);
		
	}
	
	private void initComponent() {
		Borderlayout mainLayout = new Borderlayout();
		appendChild(mainLayout);
		
		
		West west = new West();
		west.setWidth("25%");
		mainLayout.appendChild(west);
		
			Grid gridWest = GridFactory.newGridLayout();
			gridWest.setStyle("border: none;");
			west.appendChild(gridWest);
			Rows rowsGridWest = gridWest.newRows();
			
			Row rowGridWest = rowsGridWest.newRow();
			
			Grid gridGirar = GridFactory.newGridLayout();
			gridGirar.setStyle("border: solid;");
			rowGridWest.appendChild(gridGirar);
			Rows rowsGridGirar = gridGirar.newRows();
			
			Row rowGridGirar = rowsGridGirar.newRow();
			Label lblGirar = new Label ("Girar");
			rowGridGirar.appendCellChild(makeCenterAlign(lblGirar));
			
			rowGridGirar = rowsGridGirar.newRow();
			Button btnGirar90 = new Button("90 Grados");
			rowGridGirar.appendCellChild(makeCenterAlign(btnGirar90));
			
			
		South south = new South();
		south.setHeight("12%");
		mainLayout.appendChild(south);
		confirmPanel = new ConfirmPanel(true);
		south.appendChild(confirmPanel);
		
		confirmPanel.addActionListener(Events.ON_CLICK, this);
		
		
		
	}

	public static void mos_msj(String Mensaje) {
        //mensaje.setText(Mensaje);
    }

	@Override
	public void onEvent(Event e) throws Exception {
		if (e.getTarget() == confirmPanel.getButton("Cancel")){
			 detach();
		}else if (e.getTarget() == confirmPanel.getButton("Ok")){
			 saveImage();
		}
	}

	private void saveImage() {
		// TODO Auto-generated method stub
		
	}
	
	public  Component makeCenterAlign(Component component) {
		Div div = new Div();
		div.setStyle("text-align: center");
		div.appendChild(component);
		return div;
	}
}
