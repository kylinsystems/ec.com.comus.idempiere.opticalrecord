package ec.com.comus.util;

import org.adempiere.webui.editor.IZoomableEditor;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;

public class ZoomListener implements EventListener<Event> {

	private IZoomableEditor searchEditor;

	public ZoomListener(IZoomableEditor editor) {
		searchEditor = editor;
	}

	public void onEvent(Event event) throws Exception {
		if (Events.ON_CLICK.equals(event.getName())) {
			searchEditor.actionZoom();
		}
	}
}