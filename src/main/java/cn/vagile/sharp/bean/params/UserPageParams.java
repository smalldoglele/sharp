package cn.vagile.sharp.bean.params;

import cn.vagile.sharp.bean.object.PageParams;
import lombok.Data;

@Data
public class UserPageParams extends PageParams {
    private String userName;
    private String email;
}
