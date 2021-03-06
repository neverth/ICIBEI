package fun.neverth.icibei.organization.entity.form;

import fun.neverth.icibei.organization.entity.po.Position;
import fun.neverth.icibei.common.web.form.BaseForm;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * todo
 *
 * @author NeverTh
 * @date 2020/7/23 22:18
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PositionForm extends BaseForm<Position> {

    @NotBlank(message = "职位名称不能为空")
    private String name;

    private String description;
}
