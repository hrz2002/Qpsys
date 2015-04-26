package business.action;

import com.opensymphony.xwork2.*;

public class CheckloginAction extends ActionSupport {

    /**
     * <h3>スレッドセーフ性</h3>
     * <p>
     * この変数は<code>this</code>によってGuardされる。
     * この変数は<code>final</code>であり、参照先がスレッドセーフであるため、スレッドセーフ性を破ることはない。
     * この変数の参照先はスレッドセーフ<strong>ではない</strong>。
     * </p>
     */
    private static final long serialVersionUID = 1L;
    
//    private static final Logger log = Logger.getLogger(CheckloginAction.class);
    
    
    public String checkLogin() throws Exception {
//      SessionMap session = (SessionMap) ActionContext.getContext().get(ActionContext.SESSION);
//      session.put("user", "lisheng_testsession");
  		return Action.SUCCESS;
  }
    
}
