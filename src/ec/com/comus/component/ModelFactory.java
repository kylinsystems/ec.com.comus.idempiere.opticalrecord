package ec.com.comus.component;

import java.sql.ResultSet;

import org.adempiere.base.IModelFactory;
import org.compiere.model.PO;
import org.compiere.util.Env;

import ec.com.comus.model.X_COMUS_OpticalRecord;

public class ModelFactory implements IModelFactory{

	@Override
	public Class<?> getClass(String tableName) {
		if (X_COMUS_OpticalRecord.Table_Name.equals(tableName))
			return X_COMUS_OpticalRecord.class;
		
		
		
		return null;
	}

	@Override
	public PO getPO(String tableName, int Record_ID, String trxName) {
		if (X_COMUS_OpticalRecord.Table_Name.equals(tableName))
			return new X_COMUS_OpticalRecord(Env.getCtx(), Record_ID, trxName);
		
		
		return null;
	}

	@Override
	public PO getPO(String tableName, ResultSet rs, String trxName) {
		if (X_COMUS_OpticalRecord.Table_Name.equals(tableName))
			return new X_COMUS_OpticalRecord(Env.getCtx(), rs, trxName);
		
		
		return null;
	}

}
