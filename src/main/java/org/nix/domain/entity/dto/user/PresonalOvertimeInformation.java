package org.nix.domain.entity.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.log4j.Logger;
import org.nix.dao.service.OvertimeRecordService;
import org.nix.dao.service.UserService;
import org.nix.dao.service.utils.Page;
import org.nix.domain.entity.User;
import org.nix.domain.entity.dto.ResultDto;
import org.nix.exception.AuthorizationException;
import org.nix.exception.IdentityOverdueException;
import org.nix.utils.SystemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by zhangpe0312@qq.com on 2018/3/11.
 * <p>
 * 分页返回用户的加班信息
 */
@Service
public class PresonalOvertimeInformation implements ResultDto {
    //日志记录
    private static Logger logger = Logger.getLogger(PresonalOvertimeInformation.class);

    @Autowired
    private OvertimeRecordService overtimeRecordService;

    @Autowired
    private UserService userService;

    //加班信息
    private List records = new ArrayList();
    //加班总条数
    private int total;

    private int limit = 10;

    private int currentPage = 1;


    @Override
    public ResultDto resultDto(Object... objects) throws AuthorizationException {
        if (SystemUtil.parameterNull(objects)) {
            throw new IdentityOverdueException();
        }
        User user;
        //因为是查一个人的，所以只取第一个值
        user = (User) objects[0];
        user = userService.findById(user.getId());

        Page recordPage = overtimeRecordService.findOvertimeRecordByUser(user);
        total = recordPage.getTotal();
        records = recordPage.getPageList(limit, currentPage);
        return this;
    }

    public List getRecords() {
        return records;
    }

    public PresonalOvertimeInformation setRecords(List records) {
        this.records = records;
        return this;
    }

    public int getTotal() {
        return total;
    }

    public PresonalOvertimeInformation setTotal(int total) {
        this.total = total;
        return this;
    }

    public PresonalOvertimeInformation setLimit(int limit) {
        this.limit = limit;
        return this;
    }

    public PresonalOvertimeInformation setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        return this;
    }


}
