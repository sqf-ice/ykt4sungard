package org.king.checkinmanage.domain;
// Generated by MyEclipse - Hibernate Tools

import java.util.Date;


/** 
 * StuCardfeeInfo generated by MyEclipse - Hibernate Tools
 */
public class StuCardfeeInfo extends AbstractStuCardfeeInfo implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public StuCardfeeInfo() {
    }

	/** minimal constructor */
    public StuCardfeeInfo(String studentNo, String enrollYear, String ecardPayed, String bathcardPayed) {
        super(studentNo, enrollYear, ecardPayed, bathcardPayed);        
    }
    
    /** full constructor */
    public StuCardfeeInfo(String studentNo, String enrollYear, String ecardPayed, String bathcardNo, String ecardPhoto, String bathcardPayed, String updatorId, Date updateTime) {
        super(studentNo, enrollYear, ecardPayed, bathcardNo, ecardPhoto, bathcardPayed, updatorId, updateTime);        
    }
   
}
