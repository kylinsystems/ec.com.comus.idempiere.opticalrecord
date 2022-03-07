package ec.com.comus.form;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import org.adempiere.exceptions.AdempiereException;
import org.adempiere.webui.component.Datebox;
import org.adempiere.webui.component.Grid;
import org.adempiere.webui.component.GridFactory;
import org.adempiere.webui.component.Label;
import org.adempiere.webui.component.Row;
import org.adempiere.webui.component.Rows;
import org.adempiere.webui.component.Textbox;
import org.adempiere.webui.editor.IZoomableEditor;
import org.adempiere.webui.editor.WEditorPopupMenu;
import org.adempiere.webui.editor.WSearchEditor;
import org.adempiere.webui.event.ContextMenuListener;
import org.adempiere.webui.event.ValueChangeEvent;
import org.adempiere.webui.event.ValueChangeListener;
import org.adempiere.webui.event.WTableModelEvent;
import org.adempiere.webui.event.WTableModelListener;
import org.adempiere.webui.panel.ADForm;
import org.adempiere.webui.panel.CustomForm;
import org.adempiere.webui.panel.IFormController;
import org.adempiere.webui.theme.ThemeManager;
import org.adempiere.webui.window.FDialog;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.comparator.NameFileComparator;
import org.compiere.model.MBPartner;
import org.compiere.model.MLookup;
import org.compiere.model.MLookupFactory;
import org.compiere.model.MSysConfig;
import org.compiere.util.DisplayType;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.compiere.util.Util;
import org.jfree.chart.encoders.EncoderUtil;
import org.jfree.chart.encoders.ImageFormat;
import org.zkoss.image.AImage;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Components;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Button;
import org.zkoss.zul.Center;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Fileupload;
import org.zkoss.zul.Hlayout;
import org.zkoss.zul.Html;
import org.zkoss.zul.Image;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listhead;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Menuitem;
import org.zkoss.zul.Menupopup;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.North;
import org.zkoss.zul.South;
import org.zkoss.zul.West;
import org.zkoss.zul.event.ListDataEvent;
import org.zkoss.zul.event.ListDataListener;
import org.zkoss.zul.impl.XulElement;

import ec.com.comus.util.ZoomListener;




public class WStoreImage implements IFormController, ChangeBPartnerListener,EventListener<Event>, WTableModelListener, ValueChangeListener, ListDataListener{

	private CustomForm form = new CustomForm();
	private WSearchEditor bpartnerSearch;
	private Properties ctx;
	private Hlayout vlayoutImage;
	private File storeDir;
	private Button btnFiles;
	private Hlayout vLayout;
	private Image imagePrinc;
	private Listbox tblDate;
	private Vector<Vector<Object>> linesDataTable;
	private South south;
	private File folderPartner;
	private Button btnAdd;
	private Datebox fDate;
	private Button btnDelete;
	private Button btnEdit;
	protected String imageActual;
	private Button btnRefresh;
	private Label lblInfo;
	private String dir;
	private Textbox fDescriptionImagen = new Textbox();
	
	public WStoreImage(){
		ctx = Env.getCtx();

		String  dir = MSysConfig.getValue("COMUS_StoreImage_Dir", "/tmp", Env.getAD_Client_ID(Env.getCtx()), Env.getAD_Org_ID(Env.getCtx()));
		if (dir==null){
			FDialog.error(form.getWindowNo(),"El Configurador del Sistema COMUS_StoreImage_Dir no esta definido");
			return;
		}
		storeDir = new File(dir);
		if (!storeDir.exists())
		   if(!storeDir.mkdir())
			   throw new AdempiereException("No se pudo crear directorio: "+ storeDir);
		
		initValue();
		zkInit();
		bpartnerSearch.setReadWrite(false);
		
	}

	public WStoreImage(MBPartner mBPartner) {
		this();
		bpartnerSearch.setValue(mBPartner.get_ID());
		bpartnerSearch.setReadWrite(false);
		loadDateFolders();
		
	}

