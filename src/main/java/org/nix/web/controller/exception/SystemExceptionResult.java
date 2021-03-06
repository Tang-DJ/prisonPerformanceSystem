package org.nix.web.controller.exception;

import org.apache.log4j.Logger;
import org.nix.exception.ErrorCode;
import org.nix.web.controller.utils.ResultMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Create by zhangpe0312@qq.com on 2018/3/10.
 * <p>
 * 对一些系统异常进行处理异常进行处理
 */
@RestController
@RequestMapping(value = "/exception/system")
public class SystemExceptionResult {
    //日志记录
    private static Logger logger = Logger.getLogger(SystemExceptionResult.class);


    /**
     * 权限不足返回的控制接口
     *
     * @return
     */
    @RequestMapping(value = "/accessDenied")
    public Map<String, Object> accessDenied() {
        logger.error("权限不足，访问被拒绝");
        return new ResultMap()
                .setResult(ErrorCode.PERMISSION_DENIED.getValue())
                .appendParameter(ErrorCode.PERMISSION_DENIED.getValue(), ErrorCode.PERMISSION_DENIED.getDesc())
                .send();
    }

    /**
     * 空指针异常返回结果类
     *
     * @return 返回错误通知信息
     */
    @RequestMapping(value = "/parameterNullException")
    public Map<String, Object> parameterNullException() {

        return new ResultMap()
                .setResult(ErrorCode.PARAMETER_NULL.getValue())
                .appendParameter(ErrorCode.PARAMETER_NULL.getValue()
                        , ErrorCode.PARAMETER_NULL.getDesc())
                .send();
    }

    /**
     * Insert或Update数据时违反了完整性，例如违反了惟一性限制
     *
     * @return 返回错误通知信息
     */
    @RequestMapping(value = "/dataIntegrityViolationException")
    public Map<String, Object> dataIntegrityViolationException() {

        return new ResultMap()
                .setResult(ErrorCode.CONSTRAINT_VIOLATE_DATABASES.getValue())
                .appendParameter(ErrorCode.CONSTRAINT_VIOLATE_DATABASES.getValue()
                        , ErrorCode.CONSTRAINT_VIOLATE_DATABASES.getDesc())
                .send();
    }

    /**
     * 某些数据不能被检测到，例如不能通过关键字找到一条记录
     *
     * @return
     */
    @RequestMapping(value = "/dataRetrievalFailureException")
    public Map<String, Object> dataRetrievalFailureException() {

        return new ResultMap()
                .setResult(ErrorCode.DATABASES_ERROR_DATA_RETRIEVAL_FAIL.getValue())
                .appendParameter(ErrorCode.DATABASES_ERROR_DATA_RETRIEVAL_FAIL.getValue()
                        , ErrorCode.DATABASES_ERROR_DATA_RETRIEVAL_FAIL.getDesc())
                .send();
    }

    /**
     * 有错误发生，但无法归类到某一更为具体的异常中
     *
     * @return
     */
    @RequestMapping(value = "/uncategorizedDataAccessException")
    public Map<String, Object> uncategorizedDataAccessException() {

        return new ResultMap()
                .setResult(ErrorCode.DATABASES_ERROR_UNCATEGORIZED.getValue())
                .appendParameter(ErrorCode.DATABASES_ERROR_UNCATEGORIZED.getValue()
                        , ErrorCode.DATABASES_ERROR_UNCATEGORIZED.getDesc())
                .send();
    }

    /**
     * 参数异常
     *
     * @return
     */
    @RequestMapping(value = "/illegalArgumentException")
    public Map<String, Object> illegalArgumentException() {
        return new ResultMap()
                .setResult(ErrorCode.PARAMETER_EXCEPTION.getValue())
                .appendParameter(ErrorCode.PARAMETER_EXCEPTION.getValue()
                        , ErrorCode.PARAMETER_EXCEPTION.getDesc())
                .send();
    }

    /**
     * 参数类型异常--参数需求类型和实际类型不匹配
     * @return
     */
    @RequestMapping(value = "/methodArgumentTypeMismatchException")
    public Map<String, Object> methodArgumentTypeMismatchException() {
        return new ResultMap()
                .setResult(ErrorCode.Method_Argument_Type_Mismatch_Exception.getValue())
                .appendParameter(ErrorCode.Method_Argument_Type_Mismatch_Exception.getValue()
                        , ErrorCode.Method_Argument_Type_Mismatch_Exception.getDesc())
                .send();
    }

    /**
     * 参数缺失
     * @return
     */
    @RequestMapping(value = "/missingServletRequestParameterException")
    public Map<String, Object> missingServletRequestParameterException() {
        return new ResultMap()
                .setResult(ErrorCode.Missing_Servlet_Request_Parameter_Exception.getValue())
                .appendParameter(ErrorCode.Missing_Servlet_Request_Parameter_Exception.getValue()
                        , ErrorCode.Missing_Servlet_Request_Parameter_Exception.getDesc())
                .send();
    }

    /**
     * 字段长度不符合要求
     * @return
     */
    @RequestMapping(value = "/constraintViolationException")
    public Map<String, Object> constraintViolationException() {
        return new ResultMap()
                .setResult(ErrorCode.Constraint_Violation_Exception.getValue())
                .appendParameter(ErrorCode.Constraint_Violation_Exception.getValue()
                        , ErrorCode.Constraint_Violation_Exception.getDesc())
                .send();
    }

    /**
     * 没有查询到数据异常
     * @return
     */
    @RequestMapping(value = "/slectException")
    public Map<String, Object> slectException() {
        return new ResultMap()
                .setResult(ErrorCode.SELECT_EXCEPTION.getValue())
                .appendParameter(ErrorCode.SELECT_EXCEPTION.getValue()
                        , ErrorCode.SELECT_EXCEPTION.getDesc())
                .send();
    }


}
