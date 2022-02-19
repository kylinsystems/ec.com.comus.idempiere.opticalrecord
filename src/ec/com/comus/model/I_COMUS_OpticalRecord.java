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
package ec.com.comus.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for COMUS_OpticalRecord
 *  @author iDempiere (generated) 
 *  @version Release 5.1
 */
@SuppressWarnings("all")
public interface I_COMUS_OpticalRecord 
{

    /** TableName=COMUS_OpticalRecord */
    public static final String Table_Name = "COMUS_OpticalRecord";

    /** AD_Table_ID=1000128 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name C_BPartner_ID */
    public static final String COLUMNNAME_C_BPartner_ID = "C_BPartner_ID";

	/** Set Business Partner .
	  * Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID);

	/** Get Business Partner .
	  * Identifies a Business Partner
	  */
	public int getC_BPartner_ID();

	public org.compiere.model.I_C_BPartner getC_BPartner() throws RuntimeException;

    /** Column name codcli */
    public static final String COLUMNNAME_codcli = "codcli";

	/** Set codcli	  */
	public void setcodcli (String codcli);

	/** Get codcli	  */
	public String getcodcli();

    /** Column name COMUS_OpticalRecord_ID */
    public static final String COLUMNNAME_COMUS_OpticalRecord_ID = "COMUS_OpticalRecord_ID";

	/** Set COMUS_OpticalRecord_ID	  */
	public void setCOMUS_OpticalRecord_ID (int COMUS_OpticalRecord_ID);

	/** Get COMUS_OpticalRecord_ID	  */
	public int getCOMUS_OpticalRecord_ID();

    /** Column name COMUS_OpticalRecord_UU */
    public static final String COLUMNNAME_COMUS_OpticalRecord_UU = "COMUS_OpticalRecord_UU";

	/** Set COMUS_OpticalRecord_UU	  */
	public void setCOMUS_OpticalRecord_UU (String COMUS_OpticalRecord_UU);

	/** Get COMUS_OpticalRecord_UU	  */
	public String getCOMUS_OpticalRecord_UU();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name DateTrx */
    public static final String COLUMNNAME_DateTrx = "DateTrx";

	/** Set Transaction Date.
	  * Transaction Date
	  */
	public void setDateTrx (Timestamp DateTrx);

	/** Get Transaction Date.
	  * Transaction Date
	  */
	public Timestamp getDateTrx();

    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	/** Set Description.
	  * Optional short description of the record
	  */
	public void setDescription (String Description);

	/** Get Description.
	  * Optional short description of the record
	  */
	public String getDescription();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name optdato1 */
    public static final String COLUMNNAME_optdato1 = "optdato1";

	/** Set optdato1	  */
	public void setoptdato1 (String optdato1);

	/** Get optdato1	  */
	public String getoptdato1();

    /** Column name optdato10 */
    public static final String COLUMNNAME_optdato10 = "optdato10";

	/** Set optdato10	  */
	public void setoptdato10 (String optdato10);

	/** Get optdato10	  */
	public String getoptdato10();

    /** Column name optdato11 */
    public static final String COLUMNNAME_optdato11 = "optdato11";

	/** Set optdato11	  */
	public void setoptdato11 (String optdato11);

	/** Get optdato11	  */
	public String getoptdato11();

    /** Column name optdato12 */
    public static final String COLUMNNAME_optdato12 = "optdato12";

	/** Set optdato12	  */
	public void setoptdato12 (String optdato12);

	/** Get optdato12	  */
	public String getoptdato12();

    /** Column name optdato13 */
    public static final String COLUMNNAME_optdato13 = "optdato13";

	/** Set optdato13	  */
	public void setoptdato13 (String optdato13);

	/** Get optdato13	  */
	public String getoptdato13();

    /** Column name optdato14 */
    public static final String COLUMNNAME_optdato14 = "optdato14";

	/** Set optdato14	  */
	public void setoptdato14 (String optdato14);

	/** Get optdato14	  */
	public String getoptdato14();

    /** Column name optdato15 */
    public static final String COLUMNNAME_optdato15 = "optdato15";

	/** Set optdato15	  */
	public void setoptdato15 (String optdato15);

	/** Get optdato15	  */
	public String getoptdato15();