	public void zkInit(){
		Borderlayout mainLayout = new Borderlayout();
		form.appendChild(mainLayout);
		
		btnFiles = new Button("Upload");
		btnFiles.setUpload("true,maxsize=300");
		
		Fileupload fileUpload = new Fileupload("upload");
		
		West west = new West();
		west.setSplittable(true);
		west.setWidth("20%");
		mainLayout.appendChild(west);
			Borderlayout layoutWest = new Borderlayout();
			
			west.appendChild(layoutWest);
			
			North northW = new North();
			
			layoutWest.appendChild(northW);
						
			Grid gridWestN = GridFactory.newGridLayout();
			gridWestN.setStyle("border: none;");
			northW.appendChild(gridWestN);
			Rows rowsGridWestN = gridWestN.newRows();
			
			Row rowGridWestN = rowsGridWestN.newRow();
			Div divBPartner = new Div();
			

			Label lblPartner = new Label(Msg.translate(ctx, "C_BPartner_ID"));
			MLookup lookupBP = MLookupFactory.get(ctx, form.getWindowNo(), 0, 5433, DisplayType.Search);
			bpartnerSearch = new WSearchEditor("C_BPartner_ID", true, false, true, lookupBP);
			WEditorPopupMenu popupMenu = bpartnerSearch.getPopupMenu();
			if (popupMenu != null){
				popupMenu.addMenuListener((ContextMenuListener)bpartnerSearch);
				popupMenu.setId(bpartnerSearch.getColumnName()+"-popup");
				divBPartner.appendChild(popupMenu);
				Label label = bpartnerSearch.getLabel();
				label.addEventListener(Events.ON_CLICK, new ZoomListener((IZoomableEditor) bpartnerSearch));
				popupMenu.addContextElement(label);
				popupMenu.addContextElement((XulElement) bpartnerSearch.getComponent());
	   				        				
			}
			
			
			divBPartner.appendChild(bpartnerSearch.getComponent());	
			rowGridWestN.appendCellChild(lblPartner);
			rowGridWestN = rowsGridWestN.newRow();
			rowGridWestN.appendCellChild(divBPartner);
			
			
			
			rowGridWestN = rowsGridWestN.newRow();
			Label lblDescription = new Label(Msg.translate(ctx, "Description"));
			rowGridWestN.appendCellChild(lblDescription);
			
			rowGridWestN = rowsGridWestN.newRow();
			fDescriptionImagen.setWidth("100%");
			fDescriptionImagen.setReadonly(true);
			rowGridWestN.appendCellChild(fDescriptionImagen);
			
			rowGridWestN = rowsGridWestN.newRow();
			Label lblDate = new Label(Msg.getMsg(ctx, "Date"));
			rowGridWestN.appendCellChild(lblDate);
			
			rowGridWestN = rowsGridWestN.newRow();
			fDate = new Datebox();
			fDate.setReadonly(true);
			rowGridWestN.appendCellChild(fDate);
			
			rowGridWestN = rowsGridWestN.newRow();
			btnAdd = new Button();
			btnAdd.setImage(ThemeManager.getThemeResource("images/New16.png"));
			btnAdd.setTooltiptext(Util.cleanAmp(Msg.getMsg(ctx, "Add")));
//			rowGridWestN.appendChild(btnAdd);
			
			btnDelete =  new Button();
			btnDelete.setImage(ThemeManager.getThemeResource("images/Delete16.png"));
			btnDelete.setTooltiptext(Util.cleanAmp(Msg.getMsg(ctx, "Delete")));
			Div divButton = new Div();
			divButton.appendChild(btnAdd);
			divButton.appendChild(btnDelete);
			rowGridWestN.appendChild(divButton); 
			
			Center centerW = new Center();
			layoutWest.appendChild(centerW);
			centerW.appendChild(tblDate);
			
		Center center = new Center();
		mainLayout.appendChild(center);
		
		Borderlayout layoutCenter = new Borderlayout();
		center.appendChild(layoutCenter);
			
			North north = new North();
			north.setHeight("20%");
			layoutCenter.appendChild(north);
			
			Grid gridNorthC = GridFactory.newGridLayout();
			gridNorthC.setStyle("border: none;");
			north.appendChild(gridNorthC);
			Rows rowsNorthC = gridNorthC.newRows();
			
			Row rowNorthC = rowsNorthC.newRow();
			Div div =  new Div();
			btnEdit = new Button();
			btnEdit.setImage(ThemeManager.getThemeResource("images/Wizard24.png"));
			btnEdit.setTooltiptext("Editar Imagen");
			
			btnRefresh = new Button();
			btnRefresh.setImage(ThemeManager.getThemeResource("images/Refresh24.png"));
			btnRefresh.setTooltiptext("Refrescar Imagen");
//			div.appendChild(btnEdit);
			div.appendChild(btnRefresh);
			//div.setStyle("float: right");
			rowNorthC.appendCellChild(div);
			
			rowNorthC = rowsNorthC.newRow();
			lblInfo = new Label("");
			rowNorthC.appendCellChild(lblInfo);
			
			Center cCenter = new Center();
			layoutCenter.appendChild(cCenter);
		
			vLayout = new Hlayout();
			vLayout.setHeight("100%");
			vLayout.setWidth("100%");
			vLayout.setStyle("overflow:auto;");
			vLayout.setSclass("z-halign-middle");
			imagePrinc = new org.zkoss.zul.Image();
			vLayout.appendChild(imagePrinc);
			cCenter.appendChild(vLayout);
		
			south = new South();
			vlayoutImage = new Hlayout();
			vlayoutImage.setHeight("160px");
			vlayoutImage.setStyle("overflow:auto");
			south.appendChild(vlayoutImage);
			south.setHeight("18%");
			layoutCenter.appendChild(south);
		
		btnFiles.addEventListener(Events.ON_UPLOAD, this);
		fileUpload.addEventListener(Events.ON_UPLOAD, this);
		bpartnerSearch.addValueChangeListener(this);
		btnAdd.addEventListener(Events.ON_CLICK, this);
		btnDelete.addEventListener(Events.ON_CLICK, this);
		btnEdit.addEventListener(Events.ON_CLICK, this);
		btnRefresh.addEventListener(Events.ON_CLICK, this);
	}
	
