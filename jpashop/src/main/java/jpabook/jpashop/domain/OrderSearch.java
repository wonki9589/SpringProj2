package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.common.util.StringHelper;
@Getter @Setter
public class OrderSearch {

    private String memberName;
    private String orderStatus;
}
