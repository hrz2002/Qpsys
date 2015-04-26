package business.action;

import java.io.*;
import java.util.List;


import business.entity.*;
import business.service.*;

import com.opensymphony.xwork2.*;

import framework.jpa.*;

public class CustomerAction extends ActionSupport {

    /**
     * <h3>スレッドセーフ性</h3>
     * <p>
     * この変数は<code>this</code>によってGuardされる。
     * この変数は<code>final</code>であり、参照先がスレッドセーフであるため、スレッドセーフ性を破ることはない。
     * この変数の参照先はスレッドセーフ<strong>ではない</strong>。
     * </p>
     */
    private static final long serialVersionUID = 1L;

    /**
     * <p>
     * プロパティ<code>service</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>service</code>の値
     */

    private long entityId;

    private int indexDetail;

    private Customer customer;

    private List<Customer> customers;

    /**
     * <p>
     * プロパティ<code>entityId</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>entityId</code>の値
     */
    public long getEntityId() {
        return entityId;
    }

    /**
     * <p>
     * プロパティ<code>entityId</code>の値を設定する。
     * </p>
     *
     * @param entityId プロパティ<code>entityId</code>に設定する値
     */
    public void setEntityId(final long entityId) {
        this.entityId = entityId;
    }


    /**
     * <p>
     * プロパティ<code>indexDetail</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>indexDetail</code>の値
     */
    public int getIndexDetail() {
        return indexDetail;
    }

    /**
     * <p>
     * プロパティ<code>indexDetail</code>の値を設定する。
     * </p>
     *
     * @param indexDetail プロパティ<code>indexDetail</code>に設定する値
     */
    public void setIndexDetail(final int indexDetail) {
        this.indexDetail = indexDetail;
    }

    /**
     * <p>
     * プロパティ<code>customer</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>customer</code>の値
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * <p>
     * プロパティ<code>customer</code>の値を設定する。
     * </p>
     *
     * @param customer プロパティ<code>customer</code>に設定する値
     */
    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }

    /**
     * <p>
     * プロパティ<code>customers</code>の値を取得する。
     * </p>
     *
     * @return プロパティ<code>customers</code>の値
     */
    public List<Customer> getCustomers() {
        return customers;
    }

    /**
     * <p>
     * プロパティ<code>customers</code>の値を設定する。
     * </p>
     *
     * @param customers プロパティ<code>customers</code>に設定する値
     */
    public void setCustomers(final List<Customer> customers) {
        this.customers = customers;
    }

    //===========================Actions==================start
    @Override
    public void validate() {
        clearFieldErrors();
        clearActionErrors();
    }

    public String PersistenceException() throws Exception {
        return Action.SUCCESS;
    }

    public String edit() throws Exception {
        final EntityId id = EntityId.valueOf(entityId);
        final Customer me = customerService.findByEntityId(id);
        setCustomer(me);
        return Action.SUCCESS;
    }


    public String show() throws Exception {
        clear();
        final List<Customer> A = customerService.findAll();
        setCustomers(A);
        return Action.SUCCESS;
    }

    public String detail() throws Exception {
        if (entityId == 0) {
            final Customer me = new Customer();
            setCustomer(me);
            return Action.INPUT;
        }
        final EntityId id = EntityId.valueOf(entityId);
        final Customer me = customerService.findByEntityId(id);
        setCustomer(me);
        return Action.SUCCESS;
    }

    public String save() throws Exception {
        final Customer me = getCustomer();

        @SuppressWarnings("unused")
		final Customer ret = customerService.save(me);
//        if (ret != null && getStep() != null && !getStep().equals("edit")) {
//            this.customer = ret;
//            return Action.LOGIN;
//        }
        return Action.SUCCESS;
    }


    private InputStream inputStreamPDF;

    public InputStream getInputStreamPDF() {
        return inputStreamPDF;
    }

    public void setInputStreamPDF(final InputStream inputStreamPDF) {
        this.inputStreamPDF = inputStreamPDF;
    }

    //===========================Actions==================end

    private void clear() {
        this.entityId = 0;
        this.customer = null;
        this.customers = null;
    }

    //===========================Service==================
    public CustomerAction(final CustomerService customerService) {
        this.customerService = customerService;
    }

    private final CustomerService customerService;
}