	public void loadDateFolders(){
		
		if (bpartnerSearch.getValue()==null)
			return;
		
		String dirPartner = storeDir.getAbsolutePath()+"/"+bpartnerSearch.getValue();
		folderPartner  = new File(dirPartner);
		if (!folderPartner.exists())
			folderPartner.mkdir();
		
		linesDataTable  = new Vector<Vector<Object>>();
		File[] listOfFiles = folderPartner.listFiles(); 
		 Arrays.sort(listOfFiles, NameFileComparator.NAME_COMPARATOR);
		if(listOfFiles == null)
			throw new AdempiereException("No existe folder, crearlo primero");
		for (int i = 0; i < listOfFiles.length; i++){
			File file = listOfFiles[i];
		    if (file.isDirectory()){
		        Vector<Object> line = new Vector<Object>();
		        linesDataTable.add(line);
		        line.add(file.getName());
		        line.add(file.getAbsolutePath());
		    }
		}
		ListModelList<Vector<Object>> list = new ListModelList<Vector<Object>>(linesDataTable, true); // if live is set to true the data list will also be modified
		
		tblDate.setModel(list);
		tblDate.addEventListener(Events.ON_CLICK, this);
		list.addListDataListener(this);
	}
	private void initValue(){

		tblDate = new Listbox();
		tblDate.setWidth("100%");
		tblDate.setMold("paging");
	//	tblDate.setHeight("50%");
		//tblDate.setAutopaging(true);
		
		tblDate.setPagingPosition("top");
		tblDate.setPageSize(10);
		Listhead head = new Listhead();
		head.appendChild(new Listheader());
		head.appendChild(new Listheader(Msg.translate(ctx, "Date")));
		head.appendChild(new Listheader(""));
		head.setParent(tblDate);
		
		tblDate.setItemRenderer(new ListitemRenderer<Object>() {

			@Override
			public void render(Listitem item, Object data, int index) throws Exception {
				@SuppressWarnings("unchecked")
				Vector<Object> line = (Vector<Object>) data;
				Checkbox checkBox = new Checkbox();
				Listcell lstCellCB = new Listcell();
				lstCellCB.setParent(item);
				checkBox.setParent(lstCellCB);
				
				new Listcell((String)line.get(0)).setParent(item);
				
				Listcell listcell = new Listcell();
				listcell.setParent(item);
				listcell.setStyle("text-align:center");
			    Button button = new Button();
			    //fercho button.setUpload("true,maxsize=8000,multiple=true,");
			    button.setUpload("true,maxsize=20000,multiple=true,");
			    button.setImage(ThemeManager.getThemeResource("images/Attachment16.png"));
			    button.setAttribute("folderSave", line.get(1));
			    button.addEventListener(Events.ON_UPLOAD, new EventListener<Event>() {

					@Override
					public void onEvent(Event event) throws Exception {
						UploadEvent uploadEvent = (UploadEvent)event;
			            Media[] medias = uploadEvent.getMedias();
			            Button button = (Button)event.getTarget();
			           
			            for (int i = 0; i < medias.length; i++) {
							Media media = medias[i];
							 String mediaName = media.getName().replace(".png", "").replace(".PNG", "").replace(".jpg", "").replace(".JPG", "")
				    					.replace(".jpeg", "").replace(".JPEG", "").replace(".gif", "").replace(".GIF", "");
							 String FILE_NAME = button.getAttribute("folderSave")+"/"+mediaName;
							if(media.getContentType().contains("image")) {
					            BufferedImage bimage = ImageIO.read(media.getStreamData());
					                       
					            int widthNew = bimage.getWidth()/4;
							    int heightNew = bimage.getHeight()/4;
							   
							    if (heightNew<600){
							    	   widthNew = bimage.getWidth();
									   heightNew = bimage.getHeight();
							    }
							    
							   
								File fileDest = new File(FILE_NAME);
					    		resizeImagen(bimage,fileDest ,widthNew,heightNew,media.getFormat());
					    		compressionImages(fileDest);
					    								 
					    		//Para previa
					    	    File compressedImageFile = new File(FILE_NAME+".prev");
					    		resizeImagen(bimage, compressedImageFile,50,50);   
					    		
							}else {
								InputStream in =media.getStreamData();
								Files.copy(in, Paths.get(FILE_NAME), StandardCopyOption.REPLACE_EXISTING);

				            }
			            }
			            
			            readImages(button.getAttribute("folderSave")+"");		
			            	
					}
				});
			    button.setParent(listcell);
			}
		});
	}
	
