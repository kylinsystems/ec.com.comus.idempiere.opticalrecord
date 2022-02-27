package ec.com.comus.form;

import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import org.adempiere.exceptions.AdempiereException;
import org.adempiere.webui.component.Borderlayout;
import org.adempiere.webui.component.Button;
import org.adempiere.webui.component.Grid;
import org.adempiere.webui.component.GridFactory;
import org.adempiere.webui.component.Label;
import org.adempiere.webui.component.ListModelTable;
import org.adempiere.webui.component.Listbox;
import org.adempiere.webui.component.ListboxFactory;
import org.adempiere.webui.component.Row;
import org.adempiere.webui.component.Rows;
import org.adempiere.webui.component.WListbox;
import org.adempiere.webui.editor.IZoomableEditor;
import org.adempiere.webui.editor.WDateEditor;
import org.adempiere.webui.editor.WEditorPopupMenu;
import org.adempiere.webui.editor.WSearchEditor;
import org.adempiere.webui.editor.WStringEditor;
import org.adempiere.webui.event.ContextMenuListener;
import org.adempiere.webui.event.ValueChangeEvent;
import org.adempiere.webui.event.ValueChangeListener;
import org.adempiere.webui.panel.ADForm;
import org.adempiere.webui.panel.CustomForm;
import org.adempiere.webui.panel.IFormController;
import org.adempiere.webui.theme.ThemeManager;
import org.compiere.minigrid.IDColumn;
import org.compiere.model.MBPartner;
import org.compiere.model.MLookup;
import org.compiere.model.MLookupFactory;
import org.compiere.model.Query;
import org.compiere.util.DisplayType;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.compiere.util.Util;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Center;
import org.zkoss.zul.Div;
import org.zkoss.zul.Hlayout;
import org.zkoss.zul.North;
import org.zkoss.zul.Space;
import org.zkoss.zul.Vlayout;
import org.zkoss.zul.West;
import org.zkoss.zul.impl.XulElement;

import ec.com.comus.model.X_COMUS_OpticalRecord;



public class WOpticalRecord implements IFormController,EventListener<Event>, ValueChangeListener{
	
	private CustomForm form = new CustomForm();
	private Properties ctx = Env.getCtx();
	private WSearchEditor fBPartner;
	private Button btnAdd;
	private Button btnDelete;
	private WDateEditor fDate;
	private WListbox lstControl;
	private Label fPartnerName;
	private Label fLastName;
	private Label fAddress;
	private Button btnSave;
	private Button btnPrint;
	private WStringEditor fOcupation;
	private WStringEditor fAge;
	private WStringEditor fOD;
	private WStringEditor fOI;
	private WStringEditor fVCLOD;
	private WStringEditor fVCLOI;
	private WStringEditor fVSLOD;
	private WStringEditor fVSLOI;
	private WStringEditor fCoverTC;
	private WStringEditor fCoverTL;
	private WStringEditor fObsevations;
	private WStringEditor fPĥysicalExam;
	private WStringEditor fOtalOD;
	private WStringEditor fOtalOI;
	private WStringEditor fQueraOD;
	private WStringEditor fQueraOI;
	private WStringEditor fRetiOD;
	private WStringEditor fRetiOI;
	private WStringEditor fARKOD;
	private WStringEditor fARKOI;
	private WStringEditor fEsferaOD;
	private WStringEditor fCilindroOD;
	private WStringEditor fEjeOD;
	private WStringEditor fPrismaOD;
	private WStringEditor fBaseOD;
	private WStringEditor fAVOD;
	private WStringEditor fADDOD;
	private WStringEditor fDPOD;
	private WStringEditor fPPCOD;
	private WStringEditor fEsferaOI;
	private WStringEditor fCilindroOI;
	private WStringEditor fEjeOI;
	private WStringEditor fPrismaOI;
	private WStringEditor fBaseOI;
	private WStringEditor fAVOI;
	private WStringEditor fADDOI;
	private WStringEditor fDPOI;
	private WStringEditor fPPCOI;
	private WStringEditor fTratamiento;
	private WStringEditor fResp;
	private WStringEditor fDescription;
	private Vector<Vector<Object>> linesOpticalRecord; 
	private int X_COMUS_OpticalRecord_ID;
	private WDateEditor fDateTrx;
	private ChangeBPartnerListener bpartnerListener;
	