    /** Column name optdato16 */
    public static final String COLUMNNAME_optdato16 = "optdato16";

	/** Set optdato16	  */
	public void setoptdato16 (String optdato16);

	/** Get optdato16	  */
	public String getoptdato16();

    /** Column name optdato17 */
    public static final String COLUMNNAME_optdato17 = "optdato17";

	/** Set optdato17	  */
	public void setoptdato17 (String optdato17);

	/** Get optdato17	  */
	public String getoptdato17();

    /** Column name optdato18 */
    public static final String COLUMNNAME_optdato18 = "optdato18";

	/** Set optdato18	  */
	public void setoptdato18 (String optdato18);

	/** Get optdato18	  */
	public String getoptdato18();

    /** Column name optdato19 */
    public static final String COLUMNNAME_optdato19 = "optdato19";

	/** Set optdato19	  */
	public void setoptdato19 (String optdato19);

	/** Get optdato19	  */
	public String getoptdato19();

    /** Column name optdato2 */
    public static final String COLUMNNAME_optdato2 = "optdato2";

	/** Set optdato2	  */
	public void setoptdato2 (String optdato2);

	/** Get optdato2	  */
	public String getoptdato2();

    /** Column name optdato20 */
    public static final String COLUMNNAME_optdato20 = "optdato20";

	/** Set optdato20	  */
	public void setoptdato20 (String optdato20);

	/** Get optdato20	  */
	public String getoptdato20();

    /** Column name optdato21 */
    public static final String COLUMNNAME_optdato21 = "optdato21";

	/** Set optdato21	  */
	public void setoptdato21 (String optdato21);

	/** Get optdato21	  */
	public String getoptdato21();

    /** Column name optdato22 */
    public static final String COLUMNNAME_optdato22 = "optdato22";

	/** Set optdato22	  */
	public void setoptdato22 (String optdato22);

	/** Get optdato22	  */
	public String getoptdato22();

    /** Column name optdato23 */
    public static final String COLUMNNAME_optdato23 = "optdato23";

	/** Set optdato23	  */
	public void setoptdato23 (String optdato23);

	/** Get optdato23	  */
	public String getoptdato23();

    /** Column name optdato24 */
    public static final String COLUMNNAME_optdato24 = "optdato24";

	/** Set optdato24	  */
	public void setoptdato24 (String optdato24);

	/** Get optdato24	  */
	public String getoptdato24();

    /** Column name optdato25 */
    public static final String COLUMNNAME_optdato25 = "optdato25";

	/** Set optdato25	  */
	public void setoptdato25 (String optdato25);

	/** Get optdato25	  */
	public String getoptdato25();

    /** Column name optdato26 */
    public static final String COLUMNNAME_optdato26 = "optdato26";

	/** Set optdato26	  */
	public void setoptdato26 (String optdato26);

	/** Get optdato26	  */
	public String getoptdato26();

    /** Column name optdato27 */
    public static final String COLUMNNAME_optdato27 = "optdato27";

	/** Set optdato27	  */
	public void setoptdato27 (String optdato27);

	/** Get optdato27	  */
	public String getoptdato27();

    /** Column name optdato28 */
    public static final String COLUMNNAME_optdato28 = "optdato28";

	/** Set optdato28	  */
	public void setoptdato28 (String optdato28);

	/** Get optdato28	  */
	public String getoptdato28();

    /** Column name optdato29 */
    public static final String COLUMNNAME_optdato29 = "optdato29";

	/** Set optdato29	  */
	public void setoptdato29 (String optdato29);

	/** Get optdato29	  */
	public String getoptdato29();

    /** Column name optdato3 */
    public static final String COLUMNNAME_optdato3 = "optdato3";

	/** Set optdato3	  */
	public void setoptdato3 (String optdato3);

	/** Get optdato3	  */
	public String getoptdato3();

    /** Column name optdato30 */
    public static final String COLUMNNAME_optdato30 = "optdato30";

	/** Set optdato30	  */
	public void setoptdato30 (String optdato30);

	/** Get optdato30	  */
	public String getoptdato30();

    /** Column name optdato31 */
    public static final String COLUMNNAME_optdato31 = "optdato31";

	/** Set optdato31	  */
	public void setoptdato31 (String optdato31);