	private void resizeImagen (BufferedImage bimage, File fileDestinity, int width,int heigth,String format){
		  try {
			     int w = bimage.getWidth();
			     int h = bimage.getHeight();
			     BufferedImage bufim = new BufferedImage(width, heigth, bimage.getType());
			     Graphics2D g = bufim.createGraphics();
			     g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			     g.drawImage(bimage, 0, 0, width, heigth, 0, 0, w, h, null);
			     if(ImageFormat.JPEG.equals(format))
			    	 ImageIO.write(bufim, ImageFormat.JPEG, fileDestinity);
			     else if(ImageFormat.GIF.equals(format))
			    	 ImageIO.write(bufim, ImageFormat.GIF, fileDestinity);
			     else
			    	 ImageIO.write(bufim, ImageFormat.PNG, fileDestinity);
			} catch (IOException e) {
				e.printStackTrace();
			}

	}
	public void resizeImagen (BufferedImage bimage, File fileDestinity, int width,int heigth){
	   resizeImagen(bimage, fileDestinity, width, heigth, null);
	}
	
	private void compressionImages(File input){

		try {
	      BufferedImage image = ImageIO.read(input);

	      File compressedImageFile = new File("compress.jpg");  
	      OutputStream os = new FileOutputStream(compressedImageFile);

	      Iterator<ImageWriter>writers = ImageIO.getImageWritersByFormatName("jpg");
	      ImageWriter writer = (ImageWriter) writers.next();

	      ImageOutputStream ios = ImageIO.createImageOutputStream(os);
	      writer.setOutput(ios);

	      ImageWriteParam param = writer.getDefaultWriteParam();
	      // Check if canWriteCompressed is true
	      if(param.canWriteCompressed()) {
	         param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
	         param.setCompressionQuality(0.05f);
	      }
	      // End of check
	      writer.write(null, new IIOImage(image, null, null), param);
	      
	      os.close();
	      ios.close();
	      writer.dispose();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void readImages(String dir){
	   this.dir = dir;
	   File dirSelected = new File(dir);
	   File[] listOfFiles = dirSelected.listFiles();
	   vlayoutImage = new Hlayout();
	   vlayoutImage.setHeight("120px");
	   vlayoutImage.setStyle("overflow:auto");
	   String filePrev;
	   Arrays.sort(listOfFiles, NameFileComparator.NAME_COMPARATOR);
	   System.out.println(NameFileComparator.NAME_COMPARATOR);
	   for (int i = 0; i < listOfFiles.length; i++)         {
	       filePrev = listOfFiles[i].getAbsolutePath();
  		   final String dirParent = dir;
  		  
  		   if (!filePrev.endsWith(".prev") && !filePrev.endsWith(".mp4"))
  			   continue;
  		   
	  		   String realImage = filePrev.replaceAll(".prev", "");
	  		   	BufferedImage img = null;
		     	byte[] bytes;
		       		AImage image = null;
		       		try {
		       			final Image image1 = new Image();
		       			String FileType = "";
		       			if (filePrev.endsWith(".prev")) {
		       				img = ImageIO.read(new File(filePrev));
		       				FileType = "image";
		       			}else {
		       				//img = ImageIO.read(getClass().getResource("/images/video.png"));
		       				img = ImageIO.read(getClass().getResource(filePrev));
		       				FileType = "video";
		       			}
		       			bytes = EncoderUtil.encode(img, ImageFormat.PNG, true);
		
		       			image = new AImage("", bytes);
		       		
		       			image1.setContent(image);
		       			image1.setWidth("80px");
		              	image1.setSclass("icon");
		       			image1.setTooltiptext("Right click to show menu");
		       			image1.setContext("editPopup");
		       			image1.setAttribute("realImage", realImage);
		       			image1.setAttribute("FileType", FileType);
		       			image1.addEventListener("onMouseOver", new EventListener<Event>() {
			       		     public void onEvent(Event e) {
			       		       image1.setHeight("100px");
			       		       image1.setWidth("100px");
			       		     }
			       		  });
		
		       			image1.addEventListener("onMouseOut", new EventListener<Event>() {
			       		    public void onEvent(Event e) {
			       		      image1.setHeight("80px");
			       		      image1.setWidth("80px");
			       		   }
		       		  });
		       			image1.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
			       		    private byte[] bytes2;
	
							public void onEvent(Event e) {
								Image img = (org.zkoss.zul.Image) e.getTarget();
								imageActual = img.getAttribute("realImage").toString();	
								String fileType = img.getAttribute("FileType").toString();
			       		    	
			       		    	if (fileType.equals("image")) {
				       		    	BufferedImage buffredImg;
									try {
										buffredImg = ImageIO.read(new File(imageActual));
						       			bytes2 = EncoderUtil.encode(buffredImg, ImageFormat.PNG, true);
						       			AImage image2 = new AImage("", bytes2);
						       			imagePrinc = new org.zkoss.zul.Image();
						       			Components.removeAllChildren(vLayout);
						       			vLayout.appendChild(imagePrinc);
						       			
						       			imagePrinc.setContent(image2);
									} catch (IOException e1) {
										e1.printStackTrace();
									}
			       		    	}else if (fileType.equals("video")) {
			       		    		Components.removeAllChildren(vLayout);
			       		    		Html html = new Html();
			       		    		vLayout.appendChild(html);
			       		    		File fImageActual = new File(imageActual); 
			       		    		String urlFile = fImageActual.getAbsolutePath().replace(storeDir.getAbsolutePath(), "");
				       		 		String content = "<div align=\"center\">\n" + 
				       		 				"<embed src=\"http://0.0.0.0:8000"+urlFile+"\" width=\"700\" height=\"400\">\n" + 
				       		 				"</div>";
				       		 		html.setContent(content);
			       		 		
			       		    	}
	
			       		    	
				       		 }
			       		  });
		       			
		       			Menupopup popup = new Menupopup();
		       			Menuitem m_delete = new Menuitem(Msg.translate(Env.getCtx(), "delete"));
		       			popup.appendChild(m_delete);
		       			m_delete.setAttribute("dir", filePrev);
		       			m_delete.setAttribute("dirReal", realImage);
	
		    			m_delete.addEventListener(Events.ON_CLICK, new EventListener<Event>(){
		    				public void onEvent(Event event) throws Exception{
		    					Menuitem menuitem = (Menuitem)event.getTarget();
		    					File img = new File(menuitem.getAttribute("dir")+"");
		    					if (!img.delete())
		    						   System.out.println("La imagen no puede ser borrada");
		    					
		    					File img2 = new File(menuitem.getAttribute("dirReal")+"");
		    					if (!img2.delete())
		    						   System.out.println("La imagen no puede ser borrada");
		    					readImages(dirParent);
		    				}
		    			});
		    			popup.setParent(vlayoutImage);
		       			image1.setContext(popup);
		       			Div divImage = new Div();
		       			divImage.appendChild(image1);
		       			divImage.appendChild(popup);
		       			vlayoutImage.appendChild(divImage);
		       			
		       		} catch (IOException e) {
		       			e.printStackTrace();
		       		}       	   
          
	    }
	   south.removeChild(south.getFirstChild());
	   south.appendChild(vlayoutImage);
	}
	@Override
	public ADForm getForm() {
		return form;
	}

