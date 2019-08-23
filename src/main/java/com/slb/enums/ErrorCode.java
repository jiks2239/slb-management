package com.slb.enums;

import com.slb.exceptions.ErrorCodeConstant;
import org.apache.commons.lang3.ObjectUtils;

public enum ErrorCode implements ErrorCodeConstant {

    INVALID_USERNAME_PASSWORD(SLB001, "Invalid Username or password."),
    INVALID_EMPLOYEE_NAME(SLB002, "Employee name must not be empty or Invalid."),
    INVALID_PAYROLL(SLB003, "Payroll Type must not be empty or Invalid."),
    INVALID_DEPARTMENT(SLB004, "Department must not be empty or Invalid"),
    INVALID_WAGE(SLB005, "Wage must not be empty or Invalid");

    private Integer errorCode;
    private String message;

    ErrorCode(Integer errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public String getMessageByErrorCode(Integer errorCode) {
        String message = "";
        if (ObjectUtils.isEmpty(errorCode) || errorCode.equals(0))
            return message;
        for (ErrorCode value : ErrorCode.values())
            if (value.errorCode.equals(errorCode))
                message = value.getMessage();
        return message;
    }
}
