package fun.neverth.icibei.sysadmin.organization.entity.form;


import fun.neverth.icibei.sysadmin.organization.entity.param.GroupQueryParam;
import fun.neverth.icibei.common.web.form.BaseQueryForm;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * todo
 *
 * @author NeverTh
 * @date 2020/7/23 22:15
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GroupQueryForm extends BaseQueryForm<GroupQueryParam> {

    @NotBlank(message = "用户组名称不能为空")
    private String name;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past(message = "查询开始时间必须小于当前日期")
    private Date createdTimeStart;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past(message = "查询结束时间必须小于当前日期")
    private Date createdTimeEnd;
}
