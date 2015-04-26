package business.action;

import java.io.ByteArrayInputStream;

import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.*;

public class LoginAction extends ActionSupport{

    /**
     * <h3>スレッドセーフ性</h3>
     * <p>
     * この変数は<code>this</code>によってGuardされる。
     * この変数は<code>final</code>であり、参照先がスレッドセーフであるため、スレッドセーフ性を破ることはない。
     * この変数の参照先はスレッドセーフ<strong>ではない</strong>。
     * </p>
     */
    private static final long serialVersionUID = 1L;

    private static final Logger log = Logger.getLogger(LoginAction.class);

    @SuppressWarnings("unchecked")
	public String login() throws Exception {
        SessionMap<String, String> sessionMap = (SessionMap<String, String>) ActionContext.getContext().get(ActionContext.SESSION);
        sessionMap.put("user", getUserid());
        sessionMap.put("passwd", getPasswd());
    	log.warn(""+""+"--LoginAction --: is running ''''''''''''''''''''''''''");
    	if (sessionMap.get("user").equals("aaa") && sessionMap.get("passwd").equals("bbb")){
    		setInputStream(new ByteArrayInputStream("success".getBytes()));
    	} else {
    		setInputStream(new ByteArrayInputStream("input".getBytes()));
    	}
    	return Action.SUCCESS;
    }

	private ByteArrayInputStream inputStream;


	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}


    private String userid;

    private String passwd;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


}
