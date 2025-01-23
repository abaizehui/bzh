package com.bzh.common.core.domain.entity;

import com.bzh.common.annotation.Excel;
import com.bzh.common.annotation.Excel.ColumnType;
import com.bzh.common.annotation.Excel.Type;
import com.bzh.common.annotation.Excels;
import com.bzh.common.core.domain.BaseEntity;
import com.bzh.common.xss.Xss;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * 用户对象 sys_user
 *
 * @author bzh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUpdatePwd
{

    private String oldPassword;

    private String newPassword;
}
