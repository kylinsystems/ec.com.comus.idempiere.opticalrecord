/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package ec.com.comus.model;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for COMUS_OpticalRecord
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_COMUS_OpticalRecord extends PO implements I_COMUS_OpticalRecord, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20220218L;

    /** Standard Constructor */
    public X_COMUS_OpticalRecord (Properties ctx, int COMUS_OpticalRecord_ID, String trxName)
    {
      super (ctx, COMUS_OpticalRecord_ID, trxName);
      /** if (COMUS_OpticalRecord_ID == 0)
        {
			setC_BPartner_ID (0);
			setcodcli (null);
			setCOMUS_OpticalRecord_ID (0);
			setDateTrx (new Timestamp( System.currentTimeMillis() ));
			setDescription (null);
			setoptdato1 (null);
			setoptdato10 (null);
			setoptdato11 (null);
			setoptdato12 (null);
			setoptdato13 (null);
			setoptdato14 (null);
			setoptdato15 (null);
			setoptdato16 (null);
			setoptdato17 (null);
			setoptdato18 (null);
			setoptdato19 (null);
			setoptdato2 (null);
			setoptdato20 (null);
			setoptdato21 (null);
			setoptdato22 (null);
			setoptdato23 (null);
			setoptdato24 (null);
			setoptdato25 (null);
			setoptdato26 (null);
			setoptdato27 (null);
			setoptdato28 (null);
			setoptdato29 (null);
			setoptdato3 (null);
			setoptdato30 (null);
			setoptdato31 (null);
			setoptdato32 (null);
			setoptdato33 (null);
			setoptdato34 (null);
			setoptdato35 (null);
			setoptdato36 (null);
			setoptdato37 (null);
			setoptdato38 (null);
			setoptdato39 (null);
			setoptdato4 (null);
			setoptdato40 (null);
			setoptdato5 (null);
			setoptdato6 (null);
			setoptdato7 (null);
			setoptdato8 (null);
			setoptdato9 (null);
			setoptedad (null);
			setoptsec (null);
			setunico (null);
        } */
    }

    /** Load Constructor */
    public X_COMUS_OpticalRecord (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuffer sb = new StringBuffer ("X_COMUS_OpticalRecord[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException
    {
		return (org.compiere.model.I_C_BPartner)MTable.get(getCtx(), org.compiere.model.I_C_BPartner.Table_Name)
			.getPO(getC_BPartner_ID(), get_TrxName());	}

	/** Set Business Partner .
		@param C_BPartner_ID 
		Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

	/** Get Business Partner .
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set codcli.
		@param codcli codcli	  */
	public void setcodcli (String codcli)
	{
		set_Value (COLUMNNAME_codcli, codcli);
	}

	/** Get codcli.
		@return codcli	  */
	public String getcodcli () 
	{
		return (String)get_Value(COLUMNNAME_codcli);
	}

	/** Set COMUS_OpticalRecord_ID.
		@param COMUS_OpticalRecord_ID COMUS_OpticalRecord_ID	  */
	public void setCOMUS_OpticalRecord_ID (int COMUS_OpticalRecord_ID)
	{
		if (COMUS_OpticalRecord_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_COMUS_OpticalRecord_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_COMUS_OpticalRecord_ID, Integer.valueOf(COMUS_OpticalRecord_ID));
	}

	/** Get COMUS_OpticalRecord_ID.
		@return COMUS_OpticalRecord_ID	  */
	public int getCOMUS_OpticalRecord_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_COMUS_OpticalRecord_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set COMUS_OpticalRecord_UU.
		@param COMUS_OpticalRecord_UU COMUS_OpticalRecord_UU	  */
	public void setCOMUS_OpticalRecord_UU (String COMUS_OpticalRecord_UU)
	{
		set_ValueNoCheck (COLUMNNAME_COMUS_OpticalRecord_UU, COMUS_OpticalRecord_UU);
	}

	/** Get COMUS_OpticalRecord_UU.
		@return COMUS_OpticalRecord_UU	  */
	public String getCOMUS_OpticalRecord_UU () 
	{
		return (String)get_Value(COLUMNNAME_COMUS_OpticalRecord_UU);
	}

	/** Set Transaction Date.
		@param DateTrx 
		Transaction Date
	  */
	public void setDateTrx (Timestamp DateTrx)
	{
		set_ValueNoCheck (COLUMNNAME_DateTrx, DateTrx);
	}

	/** Get Transaction Date.
		@return Transaction Date
	  */
	public Timestamp getDateTrx () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateTrx);
	}

	/** Set Description.
		@param Description 
		Optional short description of the record
	  */
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** Set optdato1.
		@param optdato1 optdato1	  */
	public void setoptdato1 (String optdato1)
	{
		set_Value (COLUMNNAME_optdato1, optdato1);
	}

	/** Get optdato1.
		@return optdato1	  */
	public String getoptdato1 () 
	{
		return (String)get_Value(COLUMNNAME_optdato1);
	}

	/** Set optdato10.
		@param optdato10 optdato10	  */
	public void setoptdato10 (String optdato10)
	{
		set_Value (COLUMNNAME_optdato10, optdato10);
	}

	/** Get optdato10.
		@return optdato10	  */
	public String getoptdato10 () 
	{
		return (String)get_Value(COLUMNNAME_optdato10);
	}

	/** Set optdato11.
		@param optdato11 optdato11	  */
	public void setoptdato11 (String optdato11)
	{
		set_Value (COLUMNNAME_optdato11, optdato11);
	}

	/** Get optdato11.
		@return optdato11	  */
	public String getoptdato11 () 
	{
		return (String)get_Value(COLUMNNAME_optdato11);
	}

	/** Set optdato12.
		@param optdato12 optdato12	  */
	public void setoptdato12 (String optdato12)
	{
		set_Value (COLUMNNAME_optdato12, optdato12);
	}

	/** Get optdato12.
		@return optdato12	  */
	public String getoptdato12 () 
	{
		return (String)get_Value(COLUMNNAME_optdato12);
	}

	/** Set optdato13.
		@param optdato13 optdato13	  */
	public void setoptdato13 (String optdato13)
	{
		set_Value (COLUMNNAME_optdato13, optdato13);
	}

	/** Get optdato13.
		@return optdato13	  */
	public String getoptdato13 () 
	{
		return (String)get_Value(COLUMNNAME_optdato13);
	}

	/** Set optdato14.
		@param optdato14 optdato14	  */
	public void setoptdato14 (String optdato14)
	{
		set_Value (COLUMNNAME_optdato14, optdato14);
	}

	/** Get optdato14.
		@return optdato14	  */
	public String getoptdato14 () 
	{
		return (String)get_Value(COLUMNNAME_optdato14);
	}

	/** Set optdato15.
		@param optdato15 optdato15	  */
	public void setoptdato15 (String optdato15)
	{
		set_Value (COLUMNNAME_optdato15, optdato15);
	}

	/** Get optdato15.
		@return optdato15	  */
	public String getoptdato15 () 
	{
		return (String)get_Value(COLUMNNAME_optdato15);
	}

	/** Set optdato16.
		@param optdato16 optdato16	  */
	public void setoptdato16 (String optdato16)
	{
		set_Value (COLUMNNAME_optdato16, optdato16);
	}

	/** Get optdato16.
		@return optdato16	  */
	public String getoptdato16 () 
	{
		return (String)get_Value(COLUMNNAME_optdato16);
	}

	/** Set optdato17.
		@param optdato17 optdato17	  */
	public void setoptdato17 (String optdato17)
	{
		set_Value (COLUMNNAME_optdato17, optdato17);
	}

	/** Get optdato17.
		@return optdato17	  */
	public String getoptdato17 () 
	{
		return (String)get_Value(COLUMNNAME_optdato17);
	}

	/** Set optdato18.
		@param optdato18 optdato18	  */
	public void setoptdato18 (String optdato18)
	{
		set_Value (COLUMNNAME_optdato18, optdato18);
	}

	/** Get optdato18.
		@return optdato18	  */
	public String getoptdato18 () 
	{
		return (String)get_Value(COLUMNNAME_optdato18);
	}

	/** Set optdato19.
		@param optdato19 optdato19	  */
	public void setoptdato19 (String optdato19)
	{
		set_Value (COLUMNNAME_optdato19, optdato19);
	}

	/** Get optdato19.
		@return optdato19	  */
	public String getoptdato19 () 
	{
		return (String)get_Value(COLUMNNAME_optdato19);
	}

	/** Set optdato2.
		@param optdato2 optdato2	  */
	public void setoptdato2 (String optdato2)
	{
		set_Value (COLUMNNAME_optdato2, optdato2);
	}

	/** Get optdato2.
		@return optdato2	  */
	public String getoptdato2 () 
	{
		return (String)get_Value(COLUMNNAME_optdato2);
	}

	/** Set optdato20.
		@param optdato20 optdato20	  */
	public void setoptdato20 (String optdato20)
	{
		set_Value (COLUMNNAME_optdato20, optdato20);
	}

	/** Get optdato20.
		@return optdato20	  */
	public String getoptdato20 () 
	{
		return (String)get_Value(COLUMNNAME_optdato20);
	}

	/** Set optdato21.
		@param optdato21 optdato21	  */
	public void setoptdato21 (String optdato21)
	{
		set_Value (COLUMNNAME_optdato21, optdato21);
	}

	/** Get optdato21.
		@return optdato21	  */
	public String getoptdato21 () 
	{
		return (String)get_Value(COLUMNNAME_optdato21);
	}

	/** Set optdato22.
		@param optdato22 optdato22	  */
	public void setoptdato22 (String optdato22)
	{
		set_Value (COLUMNNAME_optdato22, optdato22);
	}

	/** Get optdato22.
		@return optdato22	  */
	public String getoptdato22 () 
	{
		return (String)get_Value(COLUMNNAME_optdato22);
	}

	/** Set optdato23.
		@param optdato23 optdato23	  */
	public void setoptdato23 (String optdato23)
	{
		set_Value (COLUMNNAME_optdato23, optdato23);
	}

	/** Get optdato23.
		@return optdato23	  */
	public String getoptdato23 () 
	{
		return (String)get_Value(COLUMNNAME_optdato23);
	}

	/** Set optdato24.
		@param optdato24 optdato24	  */
	public void setoptdato24 (String optdato24)
	{
		set_Value (COLUMNNAME_optdato24, optdato24);
	}

	/** Get optdato24.
		@return optdato24	  */
	public String getoptdato24 () 
	{
		return (String)get_Value(COLUMNNAME_optdato24);
	}

	/** Set optdato25.
		@param optdato25 optdato25	  */
	public void setoptdato25 (String optdato25)
	{
		set_Value (COLUMNNAME_optdato25, optdato25);
	}

	/** Get optdato25.
		@return optdato25	  */
	public String getoptdato25 () 
	{
		return (String)get_Value(COLUMNNAME_optdato25);
	}

	/** Set optdato26.
		@param optdato26 optdato26	  */
	public void setoptdato26 (String optdato26)
	{
		set_Value (COLUMNNAME_optdato26, optdato26);
	}

	/** Get optdato26.
		@return optdato26	  */
	public String getoptdato26 () 
	{
		return (String)get_Value(COLUMNNAME_optdato26);
	}

	/** Set optdato27.
		@param optdato27 optdato27	  */
	public void setoptdato27 (String optdato27)
	{
		set_Value (COLUMNNAME_optdato27, optdato27);
	}

	/** Get optdato27.
		@return optdato27	  */
	public String getoptdato27 () 
	{
		return (String)get_Value(COLUMNNAME_optdato27);
	}

	/** Set optdato28.
		@param optdato28 optdato28	  */
	public void setoptdato28 (String optdato28)
	{
		set_Value (COLUMNNAME_optdato28, optdato28);
	}

	/** Get optdato28.
		@return optdato28	  */
	public String getoptdato28 () 
	{
		return (String)get_Value(COLUMNNAME_optdato28);
	}

	/** Set optdato29.
		@param optdato29 optdato29	  */
	public void setoptdato29 (String optdato29)
	{
		set_Value (COLUMNNAME_optdato29, optdato29);
	}

	/** Get optdato29.
		@return optdato29	  */
	public String getoptdato29 () 
	{
		return (String)get_Value(COLUMNNAME_optdato29);
	}

	/** Set optdato3.
		@param optdato3 optdato3	  */
	public void setoptdato3 (String optdato3)
	{
		set_Value (COLUMNNAME_optdato3, optdato3);
	}

	/** Get optdato3.
		@return optdato3	  */
	public String getoptdato3 () 
	{
		return (String)get_Value(COLUMNNAME_optdato3);
	}

	/** Set optdato30.
		@param optdato30 optdato30	  */
	public void setoptdato30 (String optdato30)
	{
		set_Value (COLUMNNAME_optdato30, optdato30);
	}

	/** Get optdato30.
		@return optdato30	  */
	public String getoptdato30 () 
	{
		return (String)get_Value(COLUMNNAME_optdato30);
	}

	/** Set optdato31.
		@param optdato31 optdato31	  */
	public void setoptdato31 (String optdato31)
	{
		set_Value (COLUMNNAME_optdato31, optdato31);
	}

	/** Get optdato31.
		@return optdato31	  */
	public String getoptdato31 () 
	{
		return (String)get_Value(COLUMNNAME_optdato31);
	}

	/** Set optdato32.
		@param optdato32 optdato32	  */
	public void setoptdato32 (String optdato32)
	{
		set_Value (COLUMNNAME_optdato32, optdato32);
	}

	/** Get optdato32.
		@return optdato32	  */
	public String getoptdato32 () 
	{
		return (String)get_Value(COLUMNNAME_optdato32);
	}

	/** Set optdato33.
		@param optdato33 optdato33	  */
	public void setoptdato33 (String optdato33)
	{
		set_Value (COLUMNNAME_optdato33, optdato33);
	}

	/** Get optdato33.
		@return optdato33	  */
	public String getoptdato33 () 
	{
		return (String)get_Value(COLUMNNAME_optdato33);
	}

	/** Set optdato34.
		@param optdato34 optdato34	  */
	public void setoptdato34 (String optdato34)
	{
		set_Value (COLUMNNAME_optdato34, optdato34);
	}

	/** Get optdato34.
		@return optdato34	  */
	public String getoptdato34 () 
	{
		return (String)get_Value(COLUMNNAME_optdato34);
	}

	/** Set optdato35.
		@param optdato35 optdato35	  */
	public void setoptdato35 (String optdato35)
	{
		set_Value (COLUMNNAME_optdato35, optdato35);
	}

	/** Get optdato35.
		@return optdato35	  */
	public String getoptdato35 () 
	{
		return (String)get_Value(COLUMNNAME_optdato35);
	}

	/** Set optdato36.
		@param optdato36 optdato36	  */
	public void setoptdato36 (String optdato36)
	{
		set_Value (COLUMNNAME_optdato36, optdato36);
	}

	/** Get optdato36.
		@return optdato36	  */
	public String getoptdato36 () 
	{
		return (String)get_Value(COLUMNNAME_optdato36);
	}

	/** Set optdato37.
		@param optdato37 optdato37	  */
	public void setoptdato37 (String optdato37)
	{
		set_Value (COLUMNNAME_optdato37, optdato37);
	}

	/** Get optdato37.
		@return optdato37	  */
	public String getoptdato37 () 
	{
		return (String)get_Value(COLUMNNAME_optdato37);
	}

	/** Set optdato38.
		@param optdato38 optdato38	  */
	public void setoptdato38 (String optdato38)
	{
		set_Value (COLUMNNAME_optdato38, optdato38);
	}

	/** Get optdato38.
		@return optdato38	  */
	public String getoptdato38 () 
	{
		return (String)get_Value(COLUMNNAME_optdato38);
	}

	/** Set optdato39.
		@param optdato39 optdato39	  */
	public void setoptdato39 (String optdato39)
	{
		set_Value (COLUMNNAME_optdato39, optdato39);
	}

	/** Get optdato39.
		@return optdato39	  */
	public String getoptdato39 () 
	{
		return (String)get_Value(COLUMNNAME_optdato39);
	}

	/** Set optdato4.
		@param optdato4 optdato4	  */
	public void setoptdato4 (String optdato4)
	{
		set_Value (COLUMNNAME_optdato4, optdato4);
	}

	/** Get optdato4.
		@return optdato4	  */
	public String getoptdato4 () 
	{
		return (String)get_Value(COLUMNNAME_optdato4);
	}

	/** Set optdato40.
		@param optdato40 optdato40	  */
	public void setoptdato40 (String optdato40)
	{
		set_Value (COLUMNNAME_optdato40, optdato40);
	}

	/** Get optdato40.
		@return optdato40	  */
	public String getoptdato40 () 
	{
		return (String)get_Value(COLUMNNAME_optdato40);
	}

	/** Set optdato5.
		@param optdato5 optdato5	  */
	public void setoptdato5 (String optdato5)
	{
		set_Value (COLUMNNAME_optdato5, optdato5);
	}

	/** Get optdato5.
		@return optdato5	  */
	public String getoptdato5 () 
	{
		return (String)get_Value(COLUMNNAME_optdato5);
	}

	/** Set optdato6.
		@param optdato6 optdato6	  */
	public void setoptdato6 (String optdato6)
	{
		set_Value (COLUMNNAME_optdato6, optdato6);
	}

	/** Get optdato6.
		@return optdato6	  */
	public String getoptdato6 () 
	{
		return (String)get_Value(COLUMNNAME_optdato6);
	}

	/** Set optdato7.
		@param optdato7 optdato7	  */
	public void setoptdato7 (String optdato7)
	{
		set_Value (COLUMNNAME_optdato7, optdato7);
	}

	/** Get optdato7.
		@return optdato7	  */
	public String getoptdato7 () 
	{
		return (String)get_Value(COLUMNNAME_optdato7);
	}

	/** Set optdato8.
		@param optdato8 optdato8	  */
	public void setoptdato8 (String optdato8)
	{
		set_Value (COLUMNNAME_optdato8, optdato8);
	}

	/** Get optdato8.
		@return optdato8	  */
	public String getoptdato8 () 
	{
		return (String)get_Value(COLUMNNAME_optdato8);
	}

	/** Set optdato9.
		@param optdato9 optdato9	  */
	public void setoptdato9 (String optdato9)
	{
		set_Value (COLUMNNAME_optdato9, optdato9);
	}

	/** Get optdato9.
		@return optdato9	  */
	public String getoptdato9 () 
	{
		return (String)get_Value(COLUMNNAME_optdato9);
	}

	/** Set optedad.
		@param optedad optedad	  */
	public void setoptedad (String optedad)
	{
		set_Value (COLUMNNAME_optedad, optedad);
	}

	/** Get optedad.
		@return optedad	  */
	public String getoptedad () 
	{
		return (String)get_Value(COLUMNNAME_optedad);
	}

	/** Set optsec.
		@param optsec optsec	  */
	public void setoptsec (String optsec)
	{
		set_Value (COLUMNNAME_optsec, optsec);
	}

	/** Get optsec.
		@return optsec	  */
	public String getoptsec () 
	{
		return (String)get_Value(COLUMNNAME_optsec);
	}

	/** Set unico.
		@param unico unico	  */
	public void setunico (String unico)
	{
		set_Value (COLUMNNAME_unico, unico);
	}

	/** Get unico.
		@return unico	  */
	public String getunico () 
	{
		return (String)get_Value(COLUMNNAME_unico);
	}
}