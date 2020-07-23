package fun.neverth.icibei.sysadmin.organization.entity.param;

import fun.neverth.icibei.sysadmin.organization.entity.po.Group;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * todo
 *
 * @author NeverTh
 * @date 2020/7/23 21:47
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupQueryParam extends BaseParam<Group> {
    private String name;
}
