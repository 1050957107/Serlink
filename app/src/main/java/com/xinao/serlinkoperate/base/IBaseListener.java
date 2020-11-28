package com.xinao.serlinkoperate.base;

/**
 * Author： Darren on 2018/3/18 17:00.
 * Email：995472572@qq.com
 * Instructions: Request a callback to the server's listener interface
 */

public interface IBaseListener {
    /**
     * success
     * @param response Requested data returned successfully
     */
    void requestSuccess(Object response);

    /**
     * failure
     * @param status The Error status code
     * @param errorMsg The Error log information
     */
    void requestFailure(int status, String errorMsg);
}