	@Override
	public void onEvent(Event event) throws Exception {
				
		if (event.getTarget().equals(btnAdd)){
			if (bpartnerSearch.getValue()==null)
				throw new AdempiereException("Seleccione un Tercero");
				
			if (fDate.getValue()==null)
				Messagebox.show("Ingrese una fecha");
			else{
				createImageFolder();
			}
		}else if (event.getTarget().equals(btnDelete)){
				deleteDateFolder();
		}else if (event.getTarget().equals(btnEdit)){
			//new WImageEditor();
			if (imageActual!=null && !"".equals(imageActual)){
//				design.main(imageActual,this);
				lblInfo.setValue("Refrescar imagen despues de Editarla.");
			}else
				lblInfo.setValue("Seleccione una Imagen");
			
		}else if (event.getTarget().equals(btnRefresh)){
			if (imageActual!=null && !"".equals(imageActual)){
				reloadImage(imageActual);
				readImages(dir);
				lblInfo.setValue("");
			}else
				lblInfo.setValue("Seleccione una Imagen");
		}else if (event.getTarget().equals(tblDate)) {
			Listbox listBox = (Listbox) event.getTarget();
			int index = listBox.getSelectedIndex();
			if(index<0)
				index = 0;
			@SuppressWarnings("unchecked")
			Vector<Object> line = (Vector<Object>) tblDate.getModel().getElementAt(index);
			String directory = (String) line.get(1);
			readImages(directory);

			BufferedImage img = new BufferedImage(100, 100,2);
	   		byte[] bytes;
			try {
				bytes = EncoderUtil.encode(img, ImageFormat.PNG, true);
				imagePrinc.setContent( new AImage("", bytes));
				
			} catch (IOException ee) {
				ee.printStackTrace();
			}
			
		}
	}

