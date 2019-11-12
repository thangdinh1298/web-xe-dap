/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tags;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author thang
 */
public class MissingFieldNotifier extends TagSupport{

    @Override
    public int doStartTag() throws JspException {
        try{
            JspWriter jsw = pageContext.getOut();
            jsw.write("*");
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
        return SKIP_BODY;
    }
    
}