	/** Get optdato31	  */
	public String getoptdato31();

    /** Column name optdato32 */
    public static final String COLUMNNAME_optdato32 = "optdato32";

	/** Set optdato32	  */
	public void setoptdato32 (String optdato32);

	/** Get optdato32	  */
	public String getoptdato32();

    /** Column name optdato33 */
    public static final String COLUMNNAME_optdato33 = "optdato33";

	/** Set optdato33	  */
	public void setoptdato33 (String optdato33);

	/** Get optdato33	  */
	public String getoptdato33();

    /** Column name optdato34 */
    public static final String COLUMNNAME_optdato34 = "optdato34";

	/** Set optdato34	  */
	public void setoptdato34 (String optdato34);

	/** Get optdato34	  */
	public String getoptdato34();

    /** Column name optdato35 */
    public static final String COLUMNNAME_optdato35 = "optdato35";

	/** Set optdato35	  */
	public void setoptdato35 (String optdato35);

	/** Get optdato35	  */
	public String getoptdato35();

    /** Column name optdato36 */
    public static final String COLUMNNAME_optdato36 = "optdato36";

	/** Set optdato36	  */
	public void setoptdato36 (String optdato36);

	/** Get optdato36	  */
	public String getoptdato36();

    /** Column name optdato37 */
    public static final String COLUMNNAME_optdato37 = "optdato37";

	/** Set optdato37	  */
	public void setoptdato37 (String optdato37);

	/** Get optdato37	  */
	public String getoptdato37();

    /** Column name optdato38 */
    public static final String COLUMNNAME_optdato38 = "optdato38";

	/** Set optdato38	  */
	public void setoptdato38 (String optdato38);

	/** Get optdato38	  */
	public String getoptdato38();

    /** Column name optdato39 */
    public static final String COLUMNNAME_optdato39 = "optdato39";

	/** Set optdato39	  */
	public void setoptdato39 (String optdato39);

	/** Get optdato39	  */
	public String getoptdato39();

    /** Column name optdato4 */
    public static final String COLUMNNAME_optdato4 = "optdato4";

	/** Set optdato4	  */
	public void setoptdato4 (String optdato4);

	/** Get optdato4	  */
	public String getoptdato4();

    /** Column name optdato40 */
    public static final String COLUMNNAME_optdato40 = "optdato40";

	/** Set optdato40	  */
	public void setoptdato40 (String optdato40);

	/** Get optdato40	  */
	public String getoptdato40();

    /** Column name optdato5 */
    public static final String COLUMNNAME_optdato5 = "optdato5";

	/** Set optdato5	  */
	public void setoptdato5 (String optdato5);

	/** Get optdato5	  */
	public String getoptdato5();

    /** Column name optdato6 */
    public static final String COLUMNNAME_optdato6 = "optdato6";

	/** Set optdato6	  */
	public void setoptdato6 (String optdato6);

	/** Get optdato6	  */
	public String getoptdato6();

    /** Column name optdato7 */
    public static final String COLUMNNAME_optdato7 = "optdato7";

	/** Set optdato7	  */
	public void setoptdato7 (String optdato7);

	/** Get optdato7	  */
	public String getoptdato7();

    /** Column name optdato8 */
    public static final String COLUMNNAME_optdato8 = "optdato8";

	/** Set optdato8	  */
	public void setoptdato8 (String optdato8);

	/** Get optdato8	  */
	public String getoptdato8();

    /** Column name optdato9 */
    public static final String COLUMNNAME_optdato9 = "optdato9";

	/** Set optdato9	  */
	public void setoptdato9 (String optdato9);

	/** Get optdato9	  */
	public String getoptdato9();

    /** Column name optedad */
    public static final String COLUMNNAME_optedad = "optedad";

	/** Set optedad	  */
	public void setoptedad (String optedad);

	/** Get optedad	  */
	public String getoptedad();

    /** Column name optsec */
    public static final String COLUMNNAME_optsec = "optsec";

	/** Set optsec	  */
	public void setoptsec (String optsec);

	/** Get optsec	  */
	public String getoptsec();

    /** Column name unico */
    public static final String COLUMNNAME_unico = "unico";

	/** Set unico	  */
	public void setunico (String unico);

	/** Get unico	  */
	public String getunico();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();
}