	private void createImageFolder() {
		String format = "yyyyMMdd";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String time = sdf.format(fDate.getValue().getTime());
		time = time.concat("-").concat(fDescriptionImagen.getValue());
		File newFolder = new File(folderPartner.getAbsolutePath()+"/"+time);
		
		if (newFolder.exists())
			Messagebox.show("Ya existe fecha y nombre del Paciente");
		else{
			newFolder.mkdir();
			loadDateFolders();
		}
		
	}

	public void setLblInfo(String value){
		lblInfo.setValue(value);
	}
	private void deleteDateFolder() {
		
		List<Listitem> items = tblDate.getItems();
		Boolean isDelete = Boolean.FALSE;
		for (Listitem item : items) {
		
			Checkbox checkSelect = (Checkbox)item.getChildren().get(0).getChildren().get(0);
			if (checkSelect.isChecked()){
				
				Listcell lstCellDate =(Listcell)item.getChildren().get(1);
				File folder = new File(folderPartner.getAbsolutePath()+"/"+lstCellDate.getLabel());
				if(folder.exists()){
					try {
						FileUtils.deleteDirectory(folder);
						isDelete = Boolean.TRUE;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		if(isDelete)
			loadDateFolders();
	}

	@Override
	public void tableChanged(WTableModelEvent event) {
	}

	@Override
	public void valueChange(ValueChangeEvent evt) {
		if (evt.getSource().equals(bpartnerSearch)){
			Integer C_BPartner_ID = (Integer)evt.getNewValue();
			loadPartnerFolders(C_BPartner_ID);
		}
	}
	private void loadPartnerFolders(Integer C_BPartner_ID) {
		if (C_BPartner_ID==null)
			C_BPartner_ID = 0;
		String dirPartner = storeDir.getAbsolutePath()+"/"+C_BPartner_ID;
		folderPartner  = new File(dirPartner);
		if (!folderPartner.exists())
			folderPartner.mkdir();
		loadDateFolders();
	}

	@Override
	public void onChange(ListDataEvent event) {

		
		
		
		
		
	}
	
	public  void reloadImage(String imageActual){
		try {
			BufferedImage buffredImg = ImageIO.read(new File(imageActual));
   			byte[] bytes2 = EncoderUtil.encode(buffredImg, ImageFormat.PNG, true);
   			AImage image2 = new AImage("", bytes2);
   			imagePrinc.setContent(image2);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	}

	public WSearchEditor getBpartnerSearch() {
		return bpartnerSearch;
	}

	public void setBpartnerSearch(WSearchEditor bpartnerSearch) {
		this.bpartnerSearch = bpartnerSearch;
	}

	@Override
	public void setBPartnerID(Integer C_BPartner_ID) {
		bpartnerSearch.setValue(C_BPartner_ID);
		loadPartnerFolders(C_BPartner_ID);
		
	}

	@Override
	public void setDate(Date date) {
		fDate.setValue(date);
		
	}

	@Override
	public void setDescription(Object description) {
		fDescriptionImagen.setValue((String) description);
		
	}

	@Override
	public void createNewFolderImages() {
		createImageFolder();
		
	}

	@Override
	public void loadImagesFolder() {
		loadDateFolders();
		readImages("/tmp/");
		
	}
	
	
}