	public WOpticalRecord(ChangeBPartnerListener bpartnerListener) {
		this.bpartnerListener = bpartnerListener;
		try {
			zkInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void zkInit() throws Exception {
		
		Borderlayout borderLayout = new Borderlayout();
		form.appendChild(borderLayout);
		
		Center center = new Center();
		center.appendChild(getPanelCenter());
		borderLayout .appendChild(center);
		
		West west = new West();
		west.setWidth("20%");
		west.appendChild(getPanelWest());
		borderLayout.appendChild(west);	
		
		btnSave.addEventListener(Events.ON_CLICK, this);
	}
	private Component getPanelCenter() {
		
		Vlayout vLayout = new Vlayout(); 
		Grid grid = GridFactory.newGridLayout(); 
//		vLayout.appendChild(grid);
		Rows rows = grid.newRows(); 
		Row row = rows.newRow(); 
		
		Label lblName = new Label(Msg.translate(ctx, "Name"));
		fPartnerName = new Label(); 
		row.appendCellChild(lblName);
		row.appendCellChild(fPartnerName);
		
		row = rows.newRow(); 
		Label lblLastName = new Label("Apellido");
		fLastName = new Label(); 
		row.appendCellChild(lblLastName);
		row.appendCellChild(fLastName);
		
		Label lblAddress = new Label(Msg.translate(ctx, "Address"));
		fAddress = new Label(); 
		row = rows.newRow();
		row.appendCellChild(lblAddress);
		row.appendCellChild(fAddress);	
		
		Hlayout hLayout = new Hlayout();
		
		btnSave = new Button();
		btnSave.setImage(ThemeManager.getThemeResource("images/Save16.png"));
		
		btnPrint = new Button();
		btnPrint.setImage(ThemeManager.getThemeResource("images/Print16.png"));
		
		hLayout.appendChild(btnSave);
		hLayout.appendChild(btnPrint);
		
		vLayout.appendChild(hLayout);
			
		vLayout.appendChild(getPanelDataInput());
		
		return vLayout;
	}
	
	private Grid getPanelDataInput() {
		
		Grid gridFields = GridFactory.newGridLayout(); 
		Rows rowsFields = gridFields.newRows(); 
		Row rowFields = rowsFields.newRow(); 
		
			Label lblDate  = new Label("Fecha");
			fDateTrx = new WDateEditor(); 
			rowFields.appendCellChild(lblDate.rightAlign());
			rowFields.appendCellChild(fDateTrx.getComponent());
			
			Label lblOcupation = new Label("Ocupación");
			fOcupation = new WStringEditor(); 
			fOcupation.getComponent().setWidth("100%");
			rowFields.appendCellChild(lblOcupation.rightAlign());
			rowFields.appendCellChild(fOcupation.getComponent(), 4);
			
			Label lblAge = new Label("Edad");
			fAge = new WStringEditor(); 
			fAge.getComponent().setWidth("70%");
			rowFields.appendCellChild(lblAge.rightAlign());
			rowFields.appendCellChild(fAge.getComponent());
			
		
		rowFields = rowsFields.newRow(); 
			rowFields.appendCellChild(new Space());
		rowFields = rowsFields.newRow();
		
			Label lblOD = new Label("Lentes en uso OD");
			fOD =  new WStringEditor();
			fOD.getComponent().setWidth("100%");
			rowFields.appendCellChild(lblOD.rightAlign());
			rowFields.appendCellChild(fOD.getComponent());
			
			Label lblVCLOD = new Label("VCL"); 
			fVCLOD = new WStringEditor(); 
			fVCLOD.getComponent().setWidth("100%");
			rowFields.appendCellChild(lblVCLOD.rightAlign());
			rowFields.appendCellChild(fVCLOD.getComponent());
			
			Label lblVSLOD = new Label("VSL"); 
			fVSLOD = new WStringEditor(); 
			fVSLOD.getComponent().setWidth("100%");
			rowFields.appendCellChild(lblVSLOD.rightAlign());
			rowFields.appendCellChild(fVSLOD.getComponent(),2);
			
			Label lblCoverTC = new Label("Cover T Cerca"); 
			fCoverTC = new WStringEditor(); 
			fCoverTC.getComponent().setWidth("100%");
			rowFields.appendCellChild(lblCoverTC.rightAlign());
			rowFields.appendCellChild(fCoverTC.getComponent(),2);
		
		rowFields = rowsFields.newRow(); 
			
			Label lblOI = new Label("OI");
			fOI =  new WStringEditor();
			fOI.getComponent().setWidth("100%");
			rowFields.appendCellChild(lblOI.rightAlign());
			rowFields.appendCellChild(fOI.getComponent());
			
			Label lblVCLOI = new Label("VCL"); 
			fVCLOI = new WStringEditor(); 
			fVCLOI.getComponent().setWidth("100%");
			rowFields.appendCellChild(lblVCLOI.rightAlign());
			rowFields.appendCellChild(fVCLOI.getComponent());
			
			Label lblVSLOI = new Label("VSL"); 
			fVSLOI = new WStringEditor(); 
			fVSLOI.getComponent().setWidth("100%");
			rowFields.appendCellChild(lblVSLOI.rightAlign());
			rowFields.appendCellChild(fVSLOI.getComponent(),2);
			
			Label lblCoverTL = new Label("Cover T Lejos"); 
			fCoverTL = new WStringEditor(); 
			fCoverTL.getComponent().setWidth("100%");
			rowFields.appendCellChild(lblCoverTL.rightAlign());
			rowFields.appendCellChild(fCoverTL.getComponent(),2);
		
		rowFields = rowsFields.newRow();
			rowFields.appendCellChild(new Space());
		rowFields = rowsFields.newRow();
		
			Label lblObservations = new Label ("Observarciones");
			fObsevations = new WStringEditor(); 
			fObsevations.getComponent().setMultiline(true);
			fObsevations.getComponent().setWidth("100%");
			rowFields.appendCellChild(lblObservations.rightAlign());
			rowFields.appendCellChild(fObsevations.getComponent(), 9);
		
		rowFields = rowsFields.newRow(); 
			
			Label lblPĥysicalExam = new Label ("Examen Físico");
			fPĥysicalExam = new WStringEditor(); 
			fPĥysicalExam.getComponent().setMultiline(true);
			fPĥysicalExam.getComponent().setWidth("100%");
			rowFields.appendCellChild(lblPĥysicalExam.rightAlign());
			rowFields.appendCellChild(fPĥysicalExam.getComponent(), 9);
			
		rowFields = rowsFields.newRow();
			rowFields.appendCellChild(new Space());
		rowFields = rowsFields.newRow();
			Label lblOtalOD = new Label("Otalmoscopia OD"); 
			fOtalOD = new WStringEditor(); 
			fOtalOD.getComponent().setWidth("100%");
			rowFields.appendCellChild(lblOtalOD.rightAlign());
			rowFields.appendCellChild(fOtalOD.getComponent(), 4);
			
			Label lblOtalOI= new Label("O.I."); 
			fOtalOI = new WStringEditor(); 
			fOtalOI.getComponent().setWidth("100%");
			rowFields.appendCellChild(lblOtalOI.rightAlign());
			rowFields.appendCellChild(fOtalOI.getComponent(), 4);
			
		rowFields = rowsFields.newRow();
			Label lblOQueraOD = new Label("Queratometría OD"); 
			fQueraOD = new WStringEditor(); 
			fQueraOD.getComponent().setWidth("100%");
			rowFields.appendCellChild(lblOQueraOD.rightAlign());
			rowFields.appendCellChild(fQueraOD.getComponent(), 4);
			
			Label lblOQueraOI= new Label("O.I."); 
			fQueraOI = new WStringEditor(); 
			fQueraOI.getComponent().setWidth("100%");
			rowFields.appendCellChild(lblOQueraOI.rightAlign());
			rowFields.appendCellChild(fQueraOI.getComponent(), 4);
			
		rowFields = rowsFields.newRow();
			Label lblRetiOD = new Label("Retinoscopia OD"); 
			fRetiOD = new WStringEditor(); 
			fRetiOD.getComponent().setWidth("100%");
			rowFields.appendCellChild(lblRetiOD.rightAlign());
			rowFields.appendCellChild(fRetiOD.getComponent(), 4);
			
			Label lblRetiOI= new Label("O.I."); 
			fRetiOI = new WStringEditor(); 
			fRetiOI.getComponent().setWidth("100%");
			rowFields.appendCellChild(lblRetiOI.rightAlign());
			rowFields.appendCellChild(fRetiOI.getComponent(), 4);
			
		rowFields = rowsFields.newRow();
			Label lblARKOD= new Label("ARK"); 
			fARKOD = new WStringEditor(); 
			fARKOD.getComponent().setWidth("100%");
			rowFields.appendCellChild(lblARKOD.rightAlign());
			rowFields.appendCellChild(fARKOD.getComponent(), 4);
			
			Label lblARKOI= new Label("O.I."); 
			fARKOI = new WStringEditor(); 
			fARKOI.getComponent().setWidth("100%");
			rowFields.appendCellChild(lblARKOI.rightAlign());
			rowFields.appendCellChild(fARKOI.getComponent(), 4);
			
		rowFields = rowsFields.newRow();
			rowFields.appendCellChild(new Space());
		rowFields = rowsFields.newRow();
			rowFields.appendCellChild(new Space());
			Label lblHeader = new Label("Esferas"); 
			rowFields.appendCellChild(lblHeader);
		    lblHeader = new Label("Cilindro"); 
			rowFields.appendCellChild(lblHeader);
			lblHeader = new Label("Eje"); 
			rowFields.appendCellChild(lblHeader);
			lblHeader = new Label("Prisma"); 
			rowFields.appendCellChild(lblHeader);
			lblHeader = new Label("Base"); 
			rowFields.appendCellChild(lblHeader);
			lblHeader = new Label("A.V."); 
			rowFields.appendCellChild(lblHeader);
			lblHeader = new Label("ADD"); 
			rowFields.appendCellChild(lblHeader);
			lblHeader = new Label("D.P."); 
			rowFields.appendCellChild(lblHeader);
			lblHeader = new Label("PPC"); 
			rowFields.appendCellChild(lblHeader);
		
		rowFields = rowsFields.newRow();
			
			Label lblRXOD = new Label("RX    O.D.");
			rowFields.appendCellChild(lblRXOD.rightAlign());
			
			fEsferaOD = new WStringEditor(); 
			fEsferaOD.getComponent().setWidth("100%");
			rowFields.appendCellChild(fEsferaOD.getComponent());
			
			fCilindroOD = new WStringEditor(); 
			fCilindroOD.getComponent().setWidth("100%");
			rowFields.appendCellChild(fCilindroOD.getComponent());
			
			fEjeOD = new WStringEditor(); 
			fEjeOD.getComponent().setWidth("100%");
			rowFields.appendCellChild(fEjeOD.getComponent());
			
			fPrismaOD = new WStringEditor(); 
			fPrismaOD.getComponent().setWidth("100%");
			rowFields.appendCellChild(fPrismaOD.getComponent());
			
			fBaseOD = new WStringEditor(); 
			fBaseOD.getComponent().setWidth("100%");
			rowFields.appendCellChild(fBaseOD.getComponent());
			
			fAVOD = new WStringEditor(); 
			fAVOD.getComponent().setWidth("100%");
			rowFields.appendCellChild(fAVOD.getComponent());
			
			fADDOD = new WStringEditor(); 
			fADDOD.getComponent().setWidth("100%");
			rowFields.appendCellChild(fADDOD.getComponent());
			
			fDPOD = new WStringEditor(); 
			fDPOD.getComponent().setWidth("100%");
			rowFields.appendCellChild(fDPOD.getComponent());
			
			fPPCOD = new WStringEditor(); 
			fPPCOD.getComponent().setWidth("100%");
			rowFields.appendCellChild(fPPCOD.getComponent());
			
		rowFields = rowsFields.newRow();
			
			Label lblRXOI = new Label("Final   O.I.");
			rowFields.appendCellChild(lblRXOI.rightAlign());
			
			fEsferaOI = new WStringEditor(); 
			fEsferaOI.getComponent().setWidth("100%");
			rowFields.appendCellChild(fEsferaOI.getComponent());
			
			fCilindroOI = new WStringEditor(); 
			fCilindroOI.getComponent().setWidth("100%");
			rowFields.appendCellChild(fCilindroOI.getComponent());
			
			fEjeOI = new WStringEditor(); 
			fEjeOI.getComponent().setWidth("100%");
			rowFields.appendCellChild(fEjeOI.getComponent());
			
			fPrismaOI = new WStringEditor(); 
			fPrismaOI.getComponent().setWidth("100%");
			rowFields.appendCellChild(fPrismaOI.getComponent());
			
			fBaseOI = new WStringEditor(); 
			fBaseOI.getComponent().setWidth("100%");
			rowFields.appendCellChild(fBaseOI.getComponent());
			
			fAVOI = new WStringEditor(); 
			fAVOI.getComponent().setWidth("100%");
			rowFields.appendCellChild(fAVOI.getComponent());
			
			fADDOI = new WStringEditor(); 
			fADDOI.getComponent().setWidth("100%");
			rowFields.appendCellChild(fADDOI.getComponent());
			
			fDPOI = new WStringEditor(); 
			fDPOI.getComponent().setWidth("100%");
			rowFields.appendCellChild(fDPOI.getComponent());
			
			fPPCOI = new WStringEditor(); 
			fPPCOI.getComponent().setWidth("100%");
			rowFields.appendCellChild(fPPCOI.getComponent());
			
		rowFields = rowsFields.newRow();
			rowFields.appendCellChild(new Space());
		rowFields = rowsFields.newRow();
			
			Label lblTra = new Label ("Tratamiento");
			fTratamiento = new WStringEditor(); 
			fTratamiento.getComponent().setMultiline(true);
			fTratamiento.getComponent().setWidth("100%");
			rowFields.appendCellChild(lblTra.rightAlign());
			rowFields.appendCellChild(fTratamiento.getComponent(), 9);
			
		rowFields = rowsFields.newRow(); 
		
			Label lblResp = new Label ("Responsable");
			fResp = new WStringEditor(); 
			fResp.getComponent().setMultiline(true);
			fResp.getComponent().setWidth("100%");
			rowFields.appendCellChild(lblResp.rightAlign());
			rowFields.appendCellChild(fResp.getComponent(), 9);
		
		
		return gridFields;
		
	}	
	
	private Component getPanelWest() throws Exception {
		
		Borderlayout borderLayout = new Borderlayout();
		North north = new North();
		borderLayout.appendChild(north);
		
		Vlayout  vLayout = new Vlayout();
		north.appendChild(vLayout);
		
		Grid grid = GridFactory.newGridLayout();
		vLayout.appendChild(grid);
		Rows rows = grid.newRows(); 
		Row row = rows.newRow();
		Label lblPartner = new Label(Msg.translate(ctx, "C_BPartner_ID"));
		
		Div divBPartner = new Div();
		MLookup lookupBPartner = MLookupFactory.get(Env.getCtx(), 0, 200991, DisplayType.TableDir,
				Env.getLanguage(Env.getCtx()), MBPartner.COLUMNNAME_C_BPartner_ID, 0, false, "");
		fBPartner = new WSearchEditor(MBPartner.COLUMNNAME_C_BPartner_ID, false,false,true, lookupBPartner);
		
		WEditorPopupMenu popupMenu = fBPartner.getPopupMenu();
		if (popupMenu != null){
			popupMenu.addMenuListener((ContextMenuListener)fBPartner);
			popupMenu.setId(fBPartner.getColumnName()+"-popup");
			divBPartner.appendChild(popupMenu);
			Label label = fBPartner.getLabel();
			label.addEventListener(Events.ON_CLICK, new ZoomListener((IZoomableEditor) fBPartner));
			popupMenu.addContextElement(label);
			popupMenu.addContextElement((XulElement) fBPartner.getComponent());
   				        				
		}
		divBPartner.appendChild(fBPartner.getComponent());	
		
		
		row.appendCellChild(lblPartner);
		row = rows.newRow();
		row.appendCellChild(divBPartner);
		rows.appendChild(row);
		
		row = rows.newRow();
		Label lblDescription = new Label(Msg.translate(ctx, "Description"));
	    fDescription = new WStringEditor();
		row.appendCellChild(lblDescription);
		row = rows.newRow();
		fDescription.getComponent().setWidth("100%");
		row.appendCellChild(fDescription.getComponent());
		
		row = rows.newRow();
		Label lblDate = new Label(Msg.getMsg(ctx, "Date"));
		row.appendCellChild(lblDate);
		row = rows.newRow();
		fDate = new WDateEditor();
		row.appendCellChild(fDate.getComponent());
		
		row = rows.newRow();
		btnAdd = new Button();
		btnAdd.setImage(ThemeManager.getThemeResource("images/New16.png"));
		btnAdd.setTooltiptext(Util.cleanAmp(Msg.getMsg(ctx, "Add")));
		row.appendChild(btnAdd);
		
		btnDelete =  new Button();
		btnDelete.setImage(ThemeManager.getThemeResource("images/Delete16.png"));
		btnDelete.setTooltiptext(Util.cleanAmp(Msg.getMsg(ctx, "Delete")));
		Div divButton = new Div();
		divButton.appendChild(btnAdd);
		divButton.appendChild(btnDelete);
		row.appendChild(divButton); 
		
		Center center = new Center();
		borderLayout.appendChild(center);
		
		lstControl = ListboxFactory.newDataTableAutoSize(); 
		lstControl.addColumn(IDColumn.class, false, "");
		lstControl.addColumn(Timestamp.class, true, Msg.translate(ctx, "Date1"));
		lstControl.addColumn(String.class, true, Msg.translate(ctx, "Description"));
		lstControl.repaint();
		center.appendChild(lstControl);
		
		fBPartner.addValueChangeListener(this);
		btnAdd.addEventListener(Events.ON_CLICK, this);
		btnDelete.addEventListener(Events.ON_CLICK, this);
		return borderLayout;
	}
	
	static class ZoomListener implements EventListener<Event> {

		private IZoomableEditor searchEditor;

		ZoomListener(IZoomableEditor editor) {
			searchEditor = editor;
		}

		public void onEvent(Event event) throws Exception {
			if (Events.ON_CLICK.equals(event.getName())) {
				searchEditor.actionZoom();
			}
		}
	}

	@Override
	public ADForm getForm() {
		return form;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onEvent(Event event) throws Exception {
		if (event.getTarget().equals(btnSave)){
			saveOpticalRecord();
		}else if (event.getTarget().equals(lstControl)){
			Listbox listbox = (Listbox)event.getTarget();	
			X_COMUS_OpticalRecord_ID =  (int) ((Vector<Object>)listbox.getListModel().getElementAt(listbox.getSelectedIndex())).get(3);
			loadOpticalRecord(X_COMUS_OpticalRecord_ID);
		}else if (event.getTarget().equals(btnAdd)){
			X_COMUS_OpticalRecord_ID = 0; 
			clearAll();
			if(fDate.getValue()==null)
				throw new AdempiereException("Ingrese una fecha");
			if(fBPartner.getValue()==null)
				throw new AdempiereException("Ingrese un tercero");
			if(fDescription.getValue()==null || "".equals(fDescription.getValue()))
				throw new AdempiereException("Ingrese una Descripción");
			fDateTrx.setValue(fDate.getValue());
			
		}else if (event.getTarget().equals(btnDelete)){
			deleteOpticalRecord();
		}
			
			
		
	}
	
	private void deleteOpticalRecord() {
		int select = 0;
		for (Vector<Object> line : linesOpticalRecord) {
			Integer ID = (Integer) line.get(3);
			if (line.get(0).equals(Boolean.TRUE)) {
				select++;
				X_COMUS_OpticalRecord opticalRecord = new X_COMUS_OpticalRecord(ctx, ID, null);
				opticalRecord.deleteEx(true);
			}
		}
		if (select!=0)
			loadLstOpticalRecord((int) fBPartner.getValue());
		clearAll();
		
	}

	private void clearAll() {
		fOD.setValue("");
		fOI.setValue("");
		
		fVCLOD.setValue("");
		fVCLOI.setValue("");
		
		fPĥysicalExam.setValue("");
		
		fOtalOD.setValue("");
		fOtalOI.setValue("");
		
		fRetiOD.setValue("");
		fRetiOI.setValue("");
		fARKOD.setValue("");
		fARKOI.setValue("");
		
		fEsferaOD.setValue("");
		fEsferaOI.setValue("");
		
		fCilindroOD.setValue("");
		fCilindroOI.setValue("");
		
		fEjeOD.setValue("");
		fEjeOI.setValue("");
		
		fPrismaOD.setValue("");
		fPrismaOI.setValue("");
		
		fBaseOD.setValue("");
		fBaseOI.setValue("");
		
		fAVOD.setValue("");
		fAVOD.setValue("");
		
		fADDOD.setValue("");
		fADDOI.setValue("");
		
		fDPOD.setValue("");
		fDPOI.setValue("");
		
		fPPCOD.setValue("");
		fPPCOI.setValue("");
	}
	private void loadOpticalRecord(int X_COMUS_OpticalRecord_ID) {
		
			X_COMUS_OpticalRecord opticalRecord = new X_COMUS_OpticalRecord(ctx, X_COMUS_OpticalRecord_ID, null);
			
			fDate.setValue(opticalRecord.getDateTrx());
			fDateTrx.setValue(opticalRecord.getDateTrx());
			fDescription.setValue(opticalRecord.getDescription());
			
			fOD.setValue(opticalRecord.getoptdato1());
			fOI.setValue(opticalRecord.getoptdato2());
			
			fVCLOD.setValue(opticalRecord.getoptdato3());
			fVCLOI.setValue(opticalRecord.getoptdato4());
			
			fPĥysicalExam.setValue(opticalRecord.getoptdato9());
			
			fOtalOD.setValue(opticalRecord.getoptdato12());
			fOtalOI.setValue(opticalRecord.getoptdato13());
			
			fRetiOD.setValue(opticalRecord.getoptdato14());
			fRetiOI.setValue(opticalRecord.getoptdato15());
			fARKOD.setValue(opticalRecord.getoptdato16());
			fARKOI.setValue(opticalRecord.getoptdato17());
			
			fEsferaOD.setValue(opticalRecord.getoptdato18());
			fEsferaOI.setValue(opticalRecord.getoptdato19());
			
			fCilindroOD.setValue(opticalRecord.getoptdato20());
			fCilindroOI.setValue(opticalRecord.getoptdato21());
			
			fEjeOD.setValue(opticalRecord.getoptdato22());
			fEjeOI.setValue(opticalRecord.getoptdato23());
			
			fPrismaOD.setValue(opticalRecord.getoptdato24());
			fPrismaOI.setValue(opticalRecord.getoptdato25());
			
			fBaseOD.setValue(opticalRecord.getoptdato26());
			fBaseOI.setValue(opticalRecord.getoptdato27());
			
			fAVOD.setValue(opticalRecord.getoptdato28());
			fAVOD.setValue(opticalRecord.getoptdato29());
			
			fADDOD.setValue(opticalRecord.getoptdato30());
			fADDOI.setValue(opticalRecord.getoptdato31());
			
			fDPOD.setValue(opticalRecord.getoptdato32());
			fDPOI.setValue(opticalRecord.getoptdato33());
			
			fPPCOD.setValue(opticalRecord.getoptdato34());
			fPPCOI.setValue(opticalRecord.getoptdato35());
								
		
	}

	private void saveOpticalRecord() {
		X_COMUS_OpticalRecord opticalRecord = new X_COMUS_OpticalRecord(ctx, X_COMUS_OpticalRecord_ID, null);
		opticalRecord.setC_BPartner_ID((int) fBPartner.getValue());
		opticalRecord.setDateTrx((Timestamp) fDateTrx.getValue());
		opticalRecord.setDescription((String) fDescription.getValue());
		
		opticalRecord.setoptdato1((String) fOD.getValue());
		opticalRecord.setoptdato2((String) fOI.getValue());
		
		opticalRecord.setoptdato3((String) fVCLOD.getValue());
		opticalRecord.setoptdato4((String) fVCLOI.getValue());
		
		opticalRecord.setoptdato5("-");
		opticalRecord.setoptdato6("-");
		opticalRecord.setoptdato7("-");
		opticalRecord.setoptdato8("-");
		
		opticalRecord.setoptdato9((String) fPĥysicalExam.getValue());
		
		opticalRecord.setoptdato10("-");
		opticalRecord.setoptdato11("-");
		
		opticalRecord.setoptdato12((String) fOtalOD.getValue());
		opticalRecord.setoptdato13((String) fOtalOI.getValue());
		
		opticalRecord.setoptdato14((String) fRetiOD.getValue());
		opticalRecord.setoptdato15((String) fRetiOI.getValue());
		opticalRecord.setoptdato16((String) fARKOD.getValue());
		opticalRecord.setoptdato17((String) fARKOI.getValue());
		
		opticalRecord.setoptdato18((String) fEsferaOD.getValue());
		opticalRecord.setoptdato19((String) fEsferaOI.getValue());
		
		opticalRecord.setoptdato20((String) fCilindroOD.getValue());
		opticalRecord.setoptdato21((String) fCilindroOI.getValue());
		
		opticalRecord.setoptdato22((String) fEjeOD.getValue());
		opticalRecord.setoptdato23((String) fEjeOI.getValue());
		
		opticalRecord.setoptdato24((String) fPrismaOD.getValue());
		opticalRecord.setoptdato25((String) fPrismaOI.getValue());
		
		opticalRecord.setoptdato26((String) fBaseOD.getValue());
		opticalRecord.setoptdato27((String) fBaseOI.getValue());
		
		opticalRecord.setoptdato28((String) fAVOD.getValue());
		opticalRecord.setoptdato29((String) fAVOI.getValue());
		
		opticalRecord.setoptdato30((String) fADDOD.getValue());
		opticalRecord.setoptdato31((String) fADDOI.getValue());
		
		opticalRecord.setoptdato32((String) fDPOD.getValue());
		opticalRecord.setoptdato33((String) fDPOI.getValue());
		
		opticalRecord.setoptdato34((String) fPPCOD.getValue());
		opticalRecord.setoptdato35((String) fPPCOI.getValue());
		
		opticalRecord.setoptdato36("-");
		opticalRecord.setoptdato37("-");
		opticalRecord.setoptdato38("-");
		opticalRecord.setoptdato39("-");
		opticalRecord.setoptdato40("-");
		opticalRecord.setoptedad("-");
		opticalRecord.setunico("-");
		
		opticalRecord.setoptsec("-");
		opticalRecord.setcodcli("-");
		opticalRecord.saveEx();
		
		X_COMUS_OpticalRecord_ID = opticalRecord.get_ID();
		loadLstOpticalRecord(opticalRecord.getC_BPartner_ID());
				
	}

	@Override
	public void valueChange(ValueChangeEvent evt) {
		if (evt.getSource().equals(fBPartner)) {
			bpartnerListener.setBPartnerID((Integer)evt.getNewValue());
			if (evt.getNewValue()!=null) {
				int C_BPartner_ID = (int) evt.getNewValue();
				
				loadLstOpticalRecord(C_BPartner_ID);	
			}
		}
		
	}

	private void loadLstOpticalRecord(int C_BPartner_ID) {
		
		List<X_COMUS_OpticalRecord> lstOpticalRecord = new Query(Env.getCtx(), X_COMUS_OpticalRecord.Table_Name, 
				"C_BPartner_ID = ?", null).setParameters(C_BPartner_ID).setOnlyActiveRecords(true).list();
		linesOpticalRecord = new Vector<Vector<Object>>();

		
		for (X_COMUS_OpticalRecord opticalRecord : lstOpticalRecord) {
			  Vector<Object> line = new Vector<Object>();
			  line.add(false);
			  line.add(opticalRecord.getDateTrx());
		      line.add(opticalRecord.getDescription());
		      line.add(opticalRecord.get_ID());
		      linesOpticalRecord.add(line);

		}
        				
		ListModelTable tableModel = new ListModelTable(linesOpticalRecord);

		lstControl.setModel(tableModel);
		lstControl.addEventListener(Events.ON_CLICK, this);
		lstControl.repaint();
		
	}
}
