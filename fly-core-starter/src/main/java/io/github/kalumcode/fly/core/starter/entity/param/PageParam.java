package io.github.kalumcode.fly.core.starter.entity.param;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 分页参数 Param
 *
 * @date: 2020/10/21
 **/
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class PageParam implements Serializable {

    /**
     * 第几页，默认1
     */
    private Integer page = 1;

    /**
     * 每页获取多少条数据，默认10
     */
    private Integer size = 20;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        if (page == null) {
            page = 1;
        }
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        if (size == null) {
            size = 20;
        }
        this.size = size;
    }
}

