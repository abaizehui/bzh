package com.bzh.common.exception.user;

import com.bzh.common.exception.base.BaseException;

/**
 * 用户信息异常类
 * 
 * @author bzh
 */
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
